package com.example.mymemory;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;
import android.view.KeyEvent;

import java.util.Random;
import java.util.Scanner;

public class Game2 extends AppCompatActivity {

    private String numberToGuess;
    private int level = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        final Button enterButton = findViewById(R.id.enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkanswer();
            }
        });
        startRound(level);
    }

    protected void startRound(int level){
        final EditText input = (EditText) findViewById(R.id.userInput);
        final Button enterButton = findViewById(R.id.enter);
        input.setEnabled(false);
        enterButton.setEnabled(false);
        final TextView textViewToChange = findViewById(R.id.randomNumber);
        numberToGuess = randomNum(level);
        textViewToChange.setText(numberToGuess);
        startTimer();
    }

    //Declare timer
    CountDownTimer cTimer = null;

    //start timer function
    void startTimer() {
        final TextView textViewToChange = findViewById(R.id.randomNumber);
        cTimer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                textViewToChange.setText("");
                final Button enterButton = findViewById(R.id.enter);
                enterButton.setEnabled(true);
                final EditText input = (EditText) findViewById(R.id.userInput);
                input.setEnabled(true);
                input.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);

            }
        };
        cTimer.start();
    }


    //cancel timer
    void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }

    protected String randomNum(int length){
        String output = "";
        Random rand = new Random();
        while(output.length() < length){
            int num;
            if (output.length() == 0) {
                num = rand.nextInt(8) + 1;
            } else {
                num = rand.nextInt(9);
            }
            output = output + num;
        }
        return output;
    }

    protected void checkanswer()
    {
        final EditText input = (EditText) findViewById(R.id.userInput);
        boolean correctGuess = input.getText().toString().equals(numberToGuess);
        if (correctGuess) {
            final TextView score = findViewById(R.id.score);
            score.setText("Score: " + level);
            level++;
            input.setText("");
            startRound(level);
        } else {
            final TextView textViewToChange = findViewById(R.id.randomNumber);
            textViewToChange.setText("Wrong number: " + input.getText() + " Answer: " + numberToGuess);
            final Button enterButton = findViewById(R.id.enter);
            input.setVisibility(View.GONE);
            enterButton.setVisibility(View.GONE);

        }
    }
}



