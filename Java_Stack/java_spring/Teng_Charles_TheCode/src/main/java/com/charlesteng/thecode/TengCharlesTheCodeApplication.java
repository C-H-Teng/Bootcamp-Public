package com.charlesteng.thecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class TengCharlesTheCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TengCharlesTheCodeApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/trycode")
	public String trycode(@RequestParam(value="code") String code, RedirectAttributes error) {
		if(code.equals("bushido")) {
			return "redirect:/code";
		} else {
			error.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@GetMapping("/code")
	public String code() {
		return "code.jsp";
	}

}
