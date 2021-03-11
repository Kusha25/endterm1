package com.company.controllers;

import com.company.enteties.Player;
import com.company.enteties.Question;
import com.company.repositories.interfaces.IPlayerRepository;
import com.company.repositories.interfaces.IQuestionRepository;

import java.util.List;

/**
 * @author Darkhan
 */

public class PlayerController {
    private final IPlayerRepository playerRepository;

    public PlayerController(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
/**
    This code register a new players
 */
    public String registerPlayer(String name) {
        if (!name.isEmpty()) {
            Player player = new Player(name, 0);

            boolean created = playerRepository.registerPlayer(player);

            return ("Successfully registered!" + "\n" + playerRepository.getId() + player.getUsername());
        }

        return ("Do not send empty string");
    }

    /*
 bunch of getters and setters
 */
    /**
     *
     * @return player
     */
    public Player getPlayer(int id) {
        Player player = playerRepository.getPlayer(id);

        return player;
    }
    /**
     *
     * This method add point with is and score
     */
    public String addPoint(int id, int score) {
        boolean isAdded = playerRepository.addPoint(id, score);

        return (isAdded ? "Point was not added" : "Point was added");
    }
    /**
     *
     * @return id of player
     */
    public int getId() {
        int id = playerRepository.getId();

        return id;
    }
    /**
     *
     * This method get the score of players and output it
     */
    public void getScoreboard() {
        List<Player> players = playerRepository.getScoreboard();

        for (int i = 0; i < players.size(); i++) {
            String name = players.get(i).getUsername();
            int score = players.get(i).getScore();
            System.out.println(i + 1 + ". " + name + " score: " + score);
            i++;
        }
    }
}
