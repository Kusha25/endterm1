package com.company.repositories.interfaces;

import com.company.enteties.Question;

import java.util.List;

/**
 * @author Darkhan
 */
public interface IQuestionRepository {
    boolean createQuestion(Question question);

    Question getQuestion(int id);

    List<Question> getAllQuestions();
}
