package br.com.syngenta.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		Files.move(Paths.get(source), Paths.get(target));
		
		log.debug("[FileUtils] - Arquivo movido com sucesso!", source, target);
		 
		
	}

}
