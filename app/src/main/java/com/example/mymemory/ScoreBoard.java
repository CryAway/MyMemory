package com.example.mymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ScoreBoard extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        lv = findViewById(R.id.ScoreBoard);
        PlayerScoreList.getInstance().add();
        lv.setAdapter(new ArrayAdapter<PlayerScore>(
                this,  //context (activity instance)
                android.R.layout.simple_list_item_1, //XML item layout
                PlayerScoreList.getInstance().getPlayerScoreList()) //array of data
        );

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent();
                nextActivity.putExtra("players", i);
                startActivity(nextActivity);

            }
        });*/
    }


}
