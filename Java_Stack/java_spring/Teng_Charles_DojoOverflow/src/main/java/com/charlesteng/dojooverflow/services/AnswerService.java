package com.charlesteng.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.charlesteng.dojooverflow.models.Answer;
import com.charlesteng.dojooverflow.models.Question;
import com.charlesteng.dojooverflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	private final AnswerRepo ansRepo;
	private final QuestionService questService;
	
	public AnswerService(AnswerRepo ansRepo, QuestionService questService) {
		this.ansRepo = ansRepo;
		this.questService = questService;
	}
	
	public List<Answer> allAnswers(){
		return ansRepo.findAll();
	}
	
	public Answer findAnswer(Long id) {
		Optional<Answer> opAns = ansRepo.findById(id);
		if(opAns.isPresent()) {
			return opAns.get();
		} else {
			return null;
		}
	}
	
	public Answer createAnswer(Answer ans) {
		return ansRepo.save(ans);
	}
	
	public Answer createAnswerWithQuestion(String ans, Long questId) {
		Question quest = questService.findQuestion(questId);
		Answer newAns = new Answer();
		
		newAns.setAnswer(ans);
		newAns.setQuestion(quest);
		return ansRepo.save(newAns);
	}
	
	public Answer updateAnswer(Answer ans) {
		return ansRepo.save(ans);
	}
	
	public void deleteAnswer(Long id) {
		ansRepo.deleteById(id);
	}

}
