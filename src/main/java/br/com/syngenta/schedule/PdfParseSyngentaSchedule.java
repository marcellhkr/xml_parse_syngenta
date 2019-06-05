package br.com.syngenta.schedule;

import br.com.syngenta.service.PdfParseSyngentaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class PdfParseSyngentaSchedule {

    private static final Logger log = LogManager.getLogger(PdfParseSyngentaSchedule.class.getName());

    @Autowired
    PdfParseSyngentaService pdfParseSyngentaService;

    @Scheduled(cron = "${prop.cron.pdf.schedule}")
    public void runSchedule() {
        //System.out.println("\n");
        log.debug("#################### .: Inicio do processamento PDF Parser Syngenta:. #################### ");

        pdfParseSyngentaService.runService();

        log.debug("#################### .: Fim do processamento PDF Parser Syngenta:. #################### ");
    }

}
