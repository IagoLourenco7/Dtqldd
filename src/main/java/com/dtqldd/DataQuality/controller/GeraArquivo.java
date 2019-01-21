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
	    						 	@RequestParam("agroup") String agrupador,
	    						 	@RequestParam("modulo") String modulo,
	    						 	@RequestParam("nmlogico") String nmLogico) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());
	   
	   

	   try {
	     ssh.connect("10.129.227.178", 22);
	     ssh.authPassword("a5113588", "a5113588");

     		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
     		
     		i++;
    		if(!agrupador.equals("")) {
     		PrintWriter gravarArq = new PrintWriter(arq);
     		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+agrupador.toUpperCase()+';'+i+";"+modulo+";"+nmLogico.toUpperCase());
     	    arq.close();
    		}
    		if(agrupador.equals("")) {
         		PrintWriter gravarArq = new PrintWriter(arq);
         		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+"''"+';'+i+";"+modulo+";"+nmLogico.toUpperCase());
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
	    						     @RequestParam("agroup") String agrupador,
	    						     @RequestParam("modulo") String modulo,
		    						 @RequestParam("nmlogico") String nmLogico) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.178", 22);
	     ssh.authPassword("a5113588", "a5113588");

  		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
  		
  		i++;
 		if(!agrupador.equals("")) {
  		PrintWriter gravarArq = new PrintWriter(arq);
  		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+agrupador.toUpperCase()+';'+i+";"+modulo+";"+nmLogico.toUpperCase());
  	    arq.close();
 		}
 		if(agrupador.equals("")) {
      		PrintWriter gravarArq = new PrintWriter(arq);
      		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+"''"+';'+i+";"+modulo+";"+nmLogico.toUpperCase());
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
	     ssh.connect("10.129.227.178", 22);
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
	 
	 
	 @RequestMapping("parametrosQuali")
	    public String parametrosQuali(@RequestParam ("banco") String banco,
	    						 	@RequestParam("tabela") String tabela,
	    						 	@RequestParam("owner") String owner,
	    						 	@RequestParam("campo") String campo,
	    						 	@RequestParam("dataref") String dataref,
	    						 	@RequestParam("sla") int sla,
	    						 	@RequestParam("objetivo") String objetivo) throws IOException {



	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.178", 22);
	     ssh.authPassword("a5113588", "a5113588");

		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro_qualitativo.txt",true);
		
		i++;

		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+campo.toUpperCase()+";"+Integer.toString(sla)+";"+dataref.toUpperCase()+';'+i+";"+objetivo.toUpperCase());
	    arq.close();



		
		
	   SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("c:\\temp\\arqv_cadastro_qualitativo.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	   } catch( Exception e ) { 
	     e.printStackTrace();
	     return null;
	   } 
	

	    	    return "redirect:/teraquali";
	    	    
	 }
	 
}


