package com.company.controllers;

import com.company.enteties.Question;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.List;

/**
 * @author Darkhan
 */

public class QuestionController {
    private final IQuestionRepository questionRepository;

    public QuestionController(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    /**
        This method create a questions
     */

    public String createQuestion(String question, String answer, String type) {
        Question question1 = new Question(question, answer, type);

        boolean created = questionRepository.createQuestion(question1);

        return (created ? "Question creation was failed!" : "Question was created!");
    }
    /**
     *
     * @return question
     */
    public Question getQuestion(int id) {
        Question question = questionRepository.getQuestion(id);

        return question;
    }

    public String getAllQuestions() {
        List<Question> questions = questionRepository.getAllQuestions();

        return questions.toString();
    }
}
