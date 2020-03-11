package esi.siw.child_app.culture_game;

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

import java.util.ArrayList;

import esi.siw.child_app.GC_Evaluation_Activity;
import esi.siw.child_app.MainActivity;
import esi.siw.child_app.R;
import esi.siw.child_app.fastcalcul_game.GameFastCalcul_Activity;


public class GameCulture_Activity extends AppCompatActivity  {


    ArrayList<ModelQS> listeCulture = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;

    String score = "score";

    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_culture);

        initialing(listeCulture);

        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);


        final TextView question = (TextView) findViewById(R.id.question_view);

        final Button PR_btn1 = (Button) findViewById(R.id.r_pr1);
        final Button PR_btn2 = (Button) findViewById(R.id.r_pr2);
        final Button PR_btn3 = (Button) findViewById(R.id.r_pr3);
        final Button PR_btn4 = (Button) findViewById(R.id.r_pr4);

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

        final ImageView score11 = (ImageView) findViewById(R.id.score11);
        final ImageView score12 = (ImageView) findViewById(R.id.score12);
        final ImageView score13 = (ImageView) findViewById(R.id.score13);
        final ImageView score14 = (ImageView) findViewById(R.id.score14);
        final ImageView score15 = (ImageView) findViewById(R.id.score15);
        final ImageView score16 = (ImageView) findViewById(R.id.score16);
        final ImageView score17 = (ImageView) findViewById(R.id.score17);
        final ImageView score18 = (ImageView) findViewById(R.id.score18);
        final ImageView score19 = (ImageView) findViewById(R.id.score19);
        final ImageView score20 = (ImageView) findViewById(R.id.score20);

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
                Intent intent =new Intent(GameCulture_Activity.this, GameCulture_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameCulture_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        question.setText(listeCulture.get(0).getQuestion());

        PR_btn1.setText(listeCulture.get(0).getPr1());
        PR_btn2.setText(listeCulture.get(0).getPr2());
        PR_btn3.setText(listeCulture.get(0).getPr3());
        PR_btn4.setText(listeCulture.get(0).getPr4());

        PR_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeCulture.get(compter-1).getResponse().equals(PR_btn1.getText().toString())  ){
                    PR_btn1.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.true1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.true1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.true1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.true1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.true1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.true1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.true1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.true1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.true1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.true1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.true1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.true1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.true1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.true1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.true1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.true1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.true1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.true1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.true1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.true1);
                                }

                                PR_btn1.setTextColor(Color.BLACK);


                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());

                            }



                        }
                    }, 1000);

                }else{
                    PR_btn1.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.false1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.false1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.false1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.false1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.false1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.false1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.false1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.false1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.false1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.false1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.false1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.false1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.false1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.false1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.false1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.false1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.false1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.false1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.false1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.false1);
                                }


                                PR_btn1.setTextColor(Color.BLACK);


                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

        PR_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeCulture.get(compter-1).getResponse().equals(PR_btn2.getText().toString())  ){
                    PR_btn2.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.true1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.true1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.true1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.true1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.true1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.true1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.true1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.true1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.true1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.true1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.true1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.true1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.true1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.true1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.true1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.true1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.true1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.true1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.true1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.true1);
                                }

                                PR_btn2.setTextColor(Color.BLACK);


                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());

                            }



                        }
                    }, 1000);

                }else{
                    PR_btn2.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.false1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.false1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.false1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.false1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.false1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.false1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.false1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.false1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.false1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.false1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.false1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.false1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.false1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.false1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.false1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.false1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.false1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.false1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.false1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.false1);
                                }


                                PR_btn2.setTextColor(Color.BLACK);


                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });


        PR_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeCulture.get(compter-1).getResponse().equals(PR_btn3.getText().toString())  ){
                    PR_btn3.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.true1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.true1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.true1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.true1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.true1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.true1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.true1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.true1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.true1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.true1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.true1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.true1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.true1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.true1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.true1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.true1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.true1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.true1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.true1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.true1);
                                }
                                PR_btn3.setTextColor(Color.BLACK);



                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());

                            }



                        }
                    }, 1000);

                }else{
                    PR_btn3.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.false1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.false1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.false1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.false1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.false1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.false1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.false1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.false1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.false1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.false1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.false1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.false1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.false1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.false1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.false1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.false1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.false1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.false1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.false1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.false1);
                                }


                                PR_btn3.setTextColor(Color.BLACK);


                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

        PR_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeCulture.get(compter-1).getResponse().equals(PR_btn4.getText().toString())  ){
                    PR_btn4.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.true1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.true1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.true1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.true1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.true1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.true1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.true1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.true1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.true1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.true1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.true1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.true1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.true1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.true1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.true1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.true1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.true1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.true1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.true1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.true1);
                                }

                                PR_btn4.setTextColor(Color.BLACK);



                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());

                            }



                        }
                    }, 1000);

                }else{
                    PR_btn4.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeCulture.size()){
                                Intent intent =new Intent(GameCulture_Activity.this, GC_Evaluation_Activity.class);
                                intent.putExtra("evaluation_c", evaluation);
                                startActivity(intent);
                            }else{
                                if(compter == 1){
                                    score1.setImageResource(R.drawable.false1);
                                }else if(compter == 2){
                                    score2.setImageResource(R.drawable.false1);
                                }else if(compter == 3){
                                    score3.setImageResource(R.drawable.false1);
                                }else if(compter == 4){
                                    score4.setImageResource(R.drawable.false1);
                                }else if(compter == 5){
                                    score5.setImageResource(R.drawable.false1);
                                }else if(compter == 6){
                                    score6.setImageResource(R.drawable.false1);
                                }else if(compter == 7){
                                    score7.setImageResource(R.drawable.false1);
                                }else if(compter == 8){
                                    score8.setImageResource(R.drawable.false1);
                                }else if(compter == 9){
                                    score9.setImageResource(R.drawable.false1);
                                }else if(compter == 10){
                                    score10.setImageResource(R.drawable.false1);
                                }else if(compter == 11){
                                    score11.setImageResource(R.drawable.false1);
                                }else if(compter == 12){
                                    score12.setImageResource(R.drawable.false1);
                                }else if(compter == 13){
                                    score13.setImageResource(R.drawable.false1);
                                }else if(compter == 14){
                                    score14.setImageResource(R.drawable.false1);
                                }else if(compter == 15){
                                    score15.setImageResource(R.drawable.false1);
                                }else if(compter == 16){
                                    score16.setImageResource(R.drawable.false1);
                                }else if(compter == 17){
                                    score17.setImageResource(R.drawable.false1);
                                }else if(compter == 18){
                                    score18.setImageResource(R.drawable.false1);
                                }else if(compter == 19){
                                    score19.setImageResource(R.drawable.false1);
                                }else if(compter == 20){
                                    score20.setImageResource(R.drawable.false1);
                                }


                                PR_btn4.setTextColor(Color.BLACK);



                                question.setText(listeCulture.get(compter).getQuestion());

                                PR_btn1.setText(listeCulture.get(compter).getPr1());
                                PR_btn2.setText(listeCulture.get(compter).getPr2());
                                PR_btn3.setText(listeCulture.get(compter).getPr3());
                                PR_btn4.setText(listeCulture.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

    }

    public void initialing(ArrayList<ModelQS> liste){

        liste.add(new ModelQS("ماهي أصغر دولة عربية مساحة ؟","البحرين","المغرب","البحرين","تونس","قطر"));
        liste.add(new ModelQS("المخ هو من أعضاء .. ؟","الجهاز العصبي","الجهاز الهضمي","الجهاز العصبي","الجهاز الدوري","الجهاز التنفسي"));
        liste.add(new ModelQS("من هو بلد المليون و نصف مليون شهيد ؟","الجزائر","مصر","الكويت","تونس","الجزائر"));
        liste.add(new ModelQS("ما هي عاصمة الدولة العباسية ؟","بغداد","الكوفة","المدينة المنورة","بغداد","الشام"));
        liste.add(new ModelQS("ما هو الذنب الذي لا يغفره الله عزوجل ؟","الشرك","الشرك","القتل","الزنا","الكذب"));
        liste.add(new ModelQS("من هو اول رئيس لدولة الجزائر ؟","أحمد بن بلة","هواري بومدين","أحمد بن بلة","كريم بلقاسم","اليمين زروال"));
        liste.add(new ModelQS("ما هو أكبر محيط في العالم ؟","الهادي","الأطلسي","الأطلنطي","الهندي","الهادي"));
        liste.add(new ModelQS("ماهو اذكى الحيوانات ؟","الدلفين","القط","الأسد","الدلفين","القرد"));
        liste.add(new ModelQS("أين يقع ثالث أكبر مسجد في العالم ؟","الجزائر","الجزائر","قطر","الأردن","مصر"));
        liste.add(new ModelQS("ما هو أقرب كوكب إلى الشمس ؟","عطارد","عطارد","الزهرة","زحل","المريخ"));

        liste.add(new ModelQS("ما هي السورة التي تعدل ثلث القرآن ؟","الإخلاص","الرحمن","البقرة","الإخلاص","التوبة"));
        liste.add(new ModelQS("ما هي أكبر دولة في العالم مساحة ؟","روسيا","كندا","روسيا","الصين","أستراليا"));
        liste.add(new ModelQS("تكبيرة الإحرام تعتبر من.. ؟","أركان الصلاة","شروط الصلاة","سنن الصلاة","واجبات الصلاة","أركان الصلاة"));
        liste.add(new ModelQS("من هو مخترع علم الجبر ؟","الخوارزمي","الخوارزمي","البيروني","نيوتن","عباس بن فرناس"));
        liste.add(new ModelQS("من هو العالم الجزائري الأكثر اختراعا في الإلكترونيات ؟","بلقاسم حبة","إلياس زرهوني","بلقاسم حبة","كمال يوسف","مصطفى إسحاق"));
        liste.add(new ModelQS("أول من اعتنق الإسلام من الرجال ؟","أبوبكر الصديق","عثمان بن عفان","عمر بن الخطاب","أبوبكر الصديق","سعد بن معاذ"));
        liste.add(new ModelQS("ماهي أول دولة استخدمت طابع البريد ؟","بريطانيا","ألمانيا","سويسرا","مصر","بريطانيا"));
        liste.add(new ModelQS("ما هي اعظم سورة في القرآن الكريم ؟","الفاتحة","الرحمن","الفاتحة","الملك","الرعد"));
        liste.add(new ModelQS("من هو مخترع الحاسوب ؟","تشارلز بابيج","بيل غيتس","ستيف جوبز","تشارلز بابيج","ستيف وزنياك"));
        liste.add(new ModelQS("ما هو أول ما يحاسب عنه العبد يوم القيامة ؟","الصلاة","الصلاة","الصيام","صلة الرحم","الزكاة"));


    }

}
