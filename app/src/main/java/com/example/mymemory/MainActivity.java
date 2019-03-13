package com.example.mymemory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private String LastPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerScoreList.getInstance().add();
        PlayerScoreList.getInstance().readData(this); //Read data from file
        PlayerScoreList.getInstance().saveDataDefault(this,null);
        LastPlayer = PlayerScoreList.getInstance().readLastPlayer(this); //set Player
        //load Data from txt file
        //changeText();
    }
    /*public void changeText()
    {
        TextView tv = findViewById(R.id.MainView);
        String Welcome = "Hello" + players.get(Integer.parseInt(LastPlayer)).getName();
        tv.setText(Welcome);
    }*/
    //list of activities
    public void Player(View v)
    {
        Intent intent = new Intent(this, Player.class);
        startActivity(intent);
    }
    public void Information(View v)
    {
        Intent intent = new Intent(this, Information.class);
        startActivity(intent);
    }
    public void GameMenu(View v)
    {
        Intent intent = new Intent (this, GameMenu.class);
        startActivity(intent);
    }
    public void Scoreboard(View v)
    {
        Intent intent = new Intent (this, ScoreBoard.class);
        startActivity(intent);
    }
    //converter
    public static int stringToint( String str )
    {
        int i = 0, number = 0;
        boolean isNegative = false;
        int len = str.length();
        if( str.charAt(0) == '-' ){
            isNegative = true;

            i = 1;
        }
        while( i < len ){
            number *= 10;
            number += ( str.charAt(i++) - '0' );
        }
        if( isNegative )
            number = -number;
        return number;
    }
}

