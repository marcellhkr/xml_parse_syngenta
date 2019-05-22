package br.com.syngenta.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.syngenta.exception.PDFUtilsBusinessException;
import br.com.syngenta.message.MessageEnum;

import com.google.common.base.Throwables;

@Component
public class PDFUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PDFUtils.class);
	
	public String encodeBase64(String sourceFile) throws PDFUtilsBusinessException {
		log.info("[PDFUtils] - Iniciando conversao do arquivo {} para base64", sourceFile);
		
		String encodedPDF = "";
		try {			
			
			byte[] base64EncodedData = Base64.encodeBase64(this.loadFileAsBytesArray(sourceFile), true);
			
			encodedPDF = this.writeByteArraysToString(base64EncodedData);
			
		} catch (Exception e) {
			log.error("[PDFUtils] - Erro ao converter arquivo {} para base64: Erro: {}", sourceFile, Throwables.getStackTraceAsString(e));
			throw new PDFUtilsBusinessException(MessageEnum.PDF_UTILS_ERROE_001,e,sourceFile);
		}
		
		log.info("[PDFUtils] - Fim da conversao do arquivo {} para base64", sourceFile);
		return encodedPDF;
		
	}
	
	public File decodeBase64(File file, String base64File) throws Exception {
		log.info("[PDFUtils] - Iniciando desconversao de base64 para arquivo pdf");
        
		File filePDF = null;
		
		try {		
			
			byte[] decodedBytes = Base64.decodeBase64(loadStringAsBytesArray(base64File));
			
			filePDF = this.writeByteArraysToFile(file,decodedBytes);

			log.info("[PDFUtils] - Fim da desconversao de base64 para arquivo pdf");
			return filePDF;
			
		} catch (Exception e) {
			log.error("[PDFUtils] - Erro ao desconverter base64 para arquivo pdf: Erro: {}", Throwables.getStackTraceAsString(e));
			throw new PDFUtilsBusinessException(MessageEnum.PDF_UTILS_ERROE_002,e);
		}	
		
	}
	
	
	private byte[] loadFileAsBytesArray(String fileName) throws Exception {
		log.info("[PDFUtils] - Carregando arquivo e transformando para bytes array");

		File file = new File(fileName);	       
		int length = (int) file.length();        
		BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));        
		byte[] bytes = new byte[length];        
        reader.read(bytes, 0, length);        
        reader.close();
        
        log.info("[PDFUtils] - Fim de carregar o arquivo e transformando para bytes array");
        
        return bytes;
    }
	
	private byte[] loadStringAsBytesArray(String base64File) throws Exception {
		log.info("[PDFUtils] - Transformando de String base64 para Bytes");

		byte[] bytes = base64File.getBytes("UTF-8");
        
        log.info("[PDFUtils] - Fim de Transformando de String base64 para Bytes");
        
        return bytes;
    }
	
	private String writeByteArraysToString(byte[] bytes) throws Exception {
		log.info("[PDFUtils] - Transformando arquivo de bytes para String (base64)");
		
		String base64 = new String(bytes, StandardCharsets.UTF_8);	
		
		log.info("[PDFUtils] - Fim Transformando arquivo de bytes para String (base64)");
		return base64;
		
	}
	
	private File writeByteArraysToFile(File file, byte[] content) throws Exception {

        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
        
        return file;

    }

}
