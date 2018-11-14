package com.dtqldd.DataQuality.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

@Controller
public class GeraArquivo {
	
	 @RequestMapping("Parametros")
	    public String someMethod(@RequestParam ("banco") String banco,
	    						 @RequestParam ("tabela") String tabela,
	    						 @RequestParam("owner") String owner,
	    						 @RequestParam("processo") String processo,
	    						 @RequestParam("dataref") String dataref,
	    						 @RequestParam("ciclo") String ciclo,
	    						 @RequestParam("desvio") double desvio) throws IOException {

	 SSHClient ssh = new SSHClient();
	   // required if host is not in knownLocalHosts
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

	     if(dataref.equals("DT_MES_FTRA")) {
     		FileWriter arq = new FileWriter("d:\\teste_iago.txt",true);
     		
     		PrintWriter gravarArq = new PrintWriter(arq);
     	    gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo+";"+Double.toString(desvio/100)+";"+dataref+";"+ciclo);
     	    arq.close();
 			
 		}else {
     		FileWriter arq = new FileWriter("d:\\teste_iago.txt",true);
     		
     		PrintWriter gravarArq = new PrintWriter(arq);
     	    gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo+";"+dataref+";"+""+";"+Double.toString(desvio/100));
     	    arq.close();
 			
 		}
	     SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("d:\\teste_iago.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	   } catch( Exception e ) { 
	     //TODO: this needs to be more robust than just catching all exceptions
	     e.printStackTrace();
	     return null;
	   } 
  	

	    	    return "redirect:/";
	    	    
	 }
	 
	 
//	 @RequestMapping("Parametros")
//	 public FileWriter putTempLocalInstance(  )
//	 {
//	   FileWriter tempFile = null;
//	   SSHClient client = new SSHClient();
//	   // required if host is not in knownLocalHosts
//	   client.addHostKeyVerifier(new PromiscuousVerifier());
//
//	   try {
//	     client.connect("10.129.227.177", 22);
//	     client.authPassword("a5113588", "a5113588");
//
//	     tempFile = new FileWriter("d:\\tempFile.txt",true);
//	     PrintWriter gravarArq = new PrintWriter(tempFile);
//	     gravarArq.println("Testando SSH Server");
//	     tempFile.close();
//
//	     SFTPClient sftp = client.newSFTPClient();
//	     sftp.put("d:\\tempFile.txt",  "/dw/trf/DATA_QLDD_BI/");
//	     client.disconnect();
//
//	   } catch( Exception e ) { 
//	     //TODO: this needs to be more robust than just catching all exceptions
//	     e.printStackTrace();
//	     return null;
//	   } 
//	   
//	   return tempFile;
//	 }
	  
	  
	 
		
		
}


