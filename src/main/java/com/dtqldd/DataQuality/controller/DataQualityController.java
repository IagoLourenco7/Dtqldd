package com.dtqldd.DataQuality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataQualityController {

		@RequestMapping("/")
	    public String exemploP(){
	        return "Parametrizacao";
	    }
	
}
