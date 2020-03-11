package esi.siw.child_app.addition_game;

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
import esi.siw.child_app.color_game.GameColor_Activity;


/**
 * Created by dell on 10/08/2018.
 */

public class GameAdd_Activity extends AppCompatActivity  {

    int result = 0;

    ArrayList<Model> listeAddition = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;

    String score = "score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_add);

        initialing(listeAddition);


        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);


        final TextView first_one = (TextView) findViewById(R.id.first_number);
        final TextView second_one = (TextView) findViewById(R.id.second_number);
        final TextView operator = (TextView) findViewById(R.id.operator);


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
                Intent intent =new Intent(GameAdd_Activity.this, GameAdd_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameAdd_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        first_one.setText(String.valueOf(listeAddition.get(0).getFirst_number()));
        second_one.setText(String.valueOf(listeAddition.get(0).getSecond_number()));
        operator.setText(String.valueOf(listeAddition.get(0).getOperator()));
        PR_btn1.setText(String.valueOf(listeAddition.get(0).getPr1()));
        PR_btn2.setText(String.valueOf(listeAddition.get(0).getPr2()));
        PR_btn3.setText(String.valueOf(listeAddition.get(0).getPr3()));
        PR_btn4.setText(String.valueOf(listeAddition.get(0).getPr4()));

        PR_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(operator.getText().toString().equals("+")){
                    result = Integer.parseInt(first_one.getText().toString()) + Integer.parseInt(second_one.getText().toString()) ;
                }else if (operator.getText().toString().equals("-")){
                    result = Integer.parseInt(first_one.getText().toString()) - Integer.parseInt(second_one.getText().toString()) ;
                }

                if(result == Integer.parseInt(PR_btn1.getText().toString())){
                    PR_btn1.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             // Do something after 1s = 1000ms

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));

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

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));
                            }



                        }
                    }, 1000);
                }

            }
        });

        /**********************************************************/

        PR_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(operator.getText().toString().equals("+")){
                    result = Integer.parseInt(first_one.getText().toString()) + Integer.parseInt(second_one.getText().toString()) ;
                }else if (operator.getText().toString().equals("-")){
                    result = Integer.parseInt(first_one.getText().toString()) - Integer.parseInt(second_one.getText().toString()) ;
                }

                if(result == Integer.parseInt(PR_btn2.getText().toString())){
                    PR_btn2.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             // Do something after 1s = 1000ms

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));

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

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));
                            }



                        }
                    }, 1000);
                }

            }
        });


        /**********************************************************/

        PR_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(operator.getText().toString().equals("+")){
                    result = Integer.parseInt(first_one.getText().toString()) + Integer.parseInt(second_one.getText().toString()) ;
                }else if (operator.getText().toString().equals("-")){
                    result = Integer.parseInt(first_one.getText().toString()) - Integer.parseInt(second_one.getText().toString()) ;
                }

                if(result == Integer.parseInt(PR_btn3.getText().toString())){
                    PR_btn3.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             // Do something after 1s = 1000ms

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));

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

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));
                            }



                        }
                    }, 1000);
                }

            }
        });


        /**********************************************************/

        PR_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(operator.getText().toString().equals("+")){
                    result = Integer.parseInt(first_one.getText().toString()) + Integer.parseInt(second_one.getText().toString()) ;
                }else if (operator.getText().toString().equals("-")){
                    result = Integer.parseInt(first_one.getText().toString()) - Integer.parseInt(second_one.getText().toString()) ;
                }

                if(result == Integer.parseInt(PR_btn4.getText().toString())){
                    PR_btn4.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             // Do something after 1s = 1000ms

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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

                                PR_btn4.setTextColor(Color.BLACK);

                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));

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

                            if(compter == listeAddition.size()){
                                Intent intent =new Intent(GameAdd_Activity.this, G_Evaluation_Activity.class);
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


                                first_one.setText(String.valueOf(listeAddition.get(compter).getFirst_number()));
                                second_one.setText(String.valueOf(listeAddition.get(compter).getSecond_number()));
                                operator.setText(String.valueOf(listeAddition.get(compter).getOperator()));
                                PR_btn1.setText(String.valueOf(listeAddition.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeAddition.get(compter).getPr2()));
                                PR_btn3.setText(String.valueOf(listeAddition.get(compter).getPr3()));
                                PR_btn4.setText(String.valueOf(listeAddition.get(compter).getPr4()));
                            }



                        }
                    }, 1000);
                }

            }
        });



    }

    public void initialing(ArrayList<Model> liste){

        liste.add(new Model(15,5,"+",30,25,10,20));
        liste.add(new Model(19,9,"+",25,28,30,27));
        liste.add(new Model(33,22,"+",57,55,50,45));

        liste.add(new Model(56,11,"-",77,67,45,65));
        liste.add(new Model(82,17,"-",75,65,76,73));
        liste.add(new Model(45,29,"-",17,18,16,26));

        liste.add(new Model(115,85,"+",205,190,200,210));
        liste.add(new Model(76,38,"+",157,124,116,114));


        liste.add(new Model(112,45,"-",67,77,63,73));
        liste.add(new Model(165,75,"-",85,90,95,105));



    }

}
