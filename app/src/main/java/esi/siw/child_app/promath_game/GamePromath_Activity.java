package esi.siw.child_app.promath_game;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import esi.siw.child_app.GC_Evaluation_Activity;
import esi.siw.child_app.G_Evaluation_Activity;
import esi.siw.child_app.MainActivity;
import esi.siw.child_app.R;
import esi.siw.child_app.culture_game.ModelQS;
import esi.siw.child_app.fastcalcul_game.GameFastCalcul_Activity;
import esi.siw.child_app.tri_game.GameTri_Activity;


/**
 * Created by dell on 10/08/2018.
 */

public class GamePromath_Activity extends AppCompatActivity  {


    ArrayList<ModelQS> listePro = new ArrayList<>();
    int compter = 0;
    int evaluation = 0;

    String score = "score";

    String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_mathprobleme);

        initialing(listePro);

        final MediaPlayer click_sound = MediaPlayer.create(this,R.raw.click_sound1);
        final MediaPlayer drop_sound = MediaPlayer.create(this,R.raw.click_sound2);
        final MediaPlayer success_sound = MediaPlayer.create(this,R.raw.right_sound);
        final MediaPlayer fail_sound = MediaPlayer.create(this,R.raw.wrong_sound);


        final TextView question = (TextView) findViewById(R.id.question_view);

        final Button PR_chk1 = (Button) findViewById(R.id.r_pr1);
        final Button PR_chk2 = (Button) findViewById(R.id.r_pr2);
        final Button PR_chk3 = (Button) findViewById(R.id.r_pr3);
        final Button PR_chk4 = (Button) findViewById(R.id.r_pr4);

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
                Intent intent =new Intent(GamePromath_Activity.this, GamePromath_Activity.class);
                startActivity(intent);
            }
        });

        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(GamePromath_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        question.setText(listePro.get(0).getQuestion());

        PR_chk1.setText(listePro.get(0).getPr1());
        PR_chk2.setText(listePro.get(0).getPr2());
        PR_chk3.setText(listePro.get(0).getPr3());
        PR_chk4.setText(listePro.get(0).getPr4());


        PR_chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listePro.get(compter-1).getResponse().equals(PR_chk1.getText().toString())  ){

                    PR_chk1.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk1.setTextColor(Color.BLACK);

                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());


                            }
                            
                        }
                    }, 1000);

                }else{
                    PR_chk1.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk1.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

        PR_chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listePro.get(compter-1).getResponse().equals(PR_chk2.getText().toString())  ){

                    PR_chk2.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk2.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());


                            }

                        }
                    }, 1000);

                }else{
                    PR_chk2.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk2.setTextColor(Color.BLACK);

                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });


        PR_chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listePro.get(compter-1).getResponse().equals(PR_chk3.getText().toString())  ){

                    PR_chk3.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk3.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());


                            }

                        }
                    }, 1000);

                }else{
                    PR_chk3.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk3.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

        PR_chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click_sound.start();
                compter = compter + 1;
                score = score + String.valueOf(compter);

                if(listePro.get(compter-1).getResponse().equals(PR_chk4.getText().toString())  ){

                    PR_chk4.setTextColor(Color.parseColor("#7FFF00"));
                    success_sound.start();
                    evaluation = evaluation + 1;

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk4.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());


                            }

                        }
                    }, 1000);

                }else{
                    PR_chk4.setTextColor(Color.parseColor("#FF0000"));
                    fail_sound.start();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 1s = 1000ms

                            if(compter == listePro.size()){
                                Intent intent =new Intent(GamePromath_Activity.this, G_Evaluation_Activity.class);
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


                                question.setText(listePro.get(compter).getQuestion());

                                PR_chk4.setTextColor(Color.BLACK);


                                PR_chk1.setText(listePro.get(compter).getPr1());
                                PR_chk2.setText(listePro.get(compter).getPr2());
                                PR_chk3.setText(listePro.get(compter).getPr3());
                                PR_chk4.setText(listePro.get(compter).getPr4());
                            }



                        }
                    }, 1000);
                }

            }
        });

    }

    public void initialing(ArrayList<ModelQS> liste){

        liste.add(new ModelQS("اشترك ثلاث أصدقاء في شراء بضاعة قيمتها 200دج, دفع الأول 80دج والثاني 50دج. كم سيدفع الثالث ؟","70 دج","80 دج","70 دج","60 دج","90 دج"));
        liste.add(new ModelQS("مربع طول أحد أضلاعه 10سم. ما هو المحيط ؟","40 سم","40 سم","50 سم","60 سم","20 سم"));
        liste.add(new ModelQS("مربع محيطه 80سم. ماهو طول أحد أضلاعه ؟","20 سم","40 سم","30 سم","20 سم","8 سم"));
        liste.add(new ModelQS("حقل على شكل مستطيل. طوله 25م و عرضه 10م, ماهي مساحة الحقل ؟","250 م²","250 دم²","2500 سم²","2500 هم²","250 م²"));
        liste.add(new ModelQS("يشتري محمد مجلة شهرية قيمتها 35دج. كم يدفع محمد في السنة ؟","420 دج","420 دج","320 دج","220 دج","120 دج"));
        liste.add(new ModelQS("اشترى أحمد 15كغ بطاطا بثمن 900دج. كم ثمن الكيلوغرام الواحد ؟","75 دج","85 دج","75 دج","65 دج","95 دج"));
        liste.add(new ModelQS("يريد مزارع تسييج حديقة مستطيلة طولها 50م و عرضها 200دم, كم كلفة السياج بعلم أن ثمن المتر الواحد هو 50دج ؟","7000 دج","8000 دج","8500 دج","7000 دج","7500 دج"));
        liste.add(new ModelQS("ما هو العدد الذي رقم آلافه 8 ورقم آحاده نصف رقم آلافه و رقم عشراته ربع رقم آحاده و رقم مئاته ضعف رقم عشراته ؟","8214","8124","8241","8412","8214"));
        liste.add(new ModelQS("سيارة قطعت مسافة 180كم في ظرف ساعة و 30د. ماهي السرعة المتوسطة ؟","120 كم/سا","120 كم/سا","90 كم/سا","60 كم/سا","100 كم/سا"));
        liste.add(new ModelQS("محمد معه 1000دج اشترى محفظة ب 350دج و 6 كراريس و تصدق ب 100دج بقي له 250دج.كم هو ثمن الكراس الواحد ؟","50 دج","40 دج","50 دج","60 دج","35 دج"));

    }

}
