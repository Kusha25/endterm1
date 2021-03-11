package com.company;

import com.company.controllers.PlayerController;
import com.company.controllers.QuestionController;
import com.company.controllers.QuizController;
import com.company.enteties.Player;
import com.company.enteties.Question;
import com.company.repositories.interfaces.IPlayerRepository;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.Scanner;

/**
 * @author Darkhan
 */

public class Quiz {
    private final Scanner scanner;
    private final QuestionController questionController;
    private final QuizController quizController;
    private final PlayerController playerController;

    public Quiz(IQuestionRepository questionRepository, IPlayerRepository playerRepository) {
        scanner = new Scanner(System.in);
        questionController = new QuestionController(questionRepository);
        quizController = new QuizController(questionRepository);
        playerController = new PlayerController(playerRepository);
    }
/**
  This code check player's answers, will add points
 */
    public void quizStart(int id) {
        int i = 1;
        while (true) {
            if (questionController.getQuestion(i) == null) {
                break;
            }

            if (i == 7) {
                i++;
            }

            Question question = questionController.getQuestion(i);
            System.out.println(question.getQuestion());

            Player player = playerController.getPlayer(id);
            System.out.print("Your answer: ");

            String answer = scanner.next();

            if (answer.equals("exit")) {
                break;
            }

            if (quizController.checkAnswer(answer, question.getId())) {
                player.addPoints();
                playerController.addPoint(player.getId(), player.getScore());
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer");
            }

            System.out.println("Your score: " + player.getScore());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Enter exit if you want to exit!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            i++;
        }

        System.out.println("Thank you for the game!");
    }

}
