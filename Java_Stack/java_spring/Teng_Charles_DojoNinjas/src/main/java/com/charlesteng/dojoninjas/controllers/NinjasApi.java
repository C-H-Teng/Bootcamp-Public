package com.charlesteng.dojoninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlesteng.dojoninjas.models.Dojo;
import com.charlesteng.dojoninjas.models.Ninja;
import com.charlesteng.dojoninjas.services.NinjaService;

@RestController
public class NinjasApi {
	private final NinjaService ninService;
	
	public NinjasApi(NinjaService ninService) {
		this.ninService = ninService;
	}
	
	@GetMapping("/api/ninjas")
	public List<Ninja> index(){
		return ninService.allNinjas();
	}
	
	@PostMapping("/api/ninjas")
	public Ninja create(@RequestParam(value = "first_name") String first_name, @RequestParam(value = "last_name") String last_name, @RequestParam(value = "age") Integer age, @RequestParam(value = "dojo") Dojo dojo) { // value = dojo_id?
		Ninja nin = new Ninja(first_name, last_name, age);
		return ninService.createNinja(nin);
	}
	
	@GetMapping("/api/languages/{id}")
	public Ninja show(@PathVariable("id") Long id) {
		Ninja nin = ninService.findNinja(id);
		return nin;
	}
	
	@PutMapping("/api/ninjas/{id}")
	public Ninja update(@PathVariable("id") Long id, @RequestParam(value = "first_name") String first_name, @RequestParam(value = "last_name") String last_name, @RequestParam(value = "age") Integer age, @RequestParam(value = "dojo") Dojo dojo) {
		Ninja nin = ninService.updateNinja(id, first_name, last_name, age, dojo);
		return nin;
	}
	
	@DeleteMapping("/api/ninjas/{id}")
	public void destroy(@PathVariable("id") Long id) {
		ninService.deleteNinja(id);
	}

}
