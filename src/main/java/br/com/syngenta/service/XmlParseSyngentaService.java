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
    public static final String IS_IMPORT_CUSTOMS = "isImportCustoms";
    public static final String DOCUMENT_TYPE_CODE = "documentTypeCode";
    public static final String DELIVERY_NUMBER = "deliveryNumber";
    public static final String ORDER_NUMBER = "orderNumber";
    public static final String SHIPMENT_NUMBER = "shipmentNumber";
    public static final String XML = ".XML";
    public static final String CONTENT = "content";
    public static final String PDF = ".pdf";

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


        // verificando arquivos do diretorio de xml´s de origem
        listFilesXmls = fileUtils.readFilesFromPath(xmlSourceDirectory, XML);

        // percorre a lista de arquivos xmls e gera o pdf para cada um
        for (int i = 0; i < listFilesXmls.size(); i++) {
            String fileName = listFilesXmls.get(i);
            String fileNameXmlBkpError = fileUtils.addTimestampToFileName(fileName);

            try {
                String pathFileNameXml = xmlSourceDirectory + fileName;
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

                String pathFileNamePdfTarget = pdfTargetDirectory + pdfFileName + PDF;

                File pdf = new File(pathFileNamePdfTarget);
                String pdfBase64 = xmlUtils.getTagXml(fileXml, CONTENT);
                pdfUtils.decodeBase64(pdf, pdfBase64);

                fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);


            } catch (Exception e) {
                log.error("[XML_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", fileName, Throwables.getStackTraceAsString(e));
                fileUtils.moveFile(xmlSourceDirectory + fileName, xmlErrorDirectory + fileNameXmlBkpError);
            }
        }


    }

}
