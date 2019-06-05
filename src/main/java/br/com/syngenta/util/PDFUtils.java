package br.com.syngenta.util;

import br.com.syngenta.exception.BusinessException;
import br.com.syngenta.message.MessageEnum;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Component
public class PDFUtils {

    private static final Logger log = LogManager.getLogger(PDFUtils.class.getName());

    public String encodeBase64(String sourceFile) throws BusinessException {
        log.debug("[PDFUtils] - Iniciando conversao do arquivo {} para base64", sourceFile);

        String encodedPDF = "";
        try {

            byte[] base64EncodedData = Base64.encodeBase64(this.loadFileAsBytesArray(sourceFile), true);

            encodedPDF = this.writeByteArraysToString(base64EncodedData);

        } catch (Exception e) {
            throw new BusinessException(MessageEnum.PDF_UTILS_ERROR_001, e, sourceFile);
        }

        log.debug("[PDFUtils] - Fim da conversao do arquivo {} para base64", sourceFile);
        return encodedPDF;

    }

    public void decodeBase64(File file, String base64File) throws Exception {
        log.debug("[PDFUtils] - Iniciando desconversao de base64 para arquivo pdf");

        try {
            byte[] decodedBytes = Base64.decodeBase64(loadStringAsBytesArray(base64File));
            this.writeByteArraysToFile(file, decodedBytes);

            log.debug("[PDFUtils] - Fim da desconversao de base64 para arquivo pdf");

        } catch (Exception e) {
            throw new BusinessException(MessageEnum.PDF_UTILS_ERROR_002, e);
        }

    }


    private byte[] loadFileAsBytesArray(String fileName) throws Exception {
        log.debug("[PDFUtils] - Carregando arquivo e transformando para bytes array");

        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();

        log.debug("[PDFUtils] - Fim de carregar o arquivo e transformando para bytes array");

        return bytes;
    }

    private byte[] loadStringAsBytesArray(String base64File) throws Exception {
        log.debug("[PDFUtils] - Transformando de String base64 para Bytes");

        byte[] bytes = base64File.getBytes(StandardCharsets.UTF_8);

        log.debug("[PDFUtils] - Fim de Transformando de String base64 para Bytes");

        return bytes;
    }

    private String writeByteArraysToString(byte[] bytes) throws Exception {
        log.debug("[PDFUtils] - Transformando arquivo de bytes para String (base64)");

        String base64 = new String(bytes, StandardCharsets.UTF_8);

        log.debug("[PDFUtils] - Fim Transformando arquivo de bytes para String (base64)");
        return base64;

    }

    private File writeByteArraysToFile(File file, byte[] content) throws Exception {

        log.debug("[PDFUtils] - Escrevendo bytes array para o arquivo {}", file.getName());
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();

        log.debug("[PDFUtils] - Fim bytes array para o arquivo {}", file.getName());
        return file;

    }

}
