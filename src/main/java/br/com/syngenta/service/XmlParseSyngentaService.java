package br.com.syngenta.service;

import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.SftpUtil;
import br.com.syngenta.util.XMLUtils;
import com.google.common.base.Throwables;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Vector;

@Service
public class XmlParseSyngentaService {

    private static final Logger log = LogManager.getLogger(XmlParseSyngentaService.class.getName());
    public static final String IS_IMPORT_CUSTOMS = "isImportCustoms";
    public static final String DOCUMENT_TYPE_CODE = "documentTypeCode";
    public static final String DELIVERY_NUMBER = "billOfLadingNumber";
    public static final String ORDER_NUMBER = "demandPONumber";
    public static final String SHIPMENT_NUMBER = "shipmentNumber";
    public static final String DOC_TYPE = "documentTypeCode";
    public static final String XML = ".xml";
    public static final String CONTENT = "content";
    public static final String PDF = ".pdf";
    public static final String SFTP = "sftp";

    @Autowired
    PDFUtils pdfUtils;

    @Autowired
    XMLUtils xmlUtils;

    @Autowired
    FileUtils fileUtils;

    @Autowired
    SftpUtil sftpUtil;

    @Value("${property.xml.tmp.directory}")
    String xmlTmpDirectory;

    @Value("${property.xml.bkp.directory}")
    String xmlBkpDirectory;

    @Value("${property.xml.error.directory}")
    String xmlErrorDirectory;

    @Value("${property.xml.pdf.target.directory}")
    String pdfTargetDirectory;

    @Value("${property.json.ignore.document.type}")
    String ignoreDocumentTypes;

    @Value("${property.xml.pdf.read.directory:}")
    public String pdfReadDirectory;

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

    @Value("${property.workingdir.sftp.out}")
    String sftpWorkingDir;

    public void runService() {

        fileUtils.createDir(xmlBkpDirectory);
        fileUtils.createDir(xmlErrorDirectory);
        fileUtils.createDir(pdfReadDirectory);

        List<String> listFilesXmls = null;

        //verifica se precisa criar o diretorio temporario
        String tmpDir = "";

        if (configSourceXml.equals(SFTP)) {
            tmpDir = fileUtils.createDir(System.getProperty("user.dir") + File.separator + xmlTmpDirectory);
            try {
                ChannelSftp channelSftp = sftpUtil.connectSftp(sftpHost, sftpPort, sftpUser, sftpPassword);
                Vector<LsEntry> listFiles = sftpUtil.listFilesSftp(channelSftp, sftpWorkingDir);

                for (int i = 0; i < listFiles.size(); i++) {
                    try {
                        sftpUtil.getFileSftp(channelSftp, listFiles.get(i).getFilename(), tmpDir);
                    } catch (Exception e) {
                        log.error(Throwables.getStackTraceAsString(e));
                    }
                }
                channelSftp.disconnect();

            } catch (Exception e) {
                log.error(Throwables.getStackTraceAsString(e));
            }

        } else if (configSourceXml.equals("dir")) {
            tmpDir = pdfReadDirectory;
        }

        // verificando arquivos do diretorio temporario de xml´s
        listFilesXmls = fileUtils.readFilesFromPath(tmpDir, XML);

        // percorre a lista de arquivos xmls e gera o pdf para cada um
        for (int i = 0; i < listFilesXmls.size(); i++) {
            String fileName = listFilesXmls.get(i);
            String fileNameXmlBkpError = fileUtils.addTimestampToFileName(fileName);

            try {
                String pathFileNameXml = tmpDir + fileName;
                String pathFileNameBkpXml = xmlBkpDirectory + fileNameXmlBkpError;

                File fileXml = new File(pathFileNameXml);

                //verifica se deve gerar o pdf ou nao conforme config do properties
                String isImport = xmlUtils.getTagXml(fileXml, IS_IMPORT_CUSTOMS);
                String docTypeCode = xmlUtils.getTagXml(fileXml, DOCUMENT_TYPE_CODE);
                if (fileUtils.ignoreFile(docTypeCode, ignoreDocumentTypes, isImport)) {
                    fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);
                    continue;
                }

                //nome do arquivo destino
                String pdfFileName = "";
                String deliveryNumber = xmlUtils.getTagXml(fileXml, DELIVERY_NUMBER);
                String orderNumber = xmlUtils.getTagXml(fileXml, ORDER_NUMBER);
                String shipmentNumber = xmlUtils.getTagXml(fileXml, SHIPMENT_NUMBER);
                String docType = xmlUtils.getTagXml(fileXml, DOC_TYPE);

                pdfFileName = fileName(deliveryNumber, orderNumber, shipmentNumber,docType);

                String pathFileNamePdfTarget = pdfTargetDirectory + pdfFileName + PDF;

                File pdf = new File(pathFileNamePdfTarget);
                String pdfBase64 = xmlUtils.getTagXml(fileXml, CONTENT);
                pdfUtils.decodeBase64(pdf, pdfBase64);

                fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);


            } catch (Exception e) {
                log.error("[XML_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", fileName, Throwables.getStackTraceAsString(e));
                fileUtils.moveFile(tmpDir + fileName, xmlErrorDirectory + fileNameXmlBkpError);
            }
        }


    }

    private String fileName(String... fields) {
        String pdfFileName = "";
        for (String field : fields) {
            if (pdfFileName.isEmpty()) {
                pdfFileName += field;

            } else {
                pdfFileName += "_" + field;

            }
        }
        return pdfFileName;
    }
}

