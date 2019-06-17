package br.com.syngenta.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Component
public class SftpUtil {

	 private static final Logger log = LogManager.getLogger(SftpUtil.class.getName());
	
	 public ChannelSftp connectSftp(String sftpHost, int sftpPort, String sftpUser, String sftpPassword) throws Exception {
		 log.debug("[SftpUtil] - Conectando servidor sftp {}", sftpHost);
		 
		 Session session = null;
		 Channel channel = null;
	     ChannelSftp channelSftp = null;
	        
		 JSch jsch = new JSch();
		 
		 session = jsch.getSession(sftpUser, sftpHost, sftpPort);
         session.setPassword(sftpPassword);
         
         Properties config = new Properties();
         config.put("StrictHostKeyChecking", "no");
         session.setConfig(config);
         
         session.connect();
         
         channel = session.openChannel("sftp");
         channel.connect();
         
         channelSftp = (ChannelSftp) channel;
         
         
         log.debug("[SftpUtil] - Conectado! ");
         
         return channelSftp;
         
	 }
	 
	 public Vector<LsEntry> listFilesSftp(ChannelSftp channelSftp, String sftpWorkingDir) throws Exception {
		 log.debug("[SftpUtil] - Listando arquivo do diretorio: {} ", sftpWorkingDir);
		 
		 channelSftp.cd(sftpWorkingDir);
		 Vector<LsEntry> list = channelSftp.ls("*.xml");

		 list.forEach(x -> log.debug("[SftpUtil] - Arquivo: {}", x));

		 return list;
		 
	 }
	 
	 public void getFileSftp(ChannelSftp channelSftp, String sftpFile, String targetDir) throws Exception {
		 log.debug("[SftpUtil] - Downloading aquivo: {} para o diretorio: {} ", sftpFile,targetDir);
		 
		 BufferedInputStream bis = null;
		 BufferedOutputStream bos = null;
		 try {
		 
			 byte[] buffer = new byte[1024];
			 bis = new BufferedInputStream(channelSftp.get(sftpFile));
			 File newFile = new File(targetDir + File.separator + sftpFile);
			 OutputStream os = new FileOutputStream(newFile);
			 bos = new BufferedOutputStream(os);
			 int readCount;
			 while( (readCount = bis.read(buffer)) > 0) {
			   bos.write(buffer, 0, readCount);
			 }
			 log.debug("[SftpUtil] - Download concluido! ");
			 log.debug("[SftpUtil] - Apagando arquivo do servidor... ");
			 channelSftp.rm(sftpFile);
			 
			 bis.close();
			 bos.close();
		 } catch (Exception e) {
			 if (bis != null) {
				 bis.close();
			 }
			 if (bos != null) {
				 bos.close();
			 }
			 log.error("[SftpUtil] - Erro ao baixar o arquivo: {}. Erro: {}! ", sftpFile, Throwables.getStackTraceAsString(e));
		 }
		 
	 }
	 
	 
	 public void putFileSftp(ChannelSftp channelSftp, File sftpFile, String targetDir) throws Exception {
		 
		 log.debug("[SftpUtil] - Uploading aquivo: {} para o diretorio: {} ", sftpFile,targetDir);

		 channelSftp.cd(targetDir);
		 channelSftp.put(new FileInputStream(sftpFile), sftpFile.getName(), ChannelSftp.OVERWRITE);
		
		 log.debug("[SftpUtil] - Upload concluido! ");
	 }
	 
}
