package com.example.mymemory;

import java.util.ArrayList;

public class PlayerScore {
    private String Name;
    private int ID;
    private int Card;
    private int Numb;

    public PlayerScore(String Name, int ID, int Card, int Numb)
    {
        this.Name=Name;
        this.ID=ID;
        this.Card=Card;
        this.Numb=Numb;
    }
    public String getName(){return Name;}
    public String getID(){return(Integer.toString(ID));}
    public String getScoreC(){return(Integer.toString(Card));}
    public String getScoreN(){return(Integer.toString(Numb));}

    public String toString() {return this.Name/* +  "Score C" + this.Card + "Score N" + this.Numb*/;}
}