package com.dtqldd.DataQuality.controller;

import java.io.FileReader;

public class JavaReadTest {
	
	public static void main(String[] args) throws Exception 
	  { 
	    // pass the path to the file as a parameter 
	    FileReader fr = 
	      new FileReader("C:\\Users\\idomingos\\Desktop\\Arquivo\\Arq.txt"); 
	  
	    int i; 
	    while ((i=fr.read()) != -1) 
	      System.out.print((char) i); 
	  } 

}
