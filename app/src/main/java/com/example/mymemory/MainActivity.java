package com.example.mymemory;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import java.io.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    Intent intent = getIntent();
    boolean Initial = true;
    private String ScoreFile="note.txt";
    private String ScoreFilePath= "Score";
    File myInternalFile;
    private static final MainActivity ourInstance = new MainActivity();
    public static MainActivity getInstance() {
        return ourInstance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(ScoreFilePath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory, ScoreFile);

        PlayerScoreList.getInstance().add();
        PlayerScoreList.getInstance().add("Nhan1111", 11, 22, 33);
        PlayerScoreList.getInstance().add("Nhan2222", 22, 33, 44);
        Initial=!Initial;
    }
    /////
    //




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
}
