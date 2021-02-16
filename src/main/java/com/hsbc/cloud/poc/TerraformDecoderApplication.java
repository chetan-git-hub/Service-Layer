package com.hsbc.cloud.poc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hsbc.cloud.poc")
public class TerraformDecoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerraformDecoderApplication.class, args);
		
	}
}