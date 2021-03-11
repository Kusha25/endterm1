package com.company.enteties;

/**
 * @author Kuanyshbek
 */

public class Player {
    private int id;
    private String username;
    private int score;

    public Player() {
    }

    public Player(String username) {
        this.username = username;
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
    }
    /**
     * A method that changes the id and username and score
     *
     */
    public Player(int id, String username, int score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }
/*
 bunch of getters and setters
 */
    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Method, which changes the id of the players
     *
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *
     * @return name of user
     */
    public String getUsername() {
        return username;
    }
    /**
     * Method, which changes the name of the player
     *
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     *
     * @return score of player
     */
    public int getScore() {
        return score;
    }
    /**
     *
     * @increase points
     */
    public void addPoints() {
        score++;
    }
    /**
     * Overridden method toString from cosmic superclass Object
     * @return String value
     */
    @Override
    public String toString() {
        return id + ". " + username + " Your score: " + score;
    }
}
