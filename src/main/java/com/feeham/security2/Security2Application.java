package com.feeham.security2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Security2Application {

	public static void main(String[] args) {
		SpringApplication.run(Security2Application.class, args);
	}

}
