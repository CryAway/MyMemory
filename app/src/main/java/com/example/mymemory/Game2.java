
package com.example.mymemory;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game2 extends AppCompatActivity {
    //state of the game
    private String numberToRemember;
    private int level = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        //start the game
        startRound(level);

        final Button enterButton = findViewById(R.id.enter);
        //an event for button click when user gives the input
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkanswer();
            }
        });
        //we hide the replay button at the start
        final Button replay = findViewById(R.id.replay);
        replay.setVisibility(View.GONE);

        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when replay button is clicked, do these:
                level = 1;
                final TextView score = findViewById(R.id.score);
                score.setText("Score: 0");
                final Button enterButton = findViewById(R.id.enter);
                final EditText input = (EditText) findViewById(R.id.userInput);
                //remove the previous input from last game
                input.setText("");
                input.setVisibility(View.VISIBLE);
                enterButton.setVisibility(View.VISIBLE);
                replay.setVisibility(View.GONE);
                startRound(level);
            }
        });
    }

    
    protected void startRound(int level){
        final EditText input = (EditText) findViewById(R.id.userInput);
        final Button enterButton = findViewById(R.id.enter);
        //disable input and enter buttons so user cannot type before the timer
        input.setEnabled(false);
        enterButton.setEnabled(false);
        final TextView textDisplay = findViewById(R.id.randomNumber);
        numberToRemember = createRandomNumber(level);
        textDisplay.setText(numberToRemember);
        startTimer();
    }

    //start timer function
    void startTimer() {
        CountDownTimer cTimer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                //when the timer ends, do these:
                //first, clear the numberToRemember text
                final TextView textDisplay = findViewById(R.id.randomNumber);
                textDisplay.setText("");
                //enable the input and enter buttons so user can type the answer now
                final Button enterButton = findViewById(R.id.enter);
                enterButton.setEnabled(true);
                final EditText input = (EditText) findViewById(R.id.userInput);
                input.setEnabled(true);
                //automatically bring up the input number pad
                input.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(input, InputMethodManager.SHOW_IMPLICIT);

            }
        };
        //after defining the timer, we can start it
        cTimer.start();
    }



    protected String createRandomNumber(int lhkgjfh){
        //make a storing box for the random number
        String output = "";
        Random rand = new Random();
        //create random numbers until it has the same amount of digits as the given length
        while(output.length() < lhkgjfh){
            int num;
            if (output.length() == 0) {
                //first number cannot be zero, only 1~9
                num = rand.nextInt(8) + 1;
            } else {
                //from second number, the rest can be 0~9
                num = rand.nextInt(9);
            }
            //put the number into the storing box
            output = output + num;
        }
        return output;
    }

    protected void checkanswer()
    {
        final EditText input = (EditText) findViewById(R.id.userInput);
        boolean correctGuess = input.getText().toString().equals(numberToRemember);
        if (correctGuess) {
            final TextView score = findViewById(R.id.score);
            score.setText("Score: " + level);
            //after user passed the round, we clear the input they typed
            input.setText("");
            //increase the level and start the next round
            level++;
            startRound(level);
        } else {
            //game over, hide input and enter buttons
            final Button enterButton = findViewById(R.id.enter);
            input.setVisibility(View.INVISIBLE);
            enterButton.setVisibility(View.GONE);

            //show the correct answer
            final TextView textDisplay = findViewById(R.id.randomNumber);
            textDisplay.setText("Wrong number: " + input.getText() + " Answer: " + numberToRemember);

            //show replay button
            final Button replay = findViewById(R.id.replay);
            replay.setVisibility(View.VISIBLE);
        }
    }
}



