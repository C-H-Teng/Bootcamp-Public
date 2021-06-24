package com.charlesteng.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.dojooverflow.models.Answer;
import com.charlesteng.dojooverflow.models.Tag;
import com.charlesteng.dojooverflow.repositories.TagRepo;

@Service
public class TagService {
	private final TagRepo tagRepo;
	
	public TagService(TagRepo tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public List<Tag> allTags(){
		return tagRepo.findAll();
	}
	
	public Tag findTag(Long id) {
		Optional<Tag> opTag = tagRepo.findById(id);
		if(opTag.isPresent()) {
			return opTag.get();
		} else {
			return null;
		}
	}
	
	public Tag findSubject(String search) {
		Optional<Tag> tag = tagRepo.findBySubject(search);
		if(tag.isPresent()) {
			return tag.get();
		} else {
			return null;
		}
	}
	
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public Tag updateTag(Tag tag) {
		return tagRepo.save(tag);
	}
	
	public void deleteTag(Long id) {
		tagRepo.deleteById(id);
	}

}
