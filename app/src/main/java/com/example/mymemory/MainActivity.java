package com.example.mymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hi I'm Nhannn
        //Hello Lily is here.
        //Vy
        //asd
    }
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
