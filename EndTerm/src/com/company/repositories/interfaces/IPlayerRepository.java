package com.company.repositories.interfaces;

import com.company.enteties.Player;

import java.util.List;

/**
 * @author Darkhan
 */

public interface IPlayerRepository {
    boolean registerPlayer(Player player);

    Player getPlayer(int id);

    boolean addPoint(int id, int score);

    int getId();

    List<Player> getScoreboard();
}
