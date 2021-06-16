package com.charlesteng.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private static ArrayList<String> activityLog = new ArrayList<String>();


	@GetMapping("/")
	public String index(HttpSession gold, Model model) {
		model.addAttribute("activityList", activityLog);
		if(gold.getAttribute("gold_count") == null) {
			gold.setAttribute("gold_count", 0);
		}
//		model.addAttribute("activityList", gold.getAttribute("activityList"));
		return "index.jsp";
	}
	
	@PostMapping("/reset")
	public String index(HttpSession gold) {
		gold.setAttribute("gold_count", 0);
		return "redirect:/";
	}
	
	@PostMapping("/makeGold")
	public String makeGold(HttpSession gold, @RequestParam(value="loc") String loc, Model model) {
		int goldAmt = (Integer) gold.getAttribute("gold_count");
		Random num = new Random();
		model.addAttribute("activityList", activityLog);
		
		if(loc.equals("farm")) {
			int randFarm = num.nextInt(21 - 10) + 10;
//			System.out.println(randFarm);
			gold.setAttribute("gold_count", goldAmt + randFarm);
			activityLog.add("You earned " + randFarm + " gold from the farm!");
		} else if(loc.equals("cave")) {
			int randCave = num.nextInt(11 - 5) + 5;
//			System.out.println(randCave);
			gold.setAttribute("gold_count", goldAmt + randCave);
			activityLog.add("You found " + randCave + " gold from the cave!");
		} else if(loc.equals("house")) {
			int randHouse = num.nextInt(6-2) + 2;
//			System.out.println(randHouse);
			gold.setAttribute("gold_count", goldAmt + randHouse);
			activityLog.add("You stole " + randHouse + " gold from the house!");
		} else if(loc.equals("casino")) {
			int randCasino = num.nextInt(51 + 50) - 50;
//			System.out.println(randCasino);
			gold.setAttribute("gold_count", goldAmt + randCasino);
			if(randCasino > 0) {
				activityLog.add("You made " + randCasino + " gold from the casino!");
			} else if(randCasino < 0) {
				activityLog.add("You lost " + randCasino + " gold from the casino!");
			} else {
				activityLog.add("You broke even at the casino!");
			}
		}
		return "redirect:/";
	} // makeGold end
}
