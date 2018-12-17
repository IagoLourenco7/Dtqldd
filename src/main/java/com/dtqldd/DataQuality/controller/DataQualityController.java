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
	
		@RequestMapping("/")
	    public String index(){
	        return "index";
	    }
		
		@RequestMapping("/quali")
	    public String quali(){
	        return "index_teste";
	    }
		
		@RequestMapping("/qua")
	    public String qual(){
	        return "teste_index";
	    }
}
