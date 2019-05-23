package br.com.syngenta.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.syngenta.exception.XMLUtilsBusinessException;
import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Party;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Party.Identification;

@Component
public class XMLUtils extends DocumentFolder  {
	
	private static final Logger log = LogManager.getLogger(PDFUtils.class.getName());
	private static final Integer versionXml = 310;
	private static final String documentTypeXml = "DocumentFolder";
	private static final String senderId = "OSGT";
	private static final String receiverId = "SYNGENTA";
	private static final String messageFunctionCodeXml = "OriginalMerge";
	private static final String encodingCodeXml = "Base64";
	private static final String mimeTypeXml = "application/pdf";
	private static final String jaxbEncoding = "UTF-8";
	
	//PDF para o XML
	public void jaxbObjectToXML(DocumentFolder documentFolder, String fileName) throws Exception {
		log.debug("[PDFUtils] - Iniciando geracao do arquivo XML: {}", fileName);
		
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, jaxbEncoding);
 
            OutputStream os = new FileOutputStream( fileName );
            jaxbMarshaller.marshal( documentFolder, os );
            
            log.debug("[PDFUtils] - Fim da geracao do arquivo XML: {}", fileName);
            
        } catch (Exception e) {
			throw new XMLUtilsBusinessException(MessageEnum.XML_UTILS_ERROR_001,e);
        }
    }
	
	//XML para PDF
	public DocumentFolder xmlToJaxbObject(File file) throws Exception {
		log.debug("[PDFUtils] - Carregando arquivo {} XML", file.getName());
		
		DocumentFolder documentFolder = null;
        try {
        	JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);

    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		documentFolder = (DocumentFolder) jaxbUnmarshaller.unmarshal(file);

            log.debug("[PDFUtils] - Fim carregando arquivo {} XML", file.getName());
            return documentFolder;
            
        } catch (JAXBException e) {
			throw new XMLUtilsBusinessException(MessageEnum.XML_UTILS_ERROR_002,e);
        }
    }
	
	public void createDocumentFolderDrtailParty(DocumentFolderDetail dfDetail, String partyRole, String type, String value) throws Exception {
		log.debug("[PDFUtils] - Criando no xml <party> -> Party Role: {}, type: {}, Value: {}", partyRole, type, value);
		
		Party party = new Party();
		party.setPartyRoleCode(partyRole);
		
		Identification idt = new Identification();
		idt.setType(type);
		idt.setValue(value);
		
		party.setIdentification(idt);
		
		dfDetail.getParty().add(party);
		
		log.debug("[PDFUtils] - Fim criar no xml <party> -> Party Role: {}, type: {}, Value: {}", partyRole, type, value);
	}

	public DocumentFolderDetail createDocumentFolderDetail(String delivery, String orderNumber) throws Exception {
		log.debug("[PDFUtils] - Criando no xml <CurrentFolderDetail>: delivery: {}, orderNumber: {}", delivery, orderNumber);
		
		DocumentFolderDetail dfDetail = new DocumentFolderDetail();
		dfDetail.setMessageFunctionCode(messageFunctionCodeXml);
		dfDetail.getDeliveryNumber().add(delivery);
		dfDetail.getOrderNumber().add(orderNumber);

		log.debug("[PDFUtils] - Fim criando no xml <CurrentFolderDetail>: delivery: {}, orderNumber: {}", delivery, orderNumber);
		return dfDetail;
	}

	public Header createDocumentFolderHeader() throws Exception {
		log.debug("[PDFUtils] - Criando no xml <header>");
		
		Header dfHeader = new Header();
		dfHeader.setVersion(versionXml);
		dfHeader.setDocumentType(documentTypeXml);
		dfHeader.setSenderId(senderId);
		dfHeader.setReceiverId(receiverId);
		
		log.debug("[PDFUtils] - Fim criando no xml <header>");
		return dfHeader;
	}
	
	public Document createDocument(String pdfBase64, String fileName) throws Exception {
		log.debug("[PDFUtils] - Criando no xml <document>");
		
		Document doc = new Document();
		doc.setName(fileName);
		doc.setEncodingCode(encodingCodeXml);
		doc.setMimeType(mimeTypeXml);
		doc.setDocumentTypeCode(encodingCodeXml); //TODO veriricar
		doc.setContent(pdfBase64);
		
		log.debug("[PDFUtils] - Fim criando no xml <document>");
		return doc;
	}
	
	public DocumentFolder createDocumentFolder(Header dfHeader, DocumentFolderDetail dfDetail) throws Exception {
		log.debug("[PDFUtils] - Criando no xml <DocumentFolder>");
		
		DocumentFolder xmlFinal = new DocumentFolder();
		xmlFinal.setHeader(dfHeader);
		xmlFinal.getDocumentFolderDetail().add(dfDetail);
		
		log.debug("[PDFUtils] - Fim criando no xml <DocumentFolder>");
		return xmlFinal;
	}

	public String getTagContentXml(File fileXml) throws Exception {
		log.debug("[PDFUtils] - Buscando tag <content> no xml {}", fileXml.getName());
		
		DocumentFolder df =  this.xmlToJaxbObject(fileXml);
		
		DocumentFolderDetail dfDetail = df.getDocumentFolderDetail().get(0);
		
		String pdfBase64 = dfDetail.getDocument().getContent();
		
		log.debug("[PDFUtils] - Fim buscando tag <content> no xml {}", fileXml.getName());
		return pdfBase64;
	}

}
