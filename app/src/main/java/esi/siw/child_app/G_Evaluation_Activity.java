package esi.siw.child_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import esi.siw.child_app.tri_game.GameTri_Activity;

/**
 * Created by dell on 09/08/2018.
 */

public class G_Evaluation_Activity extends AppCompatActivity {

    int final_mark = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluation_layout);

        int evaluation = getIntent().getExtras().getInt("evaluation");

        TextView remarque = (TextView) findViewById(R.id.appreciation);
        TextView mark = (TextView) findViewById(R.id.mark);

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



        return_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(G_Evaluation_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        TextView big_mark = (TextView) findViewById(R.id.big_mark);
        big_mark.setText("10");

        mark.setText(String.valueOf(evaluation));

        if(evaluation == 10){
            remarque.setText("ممتاز");
        }else if (evaluation < 10 && evaluation > 7 ){
            remarque.setText("جيد جدا");
        }else if (evaluation < 7 && evaluation > 4 ){
            remarque.setText("متوسط");
        }else if (evaluation == 7) {
            remarque.setText("حسن");
        }else if (evaluation < 5) {
            remarque.setText("ضعيف");
        }



    }

}
