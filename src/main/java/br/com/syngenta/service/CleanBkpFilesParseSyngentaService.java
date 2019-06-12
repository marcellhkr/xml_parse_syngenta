package br.com.syngenta.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.base.Throwables;

import br.com.syngenta.util.FileUtils;

@Service
public class CleanBkpFilesParseSyngentaService {
	
	private static final Logger log = LogManager.getLogger(CleanBkpFilesParseSyngentaService.class.getName());
	public static final String PDF = ".pdf";
	public static final String XML = ".xml";
	
	@Autowired
    FileUtils fileUtils;
	
	@Value("${property.xml.bkp.directory}")
    String xmlBkpDirectory;
	
	@Value("${property.pdf.bkp.directory}")
	String pdfBkpDirectory;
	
	@Value("${property.months.clean.bkp.dir}")
	int monthsCleanBkpDir;
	
	public void runService() {
		
		pdfBkpDirectory = pdfBkpDirectory.replace("/", "\\").replace("EXPORTACAO", "EXPORTAÇÃO");
		xmlBkpDirectory = xmlBkpDirectory.replace("/", "\\").replace("IMPORTACAO", "IMPORTAÇÃO");
		
		try {
			fileUtils.DeleteBkpFiles(pdfBkpDirectory, PDF, monthsCleanBkpDir);			
		} catch (Exception e) {
			log.error("[CLEAN_BKP_SERVICE] - Erro limpar diretorio de backup. Erro: {}", Throwables.getStackTraceAsString(e));
		}
		
		try {
			fileUtils.DeleteBkpFiles(xmlBkpDirectory, XML, monthsCleanBkpDir);			
		} catch (Exception e) {
			log.error("[CLEAN_BKP_SERVICE] - Erro limpar diretorio de backup. Erro: {}", Throwables.getStackTraceAsString(e));
		}

	}

}
