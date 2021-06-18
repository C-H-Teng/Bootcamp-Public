package com.charlesteng.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.languages.models.Language;
import com.charlesteng.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	public Language findLang(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Language updateLang(Long id, String name, String creator, String version) {
		Language lang = findLang(id);
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		return langRepo.save(lang);
	}
	
	public Language updateLang(Language lang) {
		return langRepo.save(lang);
	}
	
	public void deleteLang(Long id) {
		langRepo.deleteById(id);
	}

}
