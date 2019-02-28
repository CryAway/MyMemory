package com.example.mymemory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*lv = findViewById(R.id.ScoreBoard);
        PlayerScoreList.getInstance().add();
        lv.setAdapter(new ArrayAdapter<PlayerScore>(
                this,  //context (activity instance)
                android.R.layout.simple_list_item_1, //XML item layout
                PlayerScoreList.getInstance().getPlayerScoreList()) //array of data
        );

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(MainActivity.this, ScoreBoard.class);
                nextActivity.putExtra("President", i);
                startActivity(nextActivity);

            }
        });*/

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
