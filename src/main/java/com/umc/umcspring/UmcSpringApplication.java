package com.umc.umcspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class UmcSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UmcSpringApplication.class, args);
	}

}
