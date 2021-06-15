package com.charlesteng.counter;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@Controller
public class CounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}

	@GetMapping("/")
	public String index(HttpSession counter) {
		Integer count = (Integer) counter.getAttribute("count");
		counter.setAttribute ("count", count+1);
		return "index.jsp";
	}
	
	@GetMapping("/counttotal")
	public String countTotal(HttpSession counter) {
		Integer count = (Integer) counter.getAttribute("count");
		if(count == null) {
			counter.setAttribute("count", 0);
		}
		return "countTotal.jsp";
	}

	@GetMapping("/reset")
	public RedirectView reset(HttpSession counter) {
		counter.setAttribute("count", 0);
		return new RedirectView("/counttotal");
	}
}
