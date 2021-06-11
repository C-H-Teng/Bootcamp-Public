package com.charlesteng.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class HelloHuman {

	public static void main(String[] args) {
		SpringApplication.run(HelloHuman.class, args);
	}
	
	@RequestMapping("/")
	public String home() {
		return "<h1>Hello Human!</h1>Welcome to SpringBoot!";
	}

	@RequestMapping("/{fname}")
	public String firstName(@PathVariable("fname") String fname) {
		return "<h1>Hello " + fname + "!</h1>Welcome to SpringBoot!";
	}
	
	@RequestMapping("/{fname}/{lname}")
	public String fullName(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
		return "<h1>Hello " + fname + " " + lname + "!</h1>Welcome to SpringBoot!";
	}

}
