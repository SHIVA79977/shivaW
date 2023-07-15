package com.slokam.da.hc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="HelthcareApplication",version="5.4",description="hi hello welcome to healthcare"))
public class HelthcareApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelthcareApplication.class, args);
		
	
	}
}

