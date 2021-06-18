package com.charlesteng.languages.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;

import com.charlesteng.languages.models.Language;
import com.charlesteng.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language lang) {
		List<Language> language = langService.allLanguages();
		model.addAttribute("langList", language);
		return "/index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		if(result.hasErrors()) {
			return "/index.jsp";
		} else {
			langService.createLanguage(lang);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/show.jsp";
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLang(id);
		model.addAttribute("language", lang);
		return "/edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "/edit.jsp";
		} else {
			System.out.println(id);
			langService.updateLang(lang);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLang(id);
		return "redirect:/languages";
	}

}
