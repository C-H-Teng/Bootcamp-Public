package com.charlesteng.displaydate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	
	
	@RequestMapping("/")
	public String index() {
//		model.addAttribute("dojoName", "Burbank");
		return "index.jsp";
	}

	@GetMapping("/date")
	public String currDate(Model date) {
		LocalDate myDate = LocalDate.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("EEEE, ' the ' dd ' of ' MMMM, YYYY");
		String formattedDate = myDate.format(myFormat);
		date.addAttribute("date", formattedDate);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String currTime(Model time) {
		LocalTime myTime = LocalTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("h:mm a");
		String formattedTime = myTime.format(myFormat);
		time.addAttribute("time", formattedTime);
		return "time.jsp";
	}

}
