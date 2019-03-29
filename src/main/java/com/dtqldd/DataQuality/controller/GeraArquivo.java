package com.dtqldd.DataQuality.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

@Controller
public class GeraArquivo {
	
	int i = 0;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	
	
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
	    						 	@RequestParam("nmlogico") String nmLogico,
	    						 	@RequestParam("calend") String calendario,
	    						 	@RequestParam("campoDiario") int dia) throws IOException {

	   SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());
	   
	   

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

     		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
     		
     		Date date = new Date();
    		if(!agrupador.equals("")) {
    			if(calendario.equals("DIARIO")) {
    				PrintWriter gravarArq = new PrintWriter(arq);
    				gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+agrupador.toUpperCase()+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+';'+calendario.toUpperCase()+';'+Integer.toString(dia)+';'+"''");
    				arq.close();
    			}
    			if(!calendario.equals("DIARIO")) {
    				PrintWriter gravarArq = new PrintWriter(arq);
    				gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+agrupador.toUpperCase()+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+';'+calendario.toUpperCase()+';'+"''"+';'+"''");
    				arq.close();
    			}
    		}
    		if(agrupador.equals("")) {
    			if(calendario.equals("DIARIO")) {
    				PrintWriter gravarArq = new PrintWriter(arq);
    				gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+"''"+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+';'+calendario.toUpperCase()+';'+Integer.toString(dia)+';'+"''");
    				arq.close();
    			}
    			if(!calendario.equals("DIARIO")) {
    				PrintWriter gravarArq = new PrintWriter(arq);
    				gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+"''"+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+';'+calendario.toUpperCase()+';'+"''"+';'+"''");
    				arq.close();
    	    		}
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
		    					 @RequestParam("nmlogico") String nmLogico,
		    					 @RequestParam("fecha") String fechamentoSemanal) throws IOException {

	 SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

  		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro.txt",true);
  		
  		Date date = new Date();
 		if(!agrupador.equals("")) {
  		PrintWriter gravarArq = new PrintWriter(arq);
  		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+agrupador.toUpperCase()+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+";"+"''"+";"+"''"+";"+fechamentoSemanal.toUpperCase());
  	    arq.close();
 		}
 		if(agrupador.equals("")) {
      		PrintWriter gravarArq = new PrintWriter(arq);
      		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo.toUpperCase()+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref.toUpperCase()+";"+"''"+';'+(dateFormat.format(date))+";"+modulo+";"+nmLogico.toUpperCase()+";"+"''"+";"+"''"+";"+fechamentoSemanal.toUpperCase());
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
  		
  		Date date = new Date();
 		if(!agrupador.equals("")) {
  		PrintWriter gravarArq = new PrintWriter(arq);
  		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+agrupador+';'+(dateFormat.format(date))+";"+"''"+";"+"''"+";"+"''"+";"+"''"+";"+"''");
  	    arq.close();
 		}
 		if(agrupador.equals("")) {
      		PrintWriter gravarArq = new PrintWriter(arq);
      		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+processo+";"+Integer.toString(sla)+";"+Double.toString(desvio)+";"+dataref+";"+"''"+';'+(dateFormat.format(date))+";"+"''"+";"+"''"+";"+"''"+";"+"''"+";"+"''");
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
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro_qualitativo.txt",true);
		
		Date date = new Date();

		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+";"+campo.toUpperCase()+";"+Integer.toString(sla)+";"+dataref.toUpperCase()+';'+(dateFormat.format(date))+";"+objetivo.toUpperCase());
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
	 
	 @RequestMapping("ParametrosProcesso")
	 public String processo(@RequestParam ("tabela") String tabela,
	                        @RequestParam("owner") String owner,
	    					@RequestParam("processo") String processo) throws IOException {



	   SSHClient ssh = new SSHClient();
	   ssh.addHostKeyVerifier(new PromiscuousVerifier());

	   try {
	     ssh.connect("10.129.227.177", 22);
	     ssh.authPassword("a5113588", "a5113588");

		FileWriter arq = new FileWriter("c:\\temp\\arqv_cadastro_processo.txt",true);
		
		

		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.println(tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo.toUpperCase());
	    arq.close();



		
		
	     SFTPClient sftp = ssh.newSFTPClient();
	     sftp.put("c:\\temp\\arqv_cadastro_processo.txt",  "/dw/trf/DATA_QLDD_BI/");
	     ssh.disconnect();

	     } catch( Exception e ){ 
	       e.printStackTrace();
	       return null;
	     } 
	

	      return "redirect:/processo";
	    	    
	 }
	 
}


