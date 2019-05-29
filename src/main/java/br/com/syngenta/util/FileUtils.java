package br.com.syngenta.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.syngenta.exception.FileUtilsBusinessException;
import br.com.syngenta.message.MessageEnum;

@Component
public class FileUtils {
	
	private static final Logger log = LogManager.getLogger(FileUtils.class.getName());
	
	public List<String> readFilesFromPath(String dir, String ext ) throws Exception {
		log.debug("[FileUtils] - Carregando arquivos {} do diretorio {}", ext, dir);
		List<String> listFiles = null;
		
		try (Stream<Path> walk = Files.walk(Paths.get(dir))) {

			listFiles = walk.map(x -> x.getFileName().toString())
					.filter(f -> f.toUpperCase().endsWith(ext))
					
					.collect(Collectors.toList());

			listFiles.forEach(x -> log.debug("[FileUtils] - Arquivo: {}", x.toString()));
			
		} catch (Exception e) {
			throw new FileUtilsBusinessException(MessageEnum.FILE_UTILS_ERROR_001,e, dir);
		}
		log.debug("[FileUtils] - Fim arquivos {} do diretorio {}", ext, dir);
		return listFiles;
	} 
	
	
	public void moveFile(String source, String target) throws Exception {
		log.debug("[FileUtils] - Movendo arquivo de: {} para: {}", source, target);
		
		Files.move(Paths.get(source), Paths.get(target), StandardCopyOption.REPLACE_EXISTING);
		
		log.debug("[FileUtils] - Arquivo movido com sucesso!", source, target);
		 
		
	}
	
	public String getOrderDeliveryNumber(String fileName, String field) throws Exception{
		log.debug("[FileUtils] - Tratando {} do nome do arquivo: {}",field, fileName);
		String ret = "";
		
		try {
			String[] fields = fileName.split("-");
			
			if(field.equals("ordernumber")) {
				ret = fields[1];
			} else {
				ret = fields[2].toUpperCase().replace(".PDF", "");
			}
			
			log.debug("[FileUtils] - {}: {}", field, ret);
		} catch (Exception e) {
			//TODO criar mensagem
			throw new FileUtilsBusinessException(MessageEnum.FILE_UTILS_ERROR_002,e, field, fileName);
		}
		
		return ret;
	}
	
	public String addTimestampToFileName(String fileName) throws Exception {
		log.debug("[FileUtils] - Adicionando timestamp no nome do arquivo: {}",fileName);
		String ret = "";
		
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String name = fileName.substring(0, fileName.indexOf(ext));
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		ret = name.concat("_"+timestamp).concat(ext);
		
		log.debug("[FileUtils] - Novo nome do arquivo: {}",ret);
		return ret;
		
	}


}
