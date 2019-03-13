package com.example.mymemory;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class CreatePlayer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_player);
    }
    public void sendName(View view)
    {
        Intent intent = new Intent(this, SelectPlayer.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String NewName = editText.getText().toString();//get Name in order to add to the ArrayList
        //intent.putExtra(Name, message);
        //MainActivity.getInstance().saveData(NewName);
        PlayerScoreList.getInstance().add(NewName); //add
        PlayerScoreList.getInstance().saveDataDefault(this, "Created"); //save
        startActivity(intent);
    }
}