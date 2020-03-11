package esi.siw.child_app.tri_game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
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

public class GameTri_Activity extends AppCompatActivity  {


    ArrayList<ModelTri> listeTri = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;


    String score = "score";

    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_suite);

        initialing(listeTri);

        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);

        final TextView question = (TextView) findViewById(R.id.modeTri);

        final TextView response = (TextView) findViewById(R.id.response);

        final Button PR1 = (Button) findViewById(R.id.p1);
        final Button PR2 = (Button) findViewById(R.id.p2);
        final Button PR3 = (Button) findViewById(R.id.p3);
        final Button PR4 = (Button) findViewById(R.id.p4);
        final Button PR5 = (Button) findViewById(R.id.p5);
        final Button PR6 = (Button) findViewById(R.id.p6);

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
                Intent intent =new Intent(GameTri_Activity.this, GameTri_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameTri_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        question.setText(listeTri.get(0).getMode());

        PR1.setText(listeTri.get(0).getFirst());
        PR2.setText(listeTri.get(0).getSecond());
        PR3.setText(listeTri.get(0).getThird());
        PR4.setText(listeTri.get(0).getFourth());
        PR5.setText(listeTri.get(0).getFifth());
        PR6.setText(listeTri.get(0).getLast());



        PR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR1.setEnabled(false);

                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR1.getText().toString()+", ");
                }else {
                    if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                        response.setText(response.getText().toString()+PR1.getText());
                    }else{
                        response.setText(response.getText().toString()+PR1.getText()+", ");
                    }                }

                if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });

        /***********************************************************************/

        PR2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR2.setEnabled(false);

                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR2.getText().toString()+", ");
                }else {
                    if(!PR1.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                        response.setText(response.getText().toString()+PR2.getText());
                    }else{
                        response.setText(response.getText().toString()+PR2.getText()+", ");
                    }                }

                if(!PR1.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });

        /**************************************************/
        PR3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR3.setEnabled(false);

                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR3.getText().toString()+", ");
                }else {
                    if(!PR1.isEnabled() && !PR2.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                        response.setText(response.getText().toString()+PR3.getText());
                    }else{
                        response.setText(response.getText().toString()+PR3.getText()+", ");
                    }                }

                if(!PR1.isEnabled() && !PR2.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });

        /***********************************************************/
        PR4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR4.setEnabled(false);

                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR4.getText().toString()+", ");
                }else {
                    if(!PR2.isEnabled() && !PR3.isEnabled() && !PR1.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                        response.setText(response.getText().toString()+PR4.getText());
                    }else{
                        response.setText(response.getText().toString()+PR4.getText()+", ");
                    }                }

                if(!PR2.isEnabled() && !PR3.isEnabled() && !PR1.isEnabled() && !PR5.isEnabled() && !PR6.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });

        /******************************************************/
        PR5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR5.setEnabled(false);

                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR5.getText().toString()+", ");
                }else {
                    if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR1.isEnabled() && !PR6.isEnabled()){
                        response.setText(response.getText().toString()+PR5.getText());
                    }else{
                        response.setText(response.getText().toString()+PR5.getText()+", ");
                    }                }

                if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR1.isEnabled() && !PR6.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });
        /*****************************************************************/
        PR6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click_sound.start();
                PR6.setEnabled(false);


                if(response.getText().toString().equals("                                 ")){
                    response.setText(PR6.getText().toString()+", ");
                }else {
                    if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR1.isEnabled()){
                        response.setText(response.getText().toString()+PR6.getText());
                    }else{
                        response.setText(response.getText().toString()+PR6.getText()+", ");
                    }

                }

                if(!PR2.isEnabled() && !PR3.isEnabled() && !PR4.isEnabled() && !PR5.isEnabled() && !PR1.isEnabled()){
                    if(response.getText().toString().equals(listeTri.get(compter).getResponse())){
                        success_sound.start();
                        evaluation = evaluation + 1;
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#7FFF00"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());

                                }

                            }
                        }, 1000);
                    }else{
                        fail_sound.start();
                        compter = compter + 1;
                        response.setBackgroundColor(Color.parseColor("#FF0000"));

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Do something after 1s = 1000ms
                                if(compter == listeTri.size()){
                                    Intent intent =new Intent(GameTri_Activity.this, G_Evaluation_Activity.class);
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

                                    question.setText(listeTri.get(compter).getMode());
                                    response.setBackgroundColor(Color.TRANSPARENT);
                                    response.setText("                                 ");

                                    PR1.setEnabled(true);
                                    PR2.setEnabled(true);
                                    PR3.setEnabled(true);
                                    PR4.setEnabled(true);
                                    PR5.setEnabled(true);
                                    PR6.setEnabled(true);

                                    PR1.setText(listeTri.get(compter).getFirst());
                                    PR2.setText(listeTri.get(compter).getSecond());
                                    PR3.setText(listeTri.get(compter).getThird());
                                    PR4.setText(listeTri.get(compter).getFourth());
                                    PR5.setText(listeTri.get(compter).getFifth());
                                    PR6.setText(listeTri.get(compter).getLast());
                                }



                            }
                        }, 1000);
                    }
                }


            }
        });


    }

    public void initialing(ArrayList<ModelTri> liste){
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","5","3","9","7","2","4","2, 3, 4, 5, 7, 9"));
        listeTri.add(new ModelTri("من الأكبر الى الأصغر","19","14","41","35","53","91","91, 53, 41, 35, 19, 14"));
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","21","52","23","12","13","25","12, 13, 21, 23, 25, 52"));
        listeTri.add(new ModelTri("من الأكبر الى الأصغر","89","76","98","13","67","31","98, 89, 76, 67, 31, 13" ));
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","312","213","432","324","214","132","132, 213, 214, 312, 324, 432"));
        listeTri.add(new ModelTri("من الأكبر الى الأصغر","102","190","120","109","192","912","912, 192, 190, 120, 109, 102"));
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","458","623","584","854","645","632","458, 584, 623, 632, 645, 854"));
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","1235","1253","1352","1325","1532","1523","1235, 1253, 1325, 1352, 1523, 1532"));
        listeTri.add(new ModelTri("من الأكبر الى الأصغر","5326","5356","5236","5362","5263","5365","5365, 5362, 5356, 5326, 5263, 5236"));
        listeTri.add(new ModelTri("من الأصغر الى الأكبر","9898","9988","9998","9899","9889","9989","9889, 9898, 9899, 9988, 9989, 9998"));


    }

}
