package com.hsbc.cloud.poc.TerraformDecoder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

	 @Autowired
	 ReadXMLFile readXml;
	
		
	@PostMapping(value = "/readxml", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = "text/plain"			
			)
			public ResponseEntity<String> terraformDecoder(@RequestBody String xmlData)
					throws ConfigDataResourceNotFoundException {

				String outputFilePath = "/media/chetan/CHETAN-DATA/decoder/xmlfile.xml"; //path of xml file where we are trying to write POST request data from UI

				/*
				 * try {
				 * 
				 * BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));
				 * 
				 * writer.write(xmlData);
				 * 
				 * writer.close();
				 * 
				 * readXml.XMLParser(xmlData);
				 * 
				 * } catch (IOException e) { e.printStackTrace();
				 * 
				 * }
				 */
				
				String finalTF = readXml.XMLParser(xmlData);
				
				return ResponseEntity.ok().body(finalTF); //pass generated terraform in body

			}
	}	




	
	
	
	


