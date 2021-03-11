package com.company;

import com.company.admin.Admin;
import com.company.controllers.PlayerController;
import com.company.controllers.QuestionController;
import com.company.repositories.interfaces.IPlayerRepository;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Darkhan
 */

public class FrontEnd {
    private final Scanner scanner;
    private final PlayerController playerController;
    private final Admin admin;
    private final Quiz quiz;

    public FrontEnd(IQuestionRepository questionRepository, IPlayerRepository playerRepository) {
        playerController = new PlayerController(playerRepository);
        scanner = new Scanner(System.in);
        admin = new Admin(questionRepository);
        quiz = new Quiz(questionRepository, playerRepository);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to the quiz application from Darkhan and Kuanyshbek");
            System.out.println("Select option:");
            System.out.println("1. Solo game");
            System.out.println("2. Get scoreboard of solo game");
            System.out.println("0. Exit");

            try {
                System.out.print("Enter option (0-2): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    soloMenu();
                } else if (option == 2) {
                    getScoreboard();
                } else if (option == 2565) {
                    adminMenu();
                } else if (option == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
        }
    }

    public void adminMenu() {
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (admin.checkPassword(password) == true) {
            admin.adminControl();
        } else {
            System.out.println("Access denied");
        }
    }

    public void soloMenu() {
        System.out.print("Enter your name: ");
        String username = scanner.next();

        String registration = playerController.registerPlayer(username);
        int id = playerController.getId();

        System.out.print("Starting game");
        for (int i = 0; i < 3; i++) {
            System.out.print(" .");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

        quiz.quizStart(id);
    }

    public void getScoreboard() {
        playerController.getScoreboard();
    }
}
