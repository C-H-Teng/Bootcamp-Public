package com.charlesteng.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.charlesteng.dojoninjas.models.Dojo;
import com.charlesteng.dojoninjas.models.Ninja;
import com.charlesteng.dojoninjas.services.DojoService;
import com.charlesteng.dojoninjas.services.NinjaService;

@Controller
public class DojosController {
	private final DojoService dojoService;
	private final NinjaService ninService;
	
	public DojosController(DojoService dojoService, NinjaService ninService) {
		this.dojoService = dojoService;
		this.ninService = ninService;
	}
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/dojos";
	}
	
	@GetMapping("/dojos")
	public String allDojos(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/dojos/allDojos.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/new.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		List<Ninja> nin = ninService.ninjasInDojo(id);
//		System.out.println(nin);
		model.addAttribute("ninjas", nin);
		return "/dojos/show.jsp";
	}

}
