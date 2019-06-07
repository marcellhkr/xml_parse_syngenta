package br.com.syngenta.service;

import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.SftpUtil;
import br.com.syngenta.util.XMLUtils;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;
import com.google.common.base.Throwables;
import com.jcraft.jsch.ChannelSftp;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


@Service
public class PdfParseSyngentaService {

    private static final Logger log = LogManager.getLogger(PdfParseSyngentaService.class.getName());

    @Autowired
    PDFUtils pdfUtils;

    @Autowired
    XMLUtils xmlUtils;

    @Autowired
    FileUtils fileUtils;
    
    @Autowired
    SftpUtil sftpUtil;

    @Value("${property.pdf.source.directory}")
    String pdfSourceDirectory;

    @Value("${property.pdf.bkp.directory}")
    String pdfBkpDirectory;

    @Value("${property.pdf.error.directory}")
    String pdfErrorDirectory;

    @Value("${property.pdf.xml.tmp.directory}")
    String xmlTmpDirectory;
    
    @Value("${property.config.source.target.xml}")
    String configSourceXml;
    
    @Value("${property.host.sftp}")
    String sftpHost;
    
    @Value("${property.port.sftp}")
    int sftpPort;
    
    @Value("${property.user.sftp}")
    String sftpUser;
    
    @Value("${property.pass.sftp}")
    String sftpPassword;
    
    @Value("${property.workingdir.sftp.in}")
    String sftpWorkingDir;

    public void runService() {

    	pdfSourceDirectory = pdfSourceDirectory.replace("/", "\\").replace("EXPORTACAO", "EXPORTAÇÃO");
    	pdfBkpDirectory = pdfBkpDirectory.replace("/", "\\").replace("EXPORTACAO", "EXPORTAÇÃO");
    	pdfErrorDirectory = pdfErrorDirectory.replace("/", "\\").replace("EXPORTACAO", "EXPORTAÇÃO");
    	xmlTmpDirectory = xmlTmpDirectory.replace("/", "\\");
    	
        List<String> listFilesPDFs = null;
        
        //verifica se precisa criar o diretorio temporario
        String tmpDir = "";
        try {
        	tmpDir = fileUtils.createDir(System.getProperty("user.dir") + File.separator + xmlTmpDirectory);
		} catch (InterruptedException e1) {
		}

        // verificando arquivos do diretorio de pdf´s de origem
        listFilesPDFs = fileUtils.readFilesFromPath(pdfSourceDirectory, ".PDF");

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
                String orderNumber = fileUtils.getOrderDeliveryNumber(fileNamePdf, "ordernumber");
                String deliveryNumber = fileUtils.getOrderDeliveryNumber(fileNamePdf, "deliverynumber");
                String fileName = fileUtils.addTimestampToFileName("SyngentaDocumentFolderInbound.xml");
                Document doc = xmlUtils.createDocument(pdfBase64, fileName);
                xmlFinal.getDocumentFolderDetail().add(xmlUtils.createDocumentFolderDetail(deliveryNumber, orderNumber,doc));

                //gera o arquivo
                xmlUtils.jaxbObjectToXML(xmlFinal, tmpDir + fileName);

                if (configSourceXml.equals("sftp")) {
                	try {
                		ChannelSftp channelSftp = sftpUtil.connectSftp(sftpHost, sftpPort, sftpUser, sftpPassword);
                		sftpUtil.putFileSftp(channelSftp, tmpDir + fileName, sftpWorkingDir);
                		channelSftp.disconnect();
                		//File fileDelete = new File(tmpDir + fileName);
                		//fileDelete.delete();
                	} catch (Exception e) {
                		log.error(Throwables.getStackTraceAsString(e));
                	}
                } 
                
                fileUtils.moveFile(pathFileNamePdf, pathFileNameBkpPdf);
                

            } catch (Exception e) {
                log.error("[PDF_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", file, Throwables.getStackTraceAsString(e));
                fileUtils.moveFile(pdfSourceDirectory + file, pdfErrorDirectory + fileNamePdfBkp);
            }

        }
    }


}
