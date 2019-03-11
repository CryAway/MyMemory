package com.example.mymemory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game1 extends AppCompatActivity {

    Button btnStart;
    TextView txtTimer;
    ImageView iv_11,iv_12,iv_13,iv_14,iv_21,iv_22,iv_23,iv_24,iv_31,iv_32,iv_33,iv_34;

    Integer[] cardsArray = {11,12,13,14,15,16,21,22,23,24,25,26};
    int image11,image12,image13,image14,image15,image16,
            image21,image22,image23,image24,image25,image26;

    int First, Second;
    int IdFirst, IdSec;
    boolean isFirst =true;
    Handler handler = new Handler();
    boolean isRun;
    long startTime, playedTime = 0L;
    boolean isStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        btnStart = findViewById(R.id.btnStart);
        txtTimer = findViewById(R.id.txtTimer);

        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);
        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);
        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);


        //The main purpose of setTag() : create a unique onClick method for each view
        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");


        //display the card images
        cardImages();

        //shuffle the images
        List<Integer> l = Arrays.asList(cardsArray);
        System.out.println(l);

        Collections.shuffle(l);

        System.out.println(l);


        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                   int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_11, theCard);
                }

            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_12, theCard);
                }
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_13, theCard);
                }
            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_14, theCard);
                }
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_21, theCard);
                }
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_22, theCard);
                }
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_23, theCard);
                }
            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_24, theCard);
                }
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_31, theCard);
                }
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_32, theCard);
                }
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_33, theCard);
                }
            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isStart==true) {
                    int theCard = Integer.parseInt((String) v.getTag());
                    correctImage(iv_34, theCard);
                }
            }
        });
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            playedTime = SystemClock.uptimeMillis() - startTime;
            long secs = (playedTime/1000);
            long mins= secs/60;
            secs = secs %60;
            long milliseconds = (playedTime%1000);
            txtTimer.setText(""+mins+":" + String.format("%02d",secs) + ":" + String.format("%02d",milliseconds));
            handler.postDelayed(this,0);
        }
    };
    protected void onStart(){
        super.onStart();
        clickStart();
    }
    void clickStart()
    {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRun)
                    return;
                isRun = true;
                startTime = SystemClock.uptimeMillis();
                isStart=true;
                handler.postDelayed(runnable, 0);
            }
        });
    }

    //set the correct image to the image view
    private  void correctImage(ImageView iv, int card) {
        if (cardsArray[card] == 11) {
            iv.setImageResource(image11);
        } else if (cardsArray[card] == 12) {
            iv.setImageResource(image12);
        } else if (cardsArray[card] == 13) {
            iv.setImageResource(image13);
        } else if (cardsArray[card] == 14) {
            iv.setImageResource(image14);
        } else if (cardsArray[card] == 15) {
            iv.setImageResource(image15);
        } else if (cardsArray[card] == 16) {
            iv.setImageResource(image16);
        } else if (cardsArray[card] == 21) {
            iv.setImageResource(image21);
        } else if (cardsArray[card] == 22) {
            iv.setImageResource(image22);
        } else if (cardsArray[card] == 23) {
            iv.setImageResource(image23);
        } else if (cardsArray[card] == 24) {
            iv.setImageResource(image24);
        } else if (cardsArray[card] == 25) {
            iv.setImageResource(image25);
        } else if (cardsArray[card] == 26) {
            iv.setImageResource(image26);
        }

        //check which image is selected and assign it to a temporary variable
        if (isFirst == true) {
            First = cardsArray[card];
            if (First > 20) {
                First = First - 10;
            }
            isFirst = !isFirst;
            IdFirst = card;
            iv.setEnabled(false);
        } else if (isFirst == false) {
            Second = cardsArray[card];
            if (Second > 20) {
                Second = Second - 10;
            }
            isFirst = !isFirst;
            IdSec = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    compare();
                }
            },1000);
        }
    }
    //if the selected images are equal, they are disappeared
    private void compare (){
        if(First==Second){
            if (IdFirst==0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if (IdFirst==1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if (IdFirst==2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if (IdFirst==3){
                iv_14.setVisibility(View.INVISIBLE);
            }else if (IdFirst==4){
                iv_21.setVisibility(View.INVISIBLE);
            }else if (IdFirst==5){
                iv_22.setVisibility(View.INVISIBLE);
            }else if (IdFirst==6){
                iv_23.setVisibility(View.INVISIBLE);
            }else if (IdFirst==7){
                iv_24.setVisibility(View.INVISIBLE);
            }else if (IdFirst==8){
                iv_31.setVisibility(View.INVISIBLE);
            }else if (IdFirst==9){
                iv_32.setVisibility(View.INVISIBLE);
            }else if (IdFirst==10){
                iv_33.setVisibility(View.INVISIBLE);
            }else if (IdFirst==11){
                iv_34.setVisibility(View.INVISIBLE);
            }

            if (IdSec==0){
                iv_11.setVisibility(View.INVISIBLE);
            }else if (IdSec==1){
                iv_12.setVisibility(View.INVISIBLE);
            }else if (IdSec==2){
                iv_13.setVisibility(View.INVISIBLE);
            }else if (IdSec==3){
                iv_14.setVisibility(View.INVISIBLE);
            }else if (IdSec==4){
                iv_21.setVisibility(View.INVISIBLE);
            }else if (IdSec==5){
                iv_22.setVisibility(View.INVISIBLE);
            }else if (IdSec==6){
                iv_23.setVisibility(View.INVISIBLE);
            }else if (IdSec==7){
                iv_24.setVisibility(View.INVISIBLE);
            }else if (IdSec==8){
                iv_31.setVisibility(View.INVISIBLE);
            }else if (IdSec==9){
                iv_32.setVisibility(View.INVISIBLE);
            }else if (IdSec==10){
                iv_33.setVisibility(View.INVISIBLE);
            }else if (IdSec==11){
                iv_34.setVisibility(View.INVISIBLE);
            }


        }else {
            iv_11.setImageResource(R.drawable.back_card);
            iv_12.setImageResource(R.drawable.back_card);
            iv_13.setImageResource(R.drawable.back_card);
            iv_14.setImageResource(R.drawable.back_card);
            iv_21.setImageResource(R.drawable.back_card);
            iv_22.setImageResource(R.drawable.back_card);
            iv_23.setImageResource(R.drawable.back_card);
            iv_24.setImageResource(R.drawable.back_card);
            iv_31.setImageResource(R.drawable.back_card);
            iv_32.setImageResource(R.drawable.back_card);
            iv_33.setImageResource(R.drawable.back_card);
            iv_34.setImageResource(R.drawable.back_card);



        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);


        //check if there is any image left
        imagesLeft();
    }
    private void imagesLeft(){
        if (iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_14.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_24.getVisibility()==View.INVISIBLE &&
                iv_31.getVisibility()==View.INVISIBLE &&
                iv_32.getVisibility()==View.INVISIBLE &&
                iv_33.getVisibility()==View.INVISIBLE &&
                iv_34.getVisibility()==View.INVISIBLE ){
            isRun = false;
            handler.removeCallbacks(runnable);
            AlertDialog.Builder alertDialogBuilder =new  AlertDialog.Builder(Game1.this);
            alertDialogBuilder

                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),Game1.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
    }
    }

    private void cardImages(){
        image11 = R.drawable.c1;
        image12 = R.drawable.c2;
        image13 = R.drawable.c3;
        image14 = R.drawable.c4;
        image15 = R.drawable.c5;
        image16 = R.drawable.c6;
        image21 = R.drawable.c11;
        image22 = R.drawable.c22;
        image23 = R.drawable.c33;
        image24 = R.drawable.c44;
        image25 = R.drawable.c55;
        image26 = R.drawable.c66;


    }

}
