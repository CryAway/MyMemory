package com.example.mymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Player extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }
    public void NewPlayer(View v)
    {
        Intent intent = new Intent(this, CreatePlayer.class);
        startActivity(intent);
    }
    public void SelectPlayer(View v)
    {
        Intent intent = new Intent(this, SelectPlayer.class);
        startActivity(intent);
    }
    public void RemovePlayer(View v)
    {
        Intent intent = new Intent(this, RemovePlayer.class);
        startActivity(intent);
    }

}
