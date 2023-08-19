package com.service.englishdise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.service.englishdise.*")
public class EnglishdiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnglishdiseApplication.class, args);
	}

}
