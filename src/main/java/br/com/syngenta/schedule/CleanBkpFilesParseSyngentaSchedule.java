package br.com.syngenta.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.syngenta.service.CleanBkpFilesParseSyngentaService;
import br.com.syngenta.service.PdfParseSyngentaService;

@Component
@EnableScheduling
public class CleanBkpFilesParseSyngentaSchedule {

    private static final Logger log = LogManager.getLogger(CleanBkpFilesParseSyngentaSchedule.class.getName());

    @Autowired
    CleanBkpFilesParseSyngentaService cleanBkpFilesParseSyngentaService;

    @Scheduled(cron = "${prop.cron.clean.bkp.files.schedule:0 0/5 * * * *}")
    public void runSchedule() {
        //System.out.println("\n");
        log.debug("#################### .: Inicio do processamento Clean Backup Files Parser Syngenta:. #################### ");

        cleanBkpFilesParseSyngentaService.runService();

        log.debug("#################### .: Fim do processamento Clean Backup Files Parser Syngenta:. #################### ");
    }
	
}
