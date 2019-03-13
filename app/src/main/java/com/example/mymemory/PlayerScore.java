package com.example.mymemory;

import java.util.ArrayList;

public class PlayerScore {
    private String Name;
    private String ID;
    private String Card;
    private String Numb;
    //constructor
    public PlayerScore(String Name, String ID, String Card, String Numb)
    {
        this.Name=Name;
        this.ID=ID;
        this.Card=Card;
        this.Numb=Numb;
    }
    //get information functions
    public String getName(){return Name;}
    public String getID(){return ID;}
    public String getScoreC(){return((Card));}
    public String getScoreN(){return((Numb));}
    public void setCard(String Card){this.Card=Card;}
    public void setNumb(String Numb){this.Numb=Numb;}
    //show listview
    public String toString() {return this.Name +  "   Time:    " + this.Card + "   Score:    " + this.Numb + "   ";}
}