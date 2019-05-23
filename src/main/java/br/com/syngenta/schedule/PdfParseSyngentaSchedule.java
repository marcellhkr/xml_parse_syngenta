package br.com.syngenta.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.syngenta.service.PdfParseSyngentaService;


@Component
@EnableScheduling
public class PdfParseSyngentaSchedule {

private static final Logger log = LogManager.getLogger(PdfParseSyngentaSchedule.class.getName());
	
	@Autowired
	PdfParseSyngentaService pdfParseSyngentaService;
	
	@Scheduled(cron = "${prop.cron.pdf.schedule}")
	public void runSchedule() {
		System.out.println("\n");
		log.info("#################### .: Inicio do processamento PDF Parser Syngenta:. #################### ");
		
		pdfParseSyngentaService.runService();
		
		log.info("#################### .: Fim do processamento PDF Parser Syngenta:. #################### ");
	}
	
}
