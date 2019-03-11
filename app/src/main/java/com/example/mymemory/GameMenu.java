package com.example.mymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
    }

    public void Game1(View v)
    {
        Intent intent = new Intent(this, Game1.class);
        startActivity(intent);
    }
    public void Game2(View v)
    {
        Intent intent = new Intent(this, Game2.class);
        startActivity(intent);
    }
}
