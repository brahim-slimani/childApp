package esi.siw.child_app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import esi.siw.child_app.addition_game.GameAdd_Activity;
import esi.siw.child_app.color_game.GameColor_Activity;
import esi.siw.child_app.comparison_game.GameComparison_Activity;
import esi.siw.child_app.culture_game.GameCulture_Activity;
import esi.siw.child_app.fastcalcul_game.GameFastCalcul_Activity;
import esi.siw.child_app.game_word.GameWord_Activity;
import esi.siw.child_app.promath_game.GamePromath_Activity;
import esi.siw.child_app.tri_game.GameTri_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CardView GameWord = (CardView) findViewById(R.id.game_word);
        final CardView GameAddition = (CardView) findViewById(R.id.game_addition);
        final CardView GameCulture = (CardView) findViewById(R.id.game_culture);
        final CardView GameCmp = (CardView) findViewById(R.id.game_cmp);
        final CardView GameFastCalcul = (CardView) findViewById(R.id.game_fastcalucl);
        final CardView GameProMath = (CardView) findViewById(R.id.game_promath);
        final CardView GameColor = (CardView) findViewById(R.id.game_color);
        final CardView GameTri = (CardView) findViewById(R.id.game_tri);



        GameWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameWord_Activity.class);
                startActivity(intent);
            }
        });

        GameAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameAdd_Activity.class);
                startActivity(intent);
            }
        });

        GameCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameCulture_Activity.class);
                startActivity(intent);
            }
        });

        GameCmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameComparison_Activity.class);
                startActivity(intent);
            }
        });

        GameFastCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameFastCalcul_Activity.class);
                startActivity(intent);
            }
        });

        GameProMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GamePromath_Activity.class);
                startActivity(intent);
            }
        });

        GameColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameColor_Activity.class);
                startActivity(intent);
            }
        });

        GameTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GameTri_Activity.class);
                startActivity(intent);
            }
        });


    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_exit:

                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);

        }
        switch (item.getItemId()) {

            case R.id.action_help:
                final Dialog dialog2 = new Dialog(this);
                dialog2.setContentView(R.layout.help_dialogue);
                dialog2.setTitle("حول التطبيق");
                Button btnHelp = (Button) dialog2.findViewById(R.id.btn_help);

                dialog2.show();
                btnHelp.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });

            default: return super.onOptionsItemSelected(item);
        }

    }
}
