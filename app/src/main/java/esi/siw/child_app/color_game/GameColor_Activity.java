package esi.siw.child_app.color_game;

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
import esi.siw.child_app.addition_game.Model;
import esi.siw.child_app.comparison_game.GameComparison_Activity;


/**
 * Created by dell on 10/08/2018.
 */

public class GameColor_Activity extends AppCompatActivity  {


    ArrayList<ModelCR> listeColors = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;

    String score = "score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_colors);

        initialing(listeColors);


        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);


        final TextView context = (TextView) findViewById(R.id.context);
        final TextView colorText = (TextView) findViewById(R.id.proposition);

        final Button PR_btn1 = (Button) findViewById(R.id.n_pr1);
        final Button PR_btn2 = (Button) findViewById(R.id.n_pr2);

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
                Intent intent =new Intent(GameColor_Activity.this, GameColor_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GameColor_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });



        context.setText(String.valueOf(listeColors.get(0).getContext()));
        colorText.setText(String.valueOf(listeColors.get(0).getText()));
        colorText.setTextColor(Color.parseColor(listeColors.get(0).getColor()));
        PR_btn1.setText(String.valueOf(listeColors.get(0).getPr1()));
        PR_btn2.setText(String.valueOf(listeColors.get(0).getPr2()));

        PR_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listeColors.get(compter-1).getResponse().equals(PR_btn1.getText())){
                    PR_btn1.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                             // Do something after 1s = 1000ms

                            if(compter == listeColors.size()){
                                Intent intent =new Intent(GameColor_Activity.this, G_Evaluation_Activity.class);
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
                                PR_btn2.setTextColor(Color.BLACK);

                                context.setText(listeColors.get(compter).getContext());
                                colorText.setText(listeColors.get(compter).getText());
                                colorText.setTextColor(Color.parseColor(listeColors.get(compter).getColor()));
                                PR_btn1.setText(String.valueOf(listeColors.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeColors.get(compter).getPr2()));


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

                            if(compter == listeColors.size()){
                                Intent intent =new Intent(GameColor_Activity.this, G_Evaluation_Activity.class);
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
                                PR_btn2.setTextColor(Color.BLACK);

                                context.setText(listeColors.get(compter).getContext());
                                colorText.setText(listeColors.get(compter).getText());
                                colorText.setTextColor(Color.parseColor(listeColors.get(compter).getColor()));
                                PR_btn1.setText(String.valueOf(listeColors.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeColors.get(compter).getPr2()));

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

                if(listeColors.get(compter-1).getResponse().equals(PR_btn2.getText())){
                    PR_btn2.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listeColors.size()){
                                Intent intent =new Intent(GameColor_Activity.this, G_Evaluation_Activity.class);
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
                                PR_btn2.setTextColor(Color.BLACK);

                                context.setText(listeColors.get(compter).getContext());
                                colorText.setText(listeColors.get(compter).getText());
                                colorText.setTextColor(Color.parseColor(listeColors.get(compter).getColor()));
                                PR_btn1.setText(String.valueOf(listeColors.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeColors.get(compter).getPr2()));


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

                            if(compter == listeColors.size()){
                                Intent intent =new Intent(GameColor_Activity.this, G_Evaluation_Activity.class);
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
                                PR_btn2.setTextColor(Color.BLACK);

                                context.setText(listeColors.get(compter).getContext());
                                colorText.setText(listeColors.get(compter).getText());
                                colorText.setTextColor(Color.parseColor(listeColors.get(compter).getColor()));
                                PR_btn1.setText(String.valueOf(listeColors.get(compter).getPr1()));
                                PR_btn2.setText(String.valueOf(listeColors.get(compter).getPr2()));

                            }

                        }
                    }, 1000);
                }

            }
        });




    }

    public void initialing(ArrayList<ModelCR> liste){

        liste.add(new ModelCR("اللون","أخضر","#9400D3","بنفسجي","بنفسجي","أخضر"));
        liste.add(new ModelCR("الخط","أزرق","#FF0000","أزرق","أحمر","أزرق"));
        liste.add(new ModelCR("الخط","برتقالي","#FFFF00","برتقالي","برتقالي","أصفر"));
        liste.add(new ModelCR("اللون","أزرق","#00FF7F","أخضر","أزرق","أخضر"));
        liste.add(new ModelCR("الخط","أبيض","#000000","أبيض","أسود","أبيض"));
        liste.add(new ModelCR("الخط","بنفسجي","#00FF7F","بنفسجي","بنفسجي","أخضر"));
        liste.add(new ModelCR("اللون","أزرق","#FFA500","برتقالي","أزرق","برتقالي"));
        liste.add(new ModelCR("اللون","أحمر","#FFFF00","أصفر","أصفر","أحمر"));
        liste.add(new ModelCR("الخط","برتقالي","#FF00FF","برتقالي","برتقالي","وردي"));
        liste.add(new ModelCR("اللون","رمادي","#000000","أسود","رمادي","أسود"));

    }

}

