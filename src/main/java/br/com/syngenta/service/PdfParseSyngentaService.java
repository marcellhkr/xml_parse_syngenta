package br.com.syngenta.service;

import br.com.syngenta.util.*;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;
import com.google.common.base.Throwables;
import com.jcraft.jsch.ChannelSftp;


import com.jcraft.jsch.JSchException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service
public class PdfParseSyngentaService {

    private static final Logger log = LogManager.getLogger(PdfParseSyngentaService.class.getName());
    public static final String PDF = ".pdf";
    public static final String SFTP = "sftp";
    public static final String DIR = "dir";

    @Value("${property.pdf.source.directory}")
    public String pdfSourceDirectory;

    @Value("${property.pdf.bkp.directory}")
    public String pdfBkpDirectory;

    @Value("${property.pdf.error.directory}")
    public String pdfErrorDirectory;

    @Value("${property.config.source.target.xml}")
    public String configSourceXml;

    @Value("${property.pdf.xml.tmp.directory}")
    public String xmlTmpDirectory;

    @Value("${property.host.sftp}")
    public String sftpHost;

    @Value("${property.port.sftp}")
    int sftpPort;

    @Value("${property.user.sftp}")
    public String sftpUser;

    @Value("${property.pass.sftp}")
    public String sftpPassword;

    @Value("${property.workingdir.sftp.in}")
    public String sftpWorkingDir;

    @Value("${property.file.name.xml}")
    public String fileTargetName;


    @Autowired
    public PDFUtils pdfUtils;

    @Autowired
    public XMLUtils xmlUtils;

    @Autowired
    public FileUtils fileUtils;

    @Autowired
    public SftpUtil sftpUtil;

    private ChannelSftp channelSftp;


    public void runService() {
        List<String> listFilesPDFs = new ArrayList<String>();

        // verificando arquivos do diretorio de pdf´s de origem
        listFilesPDFs = fileUtils.readFilesFromPath(pdfSourceDirectory, PDF);

        fileUtils.createDir(pdfBkpDirectory);
        fileUtils.createDir(pdfErrorDirectory);
        if (configSourceXml.equals(SFTP) && !listFilesPDFs.isEmpty()) {
            try {
                channelSftp = sftpUtil.connectSftp(sftpHost, sftpPort, sftpUser, sftpPassword);

            } catch (JSchException e) {
                log.error("Erro ao conectar no SFTP",e.getMessage());
                return;
            }
        }


        // percorre a lista de arquivos pdf e gera o xml para cada um
        for (int i = 0; i < listFilesPDFs.size(); i++) {
            String file = listFilesPDFs.get(i);
            String fileNamePdf = file;
            String fileNamePdfBkp = fileUtils.addTimestampToFileName(fileNamePdf);
            try {

                String pathFileNamePdf = pdfSourceDirectory + file;
                String pathFileNameBkpPdf = pdfBkpDirectory + fileNamePdfBkp;

                String pdfBase64 = pdfUtils.encodeBase64(pathFileNamePdf);

                DocumentFolder xmlFinal = new DocumentFolder();
                // Message Header
                xmlFinal.setHeader(xmlUtils.createDocumentFolderHeader());

                // Documento Folder Detail
                String shippingNumber = fileUtils.getOrderDeliveryNumber(fileNamePdf, 0);
                String deliveryNumber = fileUtils.getOrderDeliveryNumber(fileNamePdf, 1);

                String docType = fileUtils.getOrderDeliveryNumber(fileNamePdf, 2);
                //String fileName = fileUtils.addTimestampToFileName(fileTargetName);
                //gera o arquivo
                File tempFile = File. createTempFile(fileTargetName, ".xml");
                Document doc = xmlUtils.createDocument(pdfBase64, tempFile.getName(), docType);
                xmlFinal.getDocumentFolderDetail().add(xmlUtils.createDocumentFolderDetail(deliveryNumber, shippingNumber,doc));


                xmlUtils.jaxbObjectToXML(xmlFinal, tempFile);

                if (configSourceXml.equals(SFTP)) {
                	try {
                		sftpUtil.putFileSftp(channelSftp, tempFile, sftpWorkingDir);
                	} catch (Exception e) {
                		log.error(Throwables.getStackTraceAsString(e));
                	}
                }else if(configSourceXml.equals(DIR)){
                    tempFile.renameTo(new File(pdfSourceDirectory + tempFile.getName()));
                }

                fileUtils.moveFile(pathFileNamePdf, pathFileNameBkpPdf);


            } catch (Exception e) {
                log.error("[PDF_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", file, Throwables.getStackTraceAsString(e));
                fileUtils.moveFile(pdfSourceDirectory + file, pdfErrorDirectory + fileNamePdfBkp);
            }
        }
        if (configSourceXml.equals(SFTP)) {
            channelSftp.disconnect();
        }
    }


}
