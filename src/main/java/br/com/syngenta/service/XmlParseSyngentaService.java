package br.com.syngenta.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

import br.com.syngenta.exception.PDFUtilsBusinessException;
import br.com.syngenta.exception.XMLUtilsBusinessException;
import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.XMLUtils;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;

import java.util.List;

@Service
public class XmlParseSyngentaService {
	
	private static final Logger log = LoggerFactory.getLogger(XmlParseSyngentaService.class);
	
	@Autowired
	PDFUtils pdfUtils;	
	
	@Autowired
	XMLUtils xmlUtils;
	
	@Autowired
	FileUtils fileUtils;
	
	@Value("${property.pdf.source.directory}")
	String pdfSourceDirectory;
	
	@Value("${property.pdf.target.directory}")
	String pdfTargetDirectory;
	
	@Value("${property.xml.source.directory}")
	String xmlSourceDirectory;
	
	@Value("${property.xml.target.directory}")
	String xmlTargetDirectory;
	
	public void runService() {
		
		
		List<String> listFilesPDFs = null;
		List<String> listFilesXmls = null;
		try {

			// verificando arquivos do diretorio de pdf´s de origem
			listFilesPDFs = fileUtils.readFilesFromPath(pdfSourceDirectory,".PDF");

			// percorre a lista de arquivos pdf e gera o xml para cada um
			for (int i=0;i<listFilesPDFs.size();i++) {
				
				try {
					String sourceFile = listFilesPDFs.get(i);
					
					String pdfBase64 = pdfUtils.encodeBase64(sourceFile);
					
					// Message Header
					DocumentFolder.Header dfHeader = xmlUtils.createDocumentFolderHeader();
					
					// Documento Folder Detail
					//TODO verificar de onde pegar delivery e ordernumber
					DocumentFolder.DocumentFolderDetail dfDetail = xmlUtils.createDocumentFolderDetail("","");
					
					// Document Folder Party - DocumentProvider/DocumentOwner
					xmlUtils.createDocumentFolderDrtailParty(dfDetail,"DocumentProvider","DOC_PROVIDER_ID","OSGT");
					xmlUtils.createDocumentFolderDrtailParty(dfDetail,"DocumentOwner","DOC_OWNER_ID","SYNGENTA");
					
					// Document
					String fileName = "teste.xml"; //TODO verificar como criar o nome
					Document doc = xmlUtils.createDocument(pdfBase64,fileName);
					
					dfDetail.setDocument(doc);
					
					// monta xmlfinal
					DocumentFolder xmlFinal = xmlUtils.createDocumentFolder(dfHeader, dfDetail);

					//gera o arquivo
					xmlUtils.jaxbObjectToXML(xmlFinal, xmlTargetDirectory + "teste.xml");

				} catch (Exception e) {
					log.error("Erro ao processar arquivo {}. ERRO: {}", listFilesPDFs.get(i), Throwables.getStackTraceAsString(e));
					//TODO verificar se move o arquivo para diretorio de erros
				}				
				
			}
			
			// verificando arquivos do diretorio de xml´s de origem
			listFilesXmls = fileUtils.readFilesFromPath(xmlSourceDirectory,".XML");

			// percorre a lista de arquivos xmls e gera o pdf para cada um
			for (int i=0;i<listFilesXmls.size();i++) {
				
				try {
					
					String sourceFile = listFilesXmls.get(i);
					
					File fileXml = new File(sourceFile);
					
					String fileName = pdfTargetDirectory + "teste.pdf";
					
					File pdf = new File(fileName); //TODO verificar nome
					
					String pdfBase64 = xmlUtils.getTagContentXml(fileXml);
					
					pdf = pdfUtils.decodeBase64(pdf, pdfBase64);
				

				} catch (PDFUtilsBusinessException | XMLUtilsBusinessException e) {
					log.error("Erro ao processar arquivo {}. ERRO: {}", listFilesXmls.get(i), Throwables.getStackTraceAsString(e));
					//TODO verificar se move o arquivo para diretorio de erros
				}	
			}
			
			System.out.println("tste");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
