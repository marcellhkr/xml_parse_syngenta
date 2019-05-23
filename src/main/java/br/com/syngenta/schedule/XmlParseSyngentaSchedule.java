package br.com.syngenta.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.syngenta.service.XmlParseSyngentaService;

@Component
@EnableScheduling
public class XmlParseSyngentaSchedule {
	
	private static final Logger log = LoggerFactory.getLogger(XmlParseSyngentaSchedule.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Autowired
	XmlParseSyngentaService xmlParseSyngentaService;
	
	@Scheduled(fixedDelayString = "${property.schedule.fixeddelay.in.ms}")
	public void runSchedule() {
		System.out.println("\n");
		log.debug("Inicio da execucao da operacao xmlParseSyngentaService.runSchedule() {}", dateFormat.format(new Date()));
		log.info("#################### .: Inicio do processamento XML Parser Syngenta:. #################### ");
		
		xmlParseSyngentaService.runService();
		
		log.info("#################### .: Fim do processamento XML Parser Syngenta:. #################### {}");
		log.debug("Fim da execucao da operacao xmlParseSyngentaService.runSchedule() {}", dateFormat.format(new Date()));
	}

}
