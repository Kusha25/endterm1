package com.company.controllers;

import com.company.enteties.Question;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.Locale;

/**
 * @author Kuanyshbek
 */

public class QuizController {
    private final IQuestionRepository questionRepository;

    public QuizController(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    /**
         This code check the answers
     */
    public boolean checkAnswer(String answer, int id) {
        String right_answer = questionRepository.getQuestion(id).getAnswer();

        right_answer = right_answer.toLowerCase();
        right_answer = right_answer.trim();
        right_answer = right_answer.replaceAll("\\s+", " ");

        answer = answer.toLowerCase(Locale.ROOT);
        answer = answer.trim();
        answer = answer.replaceAll("\\s+", " ");

        if (right_answer.equals(answer)) {
            return true;
        }
        return false;
    }
}
