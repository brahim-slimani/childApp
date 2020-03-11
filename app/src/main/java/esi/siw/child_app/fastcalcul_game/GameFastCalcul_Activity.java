package esi.siw.child_app.fastcalcul_game;

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

import esi.siw.child_app.G_Evaluation_Activity;
import esi.siw.child_app.MainActivity;
import esi.siw.child_app.R;
import esi.siw.child_app.culture_game.ModelQS;


/**
 * Created by dell on 10/08/2018.
 */

public class GameFastCalcul_Activity extends AppCompatActivity  {


    ArrayList<ModelQS> listeQuik = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;

    String score = "score";

    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_fastcalcul);

        initialing(listeQuik);

        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);


        final TextView question = (TextView) findViewById(R.id.question_view);

        final Button PR_btn1 = (Button) findViewById(R.id.n_pr1);
        final Button PR_btn2 = (Button) findViewById(R.id.n_pr2);
        final Button PR_btn3 = (Button) findViewById(R.id.n_pr3);
        final Button PR_btn4 = (Button) findViewById(R.id.n_pr4);

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
                Intent intent =new Intent(GameFastCalcul_Activity.this, GameFastCalcul_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameFastCalcul_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });





        question.setText(listeQuik.get(0).getQuestion());

        PR_btn1.setText(listeQuik.get(0).getPr1());
        PR_btn2.setText(listeQuik.get(0).getPr2());
        PR_btn3.setText(listeQuik.get(0).getPr3());
        PR_btn4.setText(listeQuik.get(0).getPr4());

        PR_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeQuik.get(compter-1).getResponse().equals(PR_btn1.getText().toString())  ){
                    PR_btn1.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn1.setTextColor(Color.BLACK);



                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());

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

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn1.setTextColor(Color.BLACK);



                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());
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

                if(listeQuik.get(compter-1).getResponse().equals(PR_btn2.getText().toString())  ){
                    PR_btn2.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn2.setTextColor(Color.BLACK);


                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());

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

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn2.setTextColor(Color.BLACK);


                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());
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

                if(listeQuik.get(compter-1).getResponse().equals(PR_btn3.getText().toString())  ){
                    PR_btn3.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn3.setTextColor(Color.BLACK);


                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());

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

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn3.setTextColor(Color.BLACK);



                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());
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

                if(listeQuik.get(compter-1).getResponse().equals(PR_btn4.getText().toString())  ){
                    PR_btn4.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn1.setBackgroundResource(android.R.drawable.btn_default);
                                PR_btn2.setBackgroundResource(android.R.drawable.btn_default);
                                PR_btn3.setBackgroundResource(android.R.drawable.btn_default);
                                PR_btn4.setBackgroundResource(android.R.drawable.btn_default);


                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn4.setTextColor(Color.BLACK);


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

                            if(compter == listeQuik.size()){
                                Intent intent =new Intent(GameFastCalcul_Activity.this, G_Evaluation_Activity.class);
                                intent.putExtra("evaluation", evaluation);
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
                                }


                                PR_btn4.setTextColor(Color.BLACK);



                                question.setText(listeQuik.get(compter).getQuestion());

                                PR_btn1.setText(listeQuik.get(compter).getPr1());
                                PR_btn2.setText(listeQuik.get(compter).getPr2());
                                PR_btn3.setText(listeQuik.get(compter).getPr3());
                                PR_btn4.setText(listeQuik.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

    }

    public void initialing(ArrayList<ModelQS> liste){

        liste.add(new ModelQS("1 x 1 + 2 = ?","3","2","3","4","5"));
        liste.add(new ModelQS("2 / 1 + 2 + 1 = ?","5","5","4","6","3"));
        liste.add(new ModelQS("5 - 2 x 2 - 1 = ?","0","3","1","0","4"));
        liste.add(new ModelQS("12 / 4 x 4 + 2 = ?","14","15","16","14","12"));
        liste.add(new ModelQS("4 x 6 / 2 + 8 = ?","20","16","18","14","20"));
        liste.add(new ModelQS("36 / 6 / 3 + 3 = ?","5","5","6","3","9"));
        liste.add(new ModelQS("24 x 2 / 2 - 24 = ?","0","24","1","0","2"));
        liste.add(new ModelQS("50 / 2 x 10 + 50 = ?","300","70","300","200","100"));
        liste.add(new ModelQS("112 x 2 / 4 + 44 = ?","100","102","104","112","100"));
        liste.add(new ModelQS("256 / 16 / 4 * 64 = ?","256","64","128","256","120"));

        
    }

}
