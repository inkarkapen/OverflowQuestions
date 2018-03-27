package com.inkarkapen.overflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inkarkapen.overflow.models.Answer;
import com.inkarkapen.overflow.models.Question;
import com.inkarkapen.overflow.models.Tag;
import com.inkarkapen.overflow.services.AnswerService;
import com.inkarkapen.overflow.services.QuestionService;
import com.inkarkapen.overflow.services.TagService;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", QuestionService.allQuestions());
		return "dashboard.jsp";
	}
	@RequestMapping("/question/new")
	public String newQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "newQuestion.jsp";
	}
	@PostMapping("/questions/submit")
	public String submitQuestion(@RequestParam(value="question") String newQuestion, @RequestParam("raw_tags") String raw_tags) {
		Question question = new Question(newQuestion);
		question.setTags();
		String[] tag_strings = raw_tags.split("\\s+");
		for(int i=0;i<tag_strings.length;i++) {
			Tag tag = TagService.findBySubject(tag_strings[i]);
			if(tag == null) {
				Tag newTag = new Tag(tag_strings[i]);
				TagService.addTag(newTag);
				QuestionService.addTag(question, newTag);
			} else {
				QuestionService.addTag(question, tag);
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(Model model, @PathVariable("id") Long id) {
		Question question = QuestionService.findById(id);
		//question.setAnswers();
		model.addAttribute("question", question);
		model.addAttribute("questionAnswer", new Answer());
		return "showQuestion.jsp";
	}
	
	@PostMapping("/answers/submit")
	//public String addAnswer(@RequestParam(value="question_id") Long question_id, @RequestParam("answer_txt") String answer_txt) {
	public String addAnswers(@Valid @ModelAttribute("questionAnswer") Answer answer, BindingResult result) {
		AnswerService.addAnswer(answer);
		return "redirect:/questions/" + answer.getQuestion().getId();
	}

}
