package com.inkarkapen.overflow.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.overflow.models.Answer;
import com.inkarkapen.overflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private static AnswerRepository answerRepository;
    public AnswerService(AnswerRepository answerRepository) {
    	this.answerRepository = answerRepository;
    }
    
    public static List<Answer> allAnswers() {
        return answerRepository.findAll();
    }

	public static void addAnswer(@Valid Answer answer) {
		answerRepository.save(answer);
	}

	public static Answer findById(Long id) {
		return answerRepository.findById(id).orElse(null);
	}
}
