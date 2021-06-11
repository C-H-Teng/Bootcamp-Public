package com.charlesteng.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
// annotation
@RestController
public class TengCharlesStringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TengCharlesStringsApplication.class, args);
	}

	// annotation
	@RequestMapping("/")
	// method that maps to request route above
	public String hello() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is great! So easy to just respond with strings.";
	}
}
