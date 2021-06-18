package com.charlesteng.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlesteng.languages.models.Language;
import com.charlesteng.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	private final LanguageService langService;

	public LanguagesApi(LanguageService langService) {
		this.langService = langService;
	}
	
	@GetMapping("/api/languages")
	public List<Language> index(){
		return langService.allLanguages();
	}
	
	@PostMapping("/api/languages")
	public Language create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator, @RequestParam(value = "version") String version) {
		Language lang = new Language(name, creator, version);
		return langService.createLanguage(lang);
	}
	
	@GetMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language lang = langService.findLang(id);
		return lang;
	}
	
	@PutMapping("/api/languages/{id}")
	public Language update(@PathVariable("id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator, @RequestParam(value = "version") String version) {
		Language lang = langService.updateLang(id, name, creator, version);
		return lang;
	}
	
	@DeleteMapping("/api/languages/{id}")
	public void destroy(@PathVariable("id") Long id) {
		langService.deleteLang(id);
	}

}
