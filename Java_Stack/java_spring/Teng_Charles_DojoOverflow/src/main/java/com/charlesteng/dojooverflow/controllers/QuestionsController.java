package com.charlesteng.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charlesteng.dojooverflow.models.Question;
import com.charlesteng.dojooverflow.services.AnswerService;
import com.charlesteng.dojooverflow.services.QuestionService;
import com.charlesteng.dojooverflow.services.TagService;

@Controller
public class QuestionsController {
	private final QuestionService questService;
	private final TagService tagService;
	private final AnswerService ansService;
	
	public QuestionsController(QuestionService questService, TagService tagService, AnswerService ansService) {
		this.questService = questService;
		this.tagService = tagService;
		this.ansService = ansService;
	}
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	public String index(Model model) {
		List<Question> quest = questService.allQuestions();
		model.addAttribute("questions", quest);
		return "/questions/index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question quest) {
		return "/questions/new.jsp";
	}
	
	@PostMapping("/questions")
	public String submitQuestion(@Valid @RequestParam("question") String quest, @RequestParam("tag") String tag, RedirectAttributes error) {
		String[] tagList = tag.split(",");
		List<String> trimList = new ArrayList<String>();
		// trim and change to lowercase before adding to trimList
		for(int i = 0; i < tagList.length; i++) {
			trimList.add(tagList[i].trim().toLowerCase());
		}
		
		// validations for question and tags
		if(trimList.size() > 3 || quest.equals("")) {
			if(trimList.size() > 3) {
				error.addFlashAttribute("tagError", "Each question can only have a max of 3 tags.");
			}
			if(quest.equals("")) {
				error.addFlashAttribute("questError", "You must enter a question to submit.");
			}
			return "redirect:/questions/new";
		} else {
			// create question and set 
			questService.createQuestionWithTags(quest, tag);
		}
			return "redirect:/questions";
	}
	
	@GetMapping("/questions/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		// get question and add model attribute for display
		Question quest = questService.findQuestion(id);
		model.addAttribute("quest", quest);
		model.addAttribute("answers", quest.getAnswers());
		
		return "/questions/show.jsp";
	}
	
	@PostMapping("/questions/{id}/answer")
	public String answer(@PathVariable("id") Long id, @RequestParam("answer") String answer) {
		ansService.createAnswerWithQuestion(answer, id);
		return "redirect:/questions/{id}";
	}


}
