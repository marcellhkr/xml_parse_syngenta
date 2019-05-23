package br.com.syngenta.service;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.XMLUtils;

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

	public void runService() {
		
		
		List<String> listFilesXmls = null;
		try {
			
			// verificando arquivos do diretorio de xml´s de origem
			listFilesXmls = fileUtils.readFilesFromPath(xmlSourceDirectory,".XML");

			// percorre a lista de arquivos xmls e gera o pdf para cada um
			for (int i=0;i<listFilesXmls.size();i++) {
				
				try {
					
					String pathFileNameXml = xmlSourceDirectory + listFilesXmls.get(i);
					String pathFileNameBkpXml = xmlBkpDirectory + listFilesXmls.get(i);
					
					File fileXml = new File(pathFileNameXml);
					
					String pathFileNamePdfTarget = pdfTargetDirectory + "teste.pdf";
					
					File pdf = new File(pathFileNamePdfTarget); //TODO verificar nome
					
					String pdfBase64 = xmlUtils.getTagContentXml(fileXml);
					
					pdf = pdfUtils.decodeBase64(pdf, pdfBase64);
				
					fileUtils.moveFile(pathFileNameXml, pathFileNameBkpXml);

				} catch (Exception e) {
					log.error("[XML_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(e));
					fileUtils.moveFile(xmlSourceDirectory + listFilesXmls.get(i), xmlErrorDirectory + listFilesXmls.get(i));
				}	
			}
			
		} catch (Exception e) {
			log.error("[XML_SERVICE] - Erro ao ler arquivos do diretorio: {} ERRO: {}", xmlSourceDirectory, Throwables.getStackTraceAsString(e));
		}
		
	}
	
}
