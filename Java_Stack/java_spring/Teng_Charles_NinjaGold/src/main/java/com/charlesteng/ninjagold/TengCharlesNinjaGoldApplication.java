package com.charlesteng.ninjagold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TengCharlesNinjaGoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(TengCharlesNinjaGoldApplication.class, args);
	}

//	@GetMapping("/")
//	public String index(HttpSession gold, Model model) {
//		if(gold.getAttribute("gold_count") == null) {
//			ArrayList<String> activity = new ArrayList<String>();
//			gold.setAttribute("gold_count", 0);
//			gold.setAttribute("activityList", activity);
//		}
//		model.addAttribute("activityList", gold.getAttribute("activityList"));
//		return "index.jsp";
//	}
//	
//	@PostMapping("/reset")
//	public String index(HttpSession gold) {
//		gold.setAttribute("gold_count", 0);
//		return "redirect:/";
//	}
//	
//	@PostMapping("/makeGold")
//	public String makeGold(HttpSession gold, @RequestParam(value="loc") String loc) {
//		int goldAmt = (Integer) gold.getAttribute("gold_count");
//		Random num = new Random();
//		ArrayList<String> activities = new ArrayList<String>();  
//		
//		for(String activity : gold.getAttribute("activityList"))
//		
//		if(loc.equals("farm")) {
//			int randFarm = num.nextInt(21 - 10) + 10;
//			System.out.println(randFarm);
//			gold.setAttribute("gold_count", goldAmt + randFarm);
//			activities.add("You earned " + randFarm + " gold from the farm!");
//			
//		} else if(loc.equals("cave")) {
//			int randCave = num.nextInt(11 - 5) + 5;
//			System.out.println(randCave);
//			gold.setAttribute("gold_count", goldAmt + randCave);
//		} else if(loc.equals("house")) {
//			int randHouse = num.nextInt(6-2) + 2;
//			System.out.println(randHouse);
//			gold.setAttribute("gold_count", goldAmt + randHouse);
//		} else if(loc.equals("casino")) {
//			int randCasino = num.nextInt(51 - 100) + 50;
//			System.out.println(randCasino);
//			gold.setAttribute("gold_count", goldAmt + randCasino);
//		}
//		return "redirect:/";
//	} // makeGold end

}
