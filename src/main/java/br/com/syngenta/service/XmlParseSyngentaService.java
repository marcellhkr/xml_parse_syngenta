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
import br.com.syngenta.exception.XmlParseSyngentaServiceBusinessException;
import br.com.syngenta.message.MessageEnum;
import br.com.syngenta.util.PDFUtils;
import br.com.syngenta.util.XMLUtils;
import br.com.syngenta.xml.mapper.DocumentFolder;
import br.com.syngenta.xml.mapper.DocumentFolder.DocumentFolderDetail.Document;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class XmlParseSyngentaService 
{
	private static final Logger log = LoggerFactory.getLogger(XmlParseSyngentaService.class);
	
	@Autowired
	PDFUtils pdfUtils;	
	
	@Autowired
	XMLUtils xmlUtils;
	
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
			
			
			//
			// verificando arquivos do diretorio de pdf´s de origem
			//
			try (Stream<Path> walk = Files.walk(Paths.get(pdfSourceDirectory))) {

				listFilesPDFs = walk.map(x -> x.toString())
						.filter(f -> f.toUpperCase().endsWith(".PDF"))
						
						.collect(Collectors.toList());

			} catch (Exception e) {
				log.error("Error ao carregar arquivos pdf´s do diretorio {} de origem: ERRO: {}", pdfSourceDirectory, Throwables.getStackTraceAsString(e));
				throw new XmlParseSyngentaServiceBusinessException(MessageEnum.XLM_PARSER_SERVICE_ERROR_001,e);
			}
			
			//
			// percorre a lista de arquivos pdf e gera o xml para cada um
			//
			for (int i=0;i<listFilesPDFs.size();i++) {
				
				try {
					String sourceFile = listFilesPDFs.get(i);
					
					String pdfBase64 = pdfUtils.encodeBase64(sourceFile);
					
					// Message Header
					DocumentFolder.Header dfHeader = new DocumentFolder.Header();
					dfHeader.setVersion(310);
					dfHeader.setDocumentType("DocumentFolder");
					dfHeader.setSenderId("OSGT");
					dfHeader.setReceiverId("SYNGENTA");
					
					// Document Folder Detail
					DocumentFolder.DocumentFolderDetail dfDetail = new DocumentFolder.DocumentFolderDetail();
					dfDetail.setMessageFunctionCode("OriginalMerge");
					dfDetail.getDeliveryNumber().add("delivery"); //TODO Verificar de onde pegar
					dfDetail.getOrderNumber().add("order number"); // TODO Verificar de onde pegar
					
					// Document Folder Party - DocumentProvider
					DocumentFolder.DocumentFolderDetail.Party dfDetailPartyPovider = new DocumentFolder.DocumentFolderDetail.Party();
					dfDetailPartyPovider.setPartyRoleCode("DocumentProvider");
					
					DocumentFolder.DocumentFolderDetail.Party.Identification dfDetailPartyIdtProvider = new DocumentFolder.DocumentFolderDetail.Party.Identification();
					dfDetailPartyIdtProvider.setType("DOC_PROVIDER_ID");
					dfDetailPartyIdtProvider.setValue("OSGT");
					
					dfDetailPartyPovider.setIdentification(dfDetailPartyIdtProvider);
					
					dfDetail.getParty().add(dfDetailPartyPovider);
					
					// Document Folder Party - DocumentOwner
					DocumentFolder.DocumentFolderDetail.Party dfDetailPartyOwner = new DocumentFolder.DocumentFolderDetail.Party();
					dfDetailPartyOwner.setPartyRoleCode("DocumentOwner");
					
					DocumentFolder.DocumentFolderDetail.Party.Identification dfDetailPartyIdtOwner = new DocumentFolder.DocumentFolderDetail.Party.Identification();
					dfDetailPartyIdtOwner.setType("DOC_OWNER_ID");
					dfDetailPartyIdtOwner.setValue("SYNGENTA");
					
					dfDetailPartyOwner.setIdentification(dfDetailPartyIdtOwner);
					
					dfDetail.getParty().add(dfDetailPartyOwner);
					
					//TODO verificar como adicionar o node acima
					
					// Document Folder
					Document doc = new Document();
					doc.setName("teste.xml"); //TODO verificar qual o nome
					doc.setEncodingCode("Base64");
					doc.setMimeType("application/pdf");
					doc.setDocumentTypeCode("Base64"); //ODO veriricar
					doc.setContent(pdfBase64);
					
					dfDetail.setDocument(doc);
					
					// monta xmlfinal
					DocumentFolder xmlFinal = new DocumentFolder();
					xmlFinal.setHeader(dfHeader);
					xmlFinal.getDocumentFolderDetail().add(dfDetail);

					//gera o arquivo
					xmlUtils.jaxbObjectToXML(xmlFinal, xmlTargetDirectory + "teste.xml");

				} catch (PDFUtilsBusinessException | XMLUtilsBusinessException e) {
					//TODO verificar o que fazer qdo der erro
					//throw e;
					e.printStackTrace();
				}				
				
			}
			
			//
			// verificando arquivos do diretorio de xml´s de origem
			//
			try (Stream<Path> walk = Files.walk(Paths.get(xmlSourceDirectory))) {

				listFilesXmls = walk.map(x -> x.toString())
						.filter(f -> f.toUpperCase().endsWith(".XML"))
						
						.collect(Collectors.toList());

			} catch (Exception e) {
				log.error("Error ao carregar arquivos xml´s do diretorio {} de origem: ERRO: {}", xmlSourceDirectory, Throwables.getStackTraceAsString(e));
				throw new XmlParseSyngentaServiceBusinessException(MessageEnum.XLM_PARSER_SERVICE_ERROR_001,e);
			}
			//
			// percorre a lista de arquivos xmls e gera o pdf para cada um
			//

			for (int i=0;i<listFilesXmls.size();i++) {
				
				try {
					
					String sourceFile = listFilesXmls.get(i);
					
					File fileXml = new File(sourceFile);
					
					String fileName = pdfTargetDirectory + "teste.pdf";
					
					File pdf = new File(fileName); //TODO verificar nome
					
					DocumentFolder df =  xmlUtils.xmlToJaxbObject(fileXml);
					
					DocumentFolder.DocumentFolderDetail dfDetail = df.getDocumentFolderDetail().get(0);
					
					String pdfBase64 = dfDetail.getDocument().getContent();
					
					pdf = pdfUtils.decodeBase64(pdf, pdfBase64);
				

				} catch (PDFUtilsBusinessException | XMLUtilsBusinessException e) {
					//TODO verificar o que fazer qdo der erro
					//throw e;
					e.printStackTrace();
				}	
			}
			
			System.out.println("tste");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
