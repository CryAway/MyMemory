package com.example.mymemory;

import java.util.ArrayList;

public class PlayerScore {
    private String Name;
    private int ID;
    private int ScoreC;
    private int ScoreN;

    public PlayerScore(String Name, int dayS, int dayE, int Des)
    {
        this.Name=Name;
        this.ID=ID;
        this.ScoreC=ScoreC;
        this.ScoreN=ScoreN;
    }
    public String getName(){return Name;}
    public String getID(){return(Integer.toString(ID));}
    public String getScoreC(){return(Integer.toString(ScoreC));}
    public String getScoreN(){return(Integer.toString(ScoreN));}

    public String toString() {return this.Name;}
}