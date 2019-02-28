package com.example.mymemory;

import java.util.ArrayList;
import java.util.List;

public class PlayerScoreList {
    private static final PlayerScoreList ourInstance = new PlayerScoreList();

    public static PlayerScoreList getInstance() {
        return ourInstance;
    }
    private List<PlayerScore> players;
    public void add()
    {
        players = new ArrayList<PlayerScore>();
        players.add(new PlayerScore("Nhan",1,2,93));
        players.add(new PlayerScore("Nhan",2,3,38));
        players.add(new PlayerScore("Nhan",3,4,37));
        players.add(new PlayerScore("Nhan",4,7,35));
        players.add(new PlayerScore("Nhan",5,8,34));
        players.add(new PlayerScore("Nhan",6,9,22));
    }
    public List<PlayerScore> getPlayerScoreList(){return this.players;}
    public PlayerScore getPlayerScore(int value){return this.players.get(value);}
}
/*
        */
