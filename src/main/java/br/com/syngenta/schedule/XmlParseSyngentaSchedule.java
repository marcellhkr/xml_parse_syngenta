package br.com.syngenta.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.syngenta.service.XmlParseSyngentaService;

@Component
@EnableScheduling
public class XmlParseSyngentaSchedule {
	
	private static final Logger log = LogManager.getLogger(XmlParseSyngentaSchedule.class.getName());
	
	@Autowired
	XmlParseSyngentaService xmlParseSyngentaService;
	
	@Scheduled(cron = "${prop.cron.xml.schedule}")
	public void runSchedule() {
		System.out.println("\n");
		log.info("#################### .: Inicio do processamento XML Parser Syngenta:. #################### ");
		
		xmlParseSyngentaService.runService();
		
		log.info("#################### .: Fim do processamento XML Parser Syngenta:. #################### ");
	}

}
