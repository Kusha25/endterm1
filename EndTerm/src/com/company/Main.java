package com.company;

import com.company.database.PostgresDB;
import com.company.database.interfaces.IDB;
import com.company.enteties.Question;
import com.company.repositories.PlayerRepository;
import com.company.repositories.QuestionRepository;
import com.company.repositories.interfaces.IPlayerRepository;
import com.company.repositories.interfaces.IQuestionRepository;

/**
 * @author Kuanyshbek
 */

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IQuestionRepository questionRepository = new QuestionRepository(db);
        IPlayerRepository playerRepository = new PlayerRepository(db);
        FrontEnd app = new FrontEnd(questionRepository, playerRepository);

        app.start();
    }
}
