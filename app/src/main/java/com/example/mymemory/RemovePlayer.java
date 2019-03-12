package com.example.mymemory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RemovePlayer extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_player);
        setContentView(R.layout.activity_select_player);
        lv = findViewById(R.id.SelectPlayer);
        lv.setAdapter(new ArrayAdapter<PlayerScore>(
                this,  //context (activity instance)
                android.R.layout.simple_list_item_1, //XML item layout
                PlayerScoreList.getInstance().getPlayerScoreList()) //array of data
        );

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(RemovePlayer.this,SelectPlayer.class);
                nextActivity.putExtra("players", i);
                PlayerScoreList.getInstance().remove(i);
                startActivity(nextActivity);
            }
        });
    }
}
