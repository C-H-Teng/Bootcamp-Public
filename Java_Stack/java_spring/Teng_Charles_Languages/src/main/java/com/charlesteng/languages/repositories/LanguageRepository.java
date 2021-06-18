package com.charlesteng.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charlesteng.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	
	List<Language> findByNameContaining(String search);
	
	List<Language> findByCreatorContaining(String search);
	
	Long deleteByNameStartingWith(String search);
}
