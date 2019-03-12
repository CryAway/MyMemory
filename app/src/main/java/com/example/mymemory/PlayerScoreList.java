package com.example.mymemory;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.*;
import java.util.*;


public class PlayerScoreList {

    private static final PlayerScoreList ourInstance = new PlayerScoreList();
    private PlayerScoreList() { }
    public static PlayerScoreList getInstance() {
        return ourInstance;
    }
    private List<PlayerScore> players;
    public void add()
    {
        players = new ArrayList<PlayerScore>();
        players.add(new PlayerScore("Nhan1",1,2,93));
        players.add(new PlayerScore("Nhan2",2,3,38));
        players.add(new PlayerScore("Nhan3",3,4,37));
        players.add(new PlayerScore("Nhan4",4,7,35));
        players.add(new PlayerScore("Nhan5",5,8,34));
        players.add(new PlayerScore("Nhan6",6,9,22));
        //Log.d("score", players.[0]);
    }
    public void add(String Name, int ID, int Card, int Numb)
    {
        players.add(new PlayerScore(Name,ID,Card,Numb));
    }
    public void Initial()
    {

    }
    /*public void saveData(String data)
    {
        try
        {
            FileOutputStream out = this.openFileOutput(ScoreFile, MODE_PRIVATE);
            out.write(data.getBytes());
            out.close();
            Toast.makeText(this,"File saved!",Toast.LENGTH_SHORT).show();
        }
        catch   (Exception e)
        {
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    public void readData() {
        try {
            // Mở một luồng đọc file.
            FileInputStream in = this.openFileInput(ScoreFile);
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            StringBuilder sb= new StringBuilder();
            String s= null;
            while((s= br.readLine())!= null)  {
                sb.append(s).append("\n");
            }
            in.close();
        } catch (Exception e) {
            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }*/
    public void remove(int i)
    {
        players.remove(i);
    }
    public List<PlayerScore> getPlayerScoreList(){return this.players;}
    public PlayerScore getPlayerScore(int value){return this.players.get(value);}
}
