package esi.siw.child_app.game_word;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import esi.siw.child_app.G_Evaluation_Activity;
import esi.siw.child_app.MainActivity;
import esi.siw.child_app.R;

/**
 * Created by dell on 06/08/2018.
 */

public class GameWord_Activity extends AppCompatActivity  {

    ArrayList<ModelWG> listeWord = new ArrayList<>();

    int compter = 0;
    int evaluation = 0;

    String score = "score";

    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_word);

        initialing(listeWord);

        final MediaPlayer click_sound=MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound=MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound=MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound=MediaPlayer.create(this,R.raw.wrong_sound);


        final Button R_btn1 =(Button) findViewById(R.id.letter1) ;
        final Button R_btn2 =(Button) findViewById(R.id.letter2) ;
        final Button R_btn3 =(Button) findViewById(R.id.letter3) ;
        final Button R_btn4 =(Button) findViewById(R.id.letter4) ;
        final Button R_btn5 =(Button) findViewById(R.id.letter5) ;

        final TextView question_bar = (TextView) findViewById(R.id.question_bar);


        final Button PR_btn1 =(Button) findViewById(R.id.pr1) ;
        final Button PR_btn2 =(Button) findViewById(R.id.pr2) ;
        final Button PR_btn3 =(Button) findViewById(R.id.pr3) ;
        final Button PR_btn4 =(Button) findViewById(R.id.pr4) ;
        final Button PR_btn5 =(Button) findViewById(R.id.pr5) ;
        final Button PR_btn6 =(Button) findViewById(R.id.pr6) ;
        final Button PR_btn7 =(Button) findViewById(R.id.pr7) ;
        final Button PR_btn8 =(Button) findViewById(R.id.pr8) ;
        final Button PR_btn9 =(Button) findViewById(R.id.pr9) ;
        final Button PR_btn10 =(Button) findViewById(R.id.pr10) ;

        final ImageView score1 = (ImageView) findViewById(R.id.score1);
        final ImageView score2 = (ImageView) findViewById(R.id.score2);
        final ImageView score3 = (ImageView) findViewById(R.id.score3);
        final ImageView score4 = (ImageView) findViewById(R.id.score4);
        final ImageView score5 = (ImageView) findViewById(R.id.score5);
        final ImageView score6 = (ImageView) findViewById(R.id.score6);
        final ImageView score7 = (ImageView) findViewById(R.id.score7);
        final ImageView score8 = (ImageView) findViewById(R.id.score8);
        final ImageView score9 = (ImageView) findViewById(R.id.score9);
        final ImageView score10 = (ImageView) findViewById(R.id.score10);
        final ImageView question_image = (ImageView) findViewById(R.id.question_image);

        final LinearLayout repeat_item = (LinearLayout) findViewById(R.id.repeat_item);
        final LinearLayout return_item = (LinearLayout) findViewById(R.id.return_item);
        final LinearLayout close_item = (LinearLayout) findViewById(R.id.close_item);

        close_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });

        repeat_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameWord_Activity.this, GameWord_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameWord_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        question_bar.setText(listeWord.get(0).getQuestion());

        R_btn1.setText(listeWord.get(0).getPr1());
        R_btn2.setText(listeWord.get(0).getPr2());
        R_btn3.setText(listeWord.get(0).getPr3());
        R_btn4.setText(listeWord.get(0).getPr4());
        R_btn5.setText(listeWord.get(0).getPr5());

        PR_btn1.setText("ل");
        PR_btn2.setText("ك");
        PR_btn3.setText("ي");
        PR_btn4.setText("ن");
        PR_btn5.setText("م");
        PR_btn6.setText("د");
        PR_btn7.setText("س");
        PR_btn8.setText("ه");
        PR_btn9.setText("ا");
        PR_btn10.setText("ص");


        R_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                R_btn1.setText("");
                drop_sound.start();

            }
        });

        R_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                R_btn2.setText("");
                drop_sound.start();
            }
        });

        R_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                R_btn3.setText("");
                drop_sound.start();
            }
        });

        R_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                R_btn4.setText("");
                drop_sound.start();
            }
        });

        R_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                R_btn5.setText("");
                drop_sound.start();
            }
        });

        PR_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn1.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn1.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn1.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn1.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn1.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                    }

                }


                });

        PR_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn2.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn2.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn2.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn2.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn2.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn3.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn3.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn3.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn3.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn3.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn4.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn4.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn4.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn4.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn4.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });


        PR_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn5.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn5.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn5.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn5.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn5.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn6.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn6.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn6.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn6.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn6.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn7.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn7.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn7.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn7.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn7.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn8.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn8.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn8.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn8.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn8.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });

        PR_btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn9.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn9.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn9.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn9.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn9.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });


        PR_btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score + String.valueOf(compter);

                click_sound.start();

                if (R_btn1.getText().toString().equals("")){
                    R_btn1.setText(PR_btn10.getText().toString());
                }else if(R_btn2.getText().toString().equals("") && !(R_btn1.getText().toString().equals(""))) {
                    R_btn2.setText(PR_btn10.getText().toString());
                }else if (R_btn3.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) ) {
                    R_btn3.setText(PR_btn10.getText().toString());
                } else if (R_btn4.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) ){
                    R_btn4.setText(PR_btn10.getText().toString());
                } else if (R_btn5.getText().toString().equals("") && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ) {
                    R_btn5.setText(PR_btn10.getText().toString());
                }
                if (!(R_btn5.getText().toString().equals("")) && !(R_btn1.getText().toString().equals("")) && !(R_btn2.getText().toString().equals("")) && !(R_btn3.getText().toString().equals("")) && !(R_btn4.getText().toString().equals("")) ){

                    compter = compter + 1;
                    question_image.setImageResource(0);
                    response = R_btn1.getText().toString()+R_btn2.getText().toString()+R_btn3.getText().toString()+R_btn4.getText().toString()+R_btn5.getText().toString();
                    if(response.equals(listeWord.get(compter-1).getResponse())){

                        success_sound.start();

                        evaluation = evaluation + 1;


                        R_btn1.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn2.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn3.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn4.setBackgroundColor(Color.parseColor("#7FFF00"));
                        R_btn5.setBackgroundColor(Color.parseColor("#7FFF00"));

                        Toast.makeText(GameWord_Activity.this, "إجابة صحيحة: "+listeWord.get(compter-1).getResponse(), Toast.LENGTH_LONG).show();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.true1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.true1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.true1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.true1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.true1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.true1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.true1);

                                    }


                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());


                                }

                            }
                        }, 1000);


                    }else{
                        R_btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        R_btn5.setBackgroundColor(Color.parseColor("#FF0000"));

                        fail_sound.start();

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms

                                if(compter == listeWord.size()){
                                    Intent intent =new Intent(GameWord_Activity.this, G_Evaluation_Activity.class);
                                    intent.putExtra("evaluation", evaluation);
                                    startActivity(intent);
                                }else{
                                    if(compter == 1){
                                        score1.setImageResource(R.drawable.false1);
                                    }else if(compter == 2){
                                        score2.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.enginner);
                                    }else if(compter == 3){
                                        score3.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("أ");
                                        PR_btn8.setText("ب");
                                    }else if(compter == 4){
                                        score4.setImageResource(R.drawable.false1);
                                    }else if(compter == 5){
                                        score5.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.lion);
                                    }else if(compter == 6){
                                        score6.setImageResource(R.drawable.false1);
                                        PR_btn2.setText("ح");
                                        PR_btn3.setText("ى");
                                        PR_btn4.setText("ت");
                                        PR_btn8.setText("ع");

                                    }else if(compter == 7){
                                        score7.setImageResource(R.drawable.false1);
                                    }else if(compter == 8){
                                        score8.setImageResource(R.drawable.false1);
                                        question_image.setImageResource(R.drawable.miel);
                                    }else if(compter == 9){
                                        PR_btn2.setText("إ");
                                        PR_btn3.setText("ي");
                                        PR_btn4.setText("ر");
                                        score9.setImageResource(R.drawable.false1);
                                    }else if(compter == 10){
                                        score10.setImageResource(R.drawable.false1);

                                    }

                                    R_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn4.setBackgroundResource(android.R.drawable.btn_default);
                                    R_btn5.setBackgroundResource(android.R.drawable.btn_default);


                                    question_bar.setText(listeWord.get(compter).getQuestion());

                                    R_btn1.setText(listeWord.get(compter).getPr1());
                                    R_btn2.setText(listeWord.get(compter).getPr2());
                                    R_btn3.setText(listeWord.get(compter).getPr3());
                                    R_btn4.setText(listeWord.get(compter).getPr4());
                                    R_btn5.setText(listeWord.get(compter).getPr5());
                                }



                            }
                        }, 1000);


                    }


                }

            }


        });
    }


    public void initialing(ArrayList<ModelWG> liste){

        liste.add(new ModelWG("الحيوان الذي ينام و عيناه مفتوحتان ؟","السمك","ا","","س","","ك"));
        liste.add(new ModelWG("ما هو أطول نهر في العالم ؟","النيل","","","","ي","ل"));
        liste.add(new ModelWG("","مهندس","","","ن","",""));

        liste.add(new ModelWG("نوع من الخضروات ذكره الله عزوجل في القرآن الكريم ؟","البصل","ا","","","","ل"));
        liste.add(new ModelWG("أكبر بلد من حيث تعداد السكان ؟","الصين","","","","","ن"));
        liste.add(new ModelWG("","الأسد","ا","","","",""));

        liste.add(new ModelWG("فترة زمنية أقسم بها الله عزوجل في القرآن الكريم ؟","الضحى","","","ض","",""));
        liste.add(new ModelWG("حيوان برمائي مفترس ؟","تمساح","","","","",""));
        liste.add(new ModelWG("","العسل","","","","",""));

        liste.add(new ModelWG("النبي الذي قبضت روحه في السماء ؟","إدريس","","","","",""));



    }



}

