package com.kenzan.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kenzan.web, com.kenzan.app")
public class KensanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KensanApplication.class, args);
	}
}