package br.com.syngenta.util;

import br.com.syngenta.exception.BusinessException;
import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Party;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Party.Identification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.common.base.Throwables;

import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

@Component
public class XMLUtils extends DocumentFolder {

    private static final Logger log = LogManager.getLogger(PDFUtils.class.getName());
    private static final Integer versionXml = 310;
    private static final String documentTypeXml = "DocumentFolder";
    private static final String senderId = "SYNGENTA";
    private static final String receiverId = "OSGT";
    private static final String messageFunctionCodeXml = "OriginalMerge";
    private static final String encodingCodeXml = "Base64";
    private static final String mimeTypeXml = "application/pdf";
    private static final String jaxbEncoding = "UTF-8";

    //PDF para o XML
    public void jaxbObjectToXML(DocumentFolder documentFolder, File fileName) throws BusinessException{
        log.debug("[XMLUtils] - Iniciando geracao do arquivo XML: {}", fileName);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, jaxbEncoding);

            OutputStream os = new FileOutputStream(fileName);
            jaxbMarshaller.marshal(documentFolder, os);
            os.close();
            log.debug("[XMLUtils] - Fim da geracao do arquivo XML: {}", fileName);

        } catch (JAXBException | IOException  e) {
            throw  new BusinessException(MessageEnum.XML_UTILS_ERROR_001, e);
        }
    }

    //XML para PDF
    public DocumentFolder xmlToJaxbObject(File file) throws Exception {
        log.debug("[XMLUtils] - Carregando arquivo {} XML", file.getName());

        DocumentFolder documentFolder = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            documentFolder = (DocumentFolder) jaxbUnmarshaller.unmarshal(file);

            log.debug("[XMLUtils] - Fim carregando arquivo {} XML", file.getName());
            return documentFolder;

        } catch (JAXBException e) {
            throw new BusinessException(MessageEnum.XML_UTILS_ERROR_002, e);
        }
    }

    public Party createDocumentFolderDetailParty( String partyRole, String type, String value) {
        log.debug("[XMLUtils] - Criando no xml <party> -> Party Role: {}, type: {}, Value: {}", partyRole, type, value);

        Party party = new Party();
        party.setPartyRoleCode(partyRole);

        Identification idt = new Identification();
        idt.setType(type);
        idt.setValue(value);

        party.setIdentification(idt);

        DocumentFolderDetail docDetail = new DocumentFolderDetail();
        docDetail.getParty().add(party);

        return party;
    }

    public DocumentFolderDetail createDocumentFolderDetail(String delivery, String orderNumber, Document doc) throws Exception {
        log.debug("[XMLUtils] - Criando no xml <CurrentFolderDetail>: delivery: {}, orderNumber: {}", delivery, orderNumber);

        DocumentFolderDetail dfDetail = new DocumentFolderDetail();
        dfDetail.setMessageFunctionCode(messageFunctionCodeXml);
        dfDetail.getDeliveryNumber().add(delivery);
        dfDetail.getOrderNumber().add(orderNumber);
        dfDetail.setDocument(doc);
        // Document Folder Party - DocumentProvider/DocumentOwner
        dfDetail.getParty().add(createDocumentFolderDetailParty( "DocumentProvider", "DOC_PROVIDER_ID", "OSGT"));
        dfDetail.getParty().add(createDocumentFolderDetailParty( "DocumentOwner", "DOC_OWNER_ID", "SYNGENTA"));

        log.debug("[XMLUtils] - Fim criando no xml <CurrentFolderDetail>: delivery: {}, orderNumber: {}", delivery, orderNumber);
        return dfDetail;
    }

    public Header createDocumentFolderHeader() {
        log.debug("[XMLUtils] - Criando no xml <header>");

        Header dfHeader = new Header();
        dfHeader.setVersion(versionXml);
        dfHeader.setDocumentType(documentTypeXml);
        dfHeader.setSenderId(senderId);
        dfHeader.setReceiverId(receiverId);
        return dfHeader;
    }

    public Document createDocument(String pdfBase64, String fileName, String docType) throws Exception {
        log.debug("[XMLUtils] - Criando no xml <document>");

        Document doc = new Document();
        doc.setName(fileName);
        doc.setEncodingCode(encodingCodeXml);
        doc.setMimeType(mimeTypeXml);
        doc.setDocumentTypeCode(docType);
        doc.setContent(pdfBase64);

        log.debug("[XMLUtils] - Fim criando no xml <document>");
        return doc;
    }


//	public String getTagContentXml(File fileXml) throws Exception {
//		log.debug("[PDFUtils] - Buscando tag <content> no xml {}", fileXml.getName());
//		
//		DocumentFolder df =  this.xmlToJaxbObject(fileXml);
//		
//		DocumentFolderDetail dfDetail = df.getDocumentFolderDetail().get(0);
//		
//		String pdfBase64 = dfDetail.getDocument().getContent();
//		
//		log.debug("[PDFUtils] - Fim buscando tag <content> no xml {}", fileXml.getName());
//		return pdfBase64;
//	}

    public String getTagXml(File fileXml, String tag)  {
        log.debug("[XMLUtils] - Buscando tag <{}> no xml {}", tag, fileXml.getName());

        try {
            InputStream xmlStream = new FileInputStream(fileXml);
            InputSource is = new InputSource();
            is.setByteStream(xmlStream);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(is);

            String tagXml = doc.getElementsByTagName(tag).item(0).getTextContent();

            xmlStream.close();
            
            return tagXml;
        } catch (ParserConfigurationException | SAXException | NullPointerException| IOException e) {
            log.error("[XMLUtils] - Erro achar tag {} do arquivo {}",tag,  fileXml.getName(),e);
        }
        return "";
    }
    
}
