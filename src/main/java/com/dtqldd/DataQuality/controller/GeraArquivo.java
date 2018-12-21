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
	
	int i = 0;
	
	 @RequestMapping("ParametrosMovel")
	    public String parametrosMovel(@RequestParam ("banco") String banco,
	    						 	@RequestParam("tabela") String tabela,
	    						 	@RequestParam("owner") String owner,
	    						 	@RequestParam("processo") String processo,
	    						 	@RequestParam("dataref") String dataref,
	    						 	@RequestParam("desvio") double desvio,
	    						 	@RequestParam("sla") int sla,
	    						 	@RequestParam("agroup") String agrupador) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

     		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
     		
     		i++;
    		if(!agrupador.equals("")) {
     		PrintWriter gravarArq = new PrintWriter(arq);
     		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+agrupador+';'+i);
     	    arq.close();
    		}
    		if(agrupador.equals("")) {
         		PrintWriter gravarArq = new PrintWriter(arq);
         		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+"''"+';'+i);
         	    arq.close();
        		}
    		
    		
	   SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("c:\\temp\\arqv_cadastro.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	   } catch( Exception e ) { 
	     e.printStackTrace();
	     return null;
	   } 
  	

	    	    return "redirect:/parammovel";
	    	    
	 }
	 
	 
	 @RequestMapping("ParametrosFixa")
	    public String parametrosFixa(@RequestParam ("banco") String banco,
	    						     @RequestParam("tabela") String tabela,
	    						     @RequestParam("owner") String owner,
	    						     @RequestParam("processo") String processo,
	    						     @RequestParam("dataref") String dataref,
	    						     @RequestParam("desvio") double desvio,
	    						     @RequestParam("sla") int sla,
	    						     @RequestParam("agroup") String agrupador) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

  		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
  		
  		i++;
 		if(!agrupador.equals("")) {
  		PrintWriter gravarArq = new PrintWriter(arq);
  		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+agrupador+';'+i);
  	    arq.close();
 		}
 		if(agrupador.equals("")) {
      		PrintWriter gravarArq = new PrintWriter(arq);
      		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+"''"+';'+i);
      	    arq.close();
     		}
 		
 		
	   SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("c:\\temp\\arqv_cadastro.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	   } catch( Exception e ) { 
	     e.printStackTrace();
	     return null;
	   } 
	

	    	    return "redirect:/paramfixa";
	    	    
	 }
	 
	 
	 @RequestMapping("parametrosOracle")
	    public String oracle(@RequestParam ("banco") String banco,
	    						 	@RequestParam("tabela") String tabela,
	    						 	@RequestParam("owner") String owner,
	    						 	@RequestParam("processo") String processo,
	    						 	@RequestParam("dataref") String dataref,
	    						 	@RequestParam("desvio") double desvio,
	    						 	@RequestParam("sla") int sla,
	    						 	@RequestParam("agroup") String agrupador) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

  		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
  		
  		i++;
 		if(!agrupador.equals("")) {
  		PrintWriter gravarArq = new PrintWriter(arq);
  		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+agrupador+';'+i);
  	    arq.close();
 		}
 		if(agrupador.equals("")) {
      		PrintWriter gravarArq = new PrintWriter(arq);
      		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+"''"+';'+i);
      	    arq.close();
     		}
 		
 		
	   SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("c:\\temp\\arqv_cadastro.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	   } catch( Exception e ) { 
	     e.printStackTrace();
	     return null;
	   } 
	

	    	    return "redirect:/paramoracle";
	    	    
	 }
	 
	 
}


