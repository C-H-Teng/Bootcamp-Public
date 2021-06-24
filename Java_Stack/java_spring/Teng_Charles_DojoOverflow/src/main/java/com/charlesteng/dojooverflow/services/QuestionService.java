package com.charlesteng.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.dojooverflow.models.Question;
import com.charlesteng.dojooverflow.models.Tag;
import com.charlesteng.dojooverflow.repositories.QuestionRepo;
import com.charlesteng.dojooverflow.repositories.TagRepo;

@Service
public class QuestionService {
	private final QuestionRepo questRepo;
	private final TagRepo tagRepo;
	private final TagService tagService;
	
	public QuestionService(QuestionRepo questRepo, TagService tagService, TagRepo tagRepo) {
		this.questRepo = questRepo;
		this.tagService = tagService;
		this.tagRepo = tagRepo;
	}
	
	public List<Question> allQuestions(){
		return questRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		Optional<Question> opQuest = questRepo.findById(id);
		if(opQuest.isPresent()) {
			return opQuest.get();
		} else {
			return null;
		}
	}
	
	public Question createQuestion(Question quest) {
		return questRepo.save(quest);
	}
	
	public Question createQuestionWithTags(String quest, String tags) {
		List<Tag> tagList = new ArrayList<Tag>();
		// split tags
		for(String singleTag : tags.split(",")) {
			String trimTag = singleTag.trim();
			Optional<Tag> searchTag = tagRepo.findBySubject(trimTag);
			
			// save tagObj *if* it is not present
			if(searchTag.isEmpty()) {
				Tag tagObj = new Tag();
				tagObj.setSubject(trimTag);
				tagRepo.save(tagObj);
			}
			
			searchTag = tagRepo.findBySubject(trimTag);
			
			if(!tagList.contains(searchTag.get())) {
				tagList.add(searchTag.get());
			}
		}
		
		Question newQuest = new Question();
		newQuest.setTags(tagList);
		newQuest.setQuestion(quest);

		return questRepo.save(newQuest);
	}
	
	public Question updateQuestion(Question quest) {
		return questRepo.save(quest);
	}
	
	public void deleteQuestion(Long id) {
		questRepo.deleteById(id);
	}

}
