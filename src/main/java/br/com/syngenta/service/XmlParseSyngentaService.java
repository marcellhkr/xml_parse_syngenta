package br.com.syngenta.service;

import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.XMLUtils;
import com.google.common.base.Throwables;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class XmlParseSyngentaService {

    private static final Logger log = LogManager.getLogger(XmlParseSyngentaService.class.getName());

    @Autowired
    PDFUtils pdfUtils;

    @Autowired
    XMLUtils xmlUtils;

    @Autowired
    FileUtils fileUtils;

    @Value("${property.xml.source.directory}")
    String xmlSourceDirectory;

    @Value("${property.xml.bkp.directory}")
    String xmlBkpDirectory;

    @Value("${property.xml.error.directory}")
    String xmlErrorDirectory;

    @Value("${property.xml.pdf.target.directory}")
    String pdfTargetDirectory;

    @Value("${property.json.ignore.document.type}")
    String ignoreDocumentTypes;

    public void runService() {


        List<String> listFilesXmls = null;
        try {

            // verificando arquivos do diretorio de xml´s de origem
            listFilesXmls = fileUtils.readFilesFromPath(xmlSourceDirectory, ".XML");

            // percorre a lista de arquivos xmls e gera o pdf para cada um
            for (int i = 0; i < listFilesXmls.size(); i++) {
                String fileNameXmlBkpError = "";

                try {

                    fileNameXmlBkpError = fileUtils.addTimestampToFileName(listFilesXmls.get(i));
                    String pathFileNameXml = xmlSourceDirectory + listFilesXmls.get(i);
                    String pathFileNameBkpXml = xmlBkpDirectory + fileNameXmlBkpError;

                    File fileXml = new File(pathFileNameXml);

                    //verifica se deve gerar o pdf ou nao conforme config do properties
                    String isImport = xmlUtils.getTagXml(fileXml, "isImportCustoms");
                    String docTypeCode = xmlUtils.getTagXml(fileXml, "documentTypeCode");
                    if (fileUtils.ignoreFile(docTypeCode, ignoreDocumentTypes, isImport)) {
                        try {
                            fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);
                        } catch (Exception e) {
                            log.error("[XML_SERVICE] - Erro ao mover o arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(e));
                        }
                        continue;
                    }

                    //nome do arquivo destino
                    String pdfFileName = "";
                    String deliveryNumber = xmlUtils.getTagXml(fileXml, "deliveryNumber");
                    String orderNumber = xmlUtils.getTagXml(fileXml, "orderNumber");
                    String shipmentNumber = xmlUtils.getTagXml(fileXml, "shipmentNumber");

                    if (!deliveryNumber.isEmpty()) {
                        pdfFileName += deliveryNumber;
                    }
                    if (!orderNumber.isEmpty()) {
                        if (pdfFileName.isEmpty()) {
                            pdfFileName += orderNumber;
                        } else {
                            pdfFileName += "-" + orderNumber;
                        }

                    }
                    if (!shipmentNumber.isEmpty()) {
                        if (pdfFileName.isEmpty()) {
                            pdfFileName += shipmentNumber;
                        } else {
                            pdfFileName += "-" + shipmentNumber;
                        }
                    }

                    String pathFileNamePdfTarget = pdfTargetDirectory + pdfFileName + ".pdf";

                    File pdf = new File(pathFileNamePdfTarget);

                    String pdfBase64 = xmlUtils.getTagXml(fileXml, "content");

                    pdf = pdfUtils.decodeBase64(pdf, pdfBase64);

                    try {
                        fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);
                    } catch (Exception e) {
                        log.error("[XML_SERVICE] - Erro ao mover o arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(e));
                    }

                } catch (Exception e) {
                    log.error("[XML_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(e));
                    try {
                        fileUtils.moveFile(xmlSourceDirectory + listFilesXmls.get(i), xmlErrorDirectory + fileNameXmlBkpError);
                    } catch (Exception ex) {
                        log.error("[XML_SERVICE] - Erro ao mover o arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(ex));
                    }
                }
            }

        } catch (Exception e) {
            log.error("[XML_SERVICE] - Erro ao ler arquivos do diretorio: {} ERRO: {}", xmlSourceDirectory, Throwables.getStackTraceAsString(e));
        }

    }

}
