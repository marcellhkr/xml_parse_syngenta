package br.com.syngenta.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

import br.com.syngenta.util.FileUtils;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.XMLUtils;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;
import br.com.syngenta.xml.mapper.DocumentFolder.Header;

@Service
public class PdfParseSyngentaService {
	
	private static final Logger log = LogManager.getLogger(PdfParseSyngentaService.class.getName());
	
	@Autowired
	PDFUtils pdfUtils;	
	
	@Autowired
	XMLUtils xmlUtils;
	
	@Autowired
	FileUtils fileUtils;
	
	@Value("${property.pdf.source.directory}")
	String pdfSourceDirectory;
	
	@Value("${property.pdf.bkp.directory}")
	String pdfBkpDirectory;
	
	@Value("${property.pdf.error.directory}")
	String pdfErrorDirectory;
	
	@Value("${property.pdf.xml.target.directory}")
	String xmlTargetDirectory;
	
	public void runService() {
		
		List<String> listFilesPDFs = null;
		
		try {
			
			// verificando arquivos do diretorio de pdf´s de origem
			listFilesPDFs = fileUtils.readFilesFromPath(pdfSourceDirectory,".PDF");
			
			// percorre a lista de arquivos pdf e gera o xml para cada um
			for (int i=0;i<listFilesPDFs.size();i++) {
				
				try {
					
					String pathFileNamePdf = pdfSourceDirectory + listFilesPDFs.get(i);
					String pathFileNameBkpPdf = pdfBkpDirectory + listFilesPDFs.get(i);
					
					String pdfBase64 = pdfUtils.encodeBase64(pathFileNamePdf);
					
					// Message Header
					Header dfHeader = xmlUtils.createDocumentFolderHeader();
					
					// Documento Folder Detail
					//TODO verificar de onde pegar delivery e ordernumber
					DocumentFolderDetail dfDetail = xmlUtils.createDocumentFolderDetail("","");
					
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
					xmlUtils.jaxbObjectToXML(xmlFinal, xmlTargetDirectory + fileName);
					
					fileUtils.moveFile(pathFileNamePdf, pathFileNameBkpPdf);

				} catch (Exception e) {
					log.error("[PDF_SERVICE] - Erro ao processar arquivo {}. ERRO: {}", listFilesPDFs.get(i), Throwables.getStackTraceAsString(e));
					try {
						fileUtils.moveFile(pdfSourceDirectory + listFilesPDFs.get(i), pdfErrorDirectory + listFilesPDFs.get(i));
					} catch (Exception ex) {
						log.error("[PDF_SERVICE] - Erro ao mover o arquivo {}. ERRO: {}", listFilesPDFs.get(i), Throwables.getStackTraceAsString(e));
					}
				}				
				
			}
			
		} catch (Exception e) {
			log.error("[PDF_SERVICE] - Erro ao ler arquivos do diretorio: {} ERRO: {}", pdfSourceDirectory, Throwables.getStackTraceAsString(e)); 
		}
		
	}

}
