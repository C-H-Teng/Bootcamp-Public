package com.charlesteng.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CodingController {
	
	public static void main(String[] args) {
		SpringApplication.run(CodingController.class, args);
	}

	@RequestMapping(value = "/coding", method = RequestMethod.GET)
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping(value = "/python", method = RequestMethod.GET)
	public String python() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping(value = "/java", method = RequestMethod.GET)
	public String java() {
		return "Java/Spring is better!";
	}
	
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		if(dojo.equals("dojo")) {
			return "The dojo is awesome!";
		} else if(dojo.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California.";
		} else if(dojo.equals("san-jose")) {
			return "SJ dojo is the headquarters.";
		}
//		else {
//			return "test";
//		}

		return dojo + " is not a valid query.";
	}

}
