package com.company.enteties;

/**
 * @author Kuanyshbek
 */

public class Question {
    private int id;
    private String question;
    private String answer;
    private String type;

    public Question() {
    }

    public Question(String question, String answer, String type) {
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
    /**
     * A method that changes the id  question, answer and type of questions
     *
     */
    public Question(int id, String question, String answer, String type) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
    /**
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
     * Method, which changes the id of the question
     *
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     *
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Method, which changes the question
     *
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    /**
     *
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }
    /**
     * Method, which changes the answer
     *
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * Method, which changes the type
     *
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Overridden method toString from cosmic superclass Object
     * @return String value
     */
    @Override
    public String toString() {
        return id + ". " + question + "\n" +
                "Answer: " + answer + "    Type: " + type + "\n";
    }
}
