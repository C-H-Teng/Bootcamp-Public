package com.charlesteng.dojoninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.charlesteng.dojoninjas.models.Ninja;
import com.charlesteng.dojoninjas.services.DojoService;
import com.charlesteng.dojoninjas.services.NinjaService;

@Controller
public class NinjasController {
	private final NinjaService ninService;
	private final DojoService dojoService;
	
	public NinjasController(NinjaService ninService, DojoService dojoService) {
		this.ninService = ninService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/ninjas")
	public String index(Model model){
		List<Ninja> nin = ninService.allNinjas();
		model.addAttribute("ninjas", nin);
		return "/ninjas/allNin.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			ninService.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	@DeleteMapping("/api/languages/{id}")
	public void destroy(@PathVariable("id") Long id) {
		ninService.deleteNinja(id);
	}
	
//	@GetMapping("/ninjas/{id}")
//	public Ninja show(@PathVariable("id") Long id) {
//		Ninja nin = ninService.findNinja(id);
//		return "/ninjas/show.jsp;
//	}
	
//	@PutMapping("/ninjas/{id}")
//	public Ninja update(@PathVariable("id") Long id, @RequestParam(value = "first_name") String first_name, @RequestParam(value = "last_name") String last_name, @RequestParam(value = "age") Integer age, @RequestParam(value = "dojo") Dojo dojo) {
//		Ninja nin = ninService.updateNinja(id, first_name, last_name, age, dojo);
//		return nin;
//	}
	

}
