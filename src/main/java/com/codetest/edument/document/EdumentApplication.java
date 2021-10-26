package com.codetest.edument.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EdumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdumentApplication.class, args);
	}

}
