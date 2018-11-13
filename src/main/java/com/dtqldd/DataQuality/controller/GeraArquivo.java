package com.dtqldd.DataQuality.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	    	
	    	
	    		if(dataref.equals("DT_MES_FTRA")) {
	        		FileWriter arq = new FileWriter("d:\\arqv_cadastro.txt",true);
	        		
	        		PrintWriter gravarArq = new PrintWriter(arq);

	        	    gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo+";"+dataref+";"+ciclo+";"+Double.toString(desvio/100));
	        	    arq.close();
	    			
	    		}else {
	        		FileWriter arq = new FileWriter("d:\\arqv_cadastro.txt",true);
	        		
	        		PrintWriter gravarArq = new PrintWriter(arq);
	        	    
	        	    System.out.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo+";"+dataref);
	        	    
	        	    gravarArq.println(banco+';'+tabela.toUpperCase()+';'+owner.toUpperCase()+';'+processo+";"+dataref+";"+""+";"+Double.toString(desvio/100));
	        	    arq.close();
	    			
	    		}

	    	    return "redirect:/";
	    	    
	 }
	  
	 
		
		
}


