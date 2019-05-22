package br.com.syngenta.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;

import br.com.syngenta.exception.XMLUtilsBusinessException;
import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.xml.mapper.DocumentFolder;

@Component
public class XMLUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PDFUtils.class);
	
	//PDF para o XML
	public void jaxbObjectToXML(DocumentFolder documentFolder, String fileName) throws Exception {
		log.info("[PDFUtils] - Iniciando geracao do arquivo XML: {}", fileName);
		
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
 
            OutputStream os = new FileOutputStream( fileName );
            jaxbMarshaller.marshal( documentFolder, os );
            
            log.info("[PDFUtils] - Fim da geracao do arquivo XML: {}", fileName);
            
        } catch (Exception e) {
        	log.error("[PDFUtils] - Erro ao gerar arquivo XML. Erro: {}", Throwables.getStackTraceAsString(e));
			throw new XMLUtilsBusinessException(MessageEnum.XML_UTILS_ERROR_001,e);
        }
    }
	
	//XML para PDF
	public DocumentFolder xmlToJaxbObject(File file) throws Exception {
		log.info("[PDFUtils] - Carregando arquivo {} XML", file.getName());
		
		DocumentFolder documentFolder = null;
        try {
        	JAXBContext jaxbContext = JAXBContext.newInstance(DocumentFolder.class);

    		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    		documentFolder = (DocumentFolder) jaxbUnmarshaller.unmarshal(file);

            log.info("[PDFUtils] - Fim carregando arquivo {} XML", file.getName());
            return documentFolder;
            
        } catch (JAXBException e) {
        	log.error("[PDFUtils] - Erro carregar arquivo XML. Erro: {}", Throwables.getStackTraceAsString(e));
			throw new XMLUtilsBusinessException(MessageEnum.XML_UTILS_ERROR_002,e);
        }
    }
	

}
