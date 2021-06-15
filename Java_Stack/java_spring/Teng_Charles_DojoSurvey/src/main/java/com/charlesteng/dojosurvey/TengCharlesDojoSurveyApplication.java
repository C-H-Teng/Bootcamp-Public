package com.charlesteng.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class TengCharlesDojoSurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TengCharlesDojoSurveyApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam(value="name") String name, @RequestParam(value="loc") String loc, @RequestParam(value="favLang") String favLang, @RequestParam(value="comment", required=false) String comment, HttpSession formSubmit) {
		formSubmit.setAttribute("name", name);
		formSubmit.setAttribute("loc", loc);
		formSubmit.setAttribute("favLang", favLang);
		formSubmit.setAttribute("comment", comment); 
		
//		System.out.println(name);
//		System.out.println(formSubmit.getAttribute("name"));
		return "redirect:/result";
	}

	
	@GetMapping("/result")
	public String result(HttpSession formSubmit) {
		return "result.jsp";
	}

}
