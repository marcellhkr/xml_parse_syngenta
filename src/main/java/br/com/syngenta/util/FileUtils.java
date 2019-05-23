package br.com.syngenta.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.syngenta.exception.XmlParseSyngentaServiceBusinessException;
import br.com.syngenta.message.MessageEnum;

@Component
public class FileUtils {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
	
	public List<String> readFilesFromPath(String dir, String ext ) throws Exception {
		log.debug("[FileUtils] - Carregando arquivos {} do diretorio {}", ext, dir);
		List<String> listFiles = null;
		
		try (Stream<Path> walk = Files.walk(Paths.get(dir))) {

			listFiles = walk.map(x -> x.toString())
					.filter(f -> f.toUpperCase().endsWith(ext))
					
					.collect(Collectors.toList());

			listFiles.forEach(x -> log.debug("[FileUtils] - Arquivo: {}", x.toString()));
			
		} catch (Exception e) {
			throw new XmlParseSyngentaServiceBusinessException(MessageEnum.XLM_PARSER_SERVICE_ERROR_001,e);
		}
		log.debug("[FileUtils] - Fim arquivos {} do diretorio {}", ext, dir);
		return listFiles;
	} 

}
