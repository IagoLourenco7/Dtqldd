package com.dtqldd.DataQuality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataQualityController {

		@RequestMapping("/parammovel")
	    public String ParamMovel(){
	        return "paramMovel";
	    }
		
		@RequestMapping("/paramfixa")
	    public String ParamFixa(){
	        return "paramFixa";
	    }
	
		@RequestMapping("/dataquality/")
	    public String index(){
	        return "index";
	    }
		
		@RequestMapping("/paramoracle")
	    public String ParamOracle(){
	        return "paramoracle";
	    }
		
		@RequestMapping("/teraquali")
	    public String testeQuali(){
	        return "teraQuali";
	    }
		
		@RequestMapping("/processo")
	    public String processo(){
	        return "Processo";
	    }
		
		@RequestMapping("/teste")
	    public String teste(){
	        return "TesteProcesso";
	    }
		

}
