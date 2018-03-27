package com.inkarkapen.overflow.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.overflow.models.Answer;
import com.inkarkapen.overflow.models.Question;
import com.inkarkapen.overflow.models.Tag;
import com.inkarkapen.overflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private static QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
    	this.questionRepository = questionRepository;
    }
    
    public static List<Question> allQuestions() {
        return questionRepository.findAll();
    }

	public static void addQuestion(@Valid Question question) {
		questionRepository.save(question);
	}

	public static Question findById(Long id) {
		return questionRepository.findById(id).orElse(null);
	}

	public static void addTag(Question question, Tag Tag) {
		question.getTags().add(Tag);
		questionRepository.save(question);
	}

	public static void addAnswer(Question question, Answer answer) {
		question.getAnswers().add(answer);
		questionRepository.save(question);
	}
}
