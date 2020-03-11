package esi.siw.child_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dell on 09/08/2018.
 */

public class GC_Evaluation_Activity extends AppCompatActivity {

    int final_mark = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluation_layout);

        int evaluation_cu = getIntent().getExtras().getInt("evaluation_c");

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
                Intent intent =new Intent(GC_Evaluation_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView big_mark = (TextView) findViewById(R.id.big_mark);
        big_mark.setText("20");

        mark.setText(String.valueOf(evaluation_cu));

        if(evaluation_cu == 20 && evaluation_cu > 17 ){
            remarque.setText("ممتاز");
        }else if (evaluation_cu < 18 && evaluation_cu > 14 ){
            remarque.setText("جيد جدا");
        }else if (evaluation_cu < 15 && evaluation_cu > 12 ){
            remarque.setText("حسن");
        }else if (evaluation_cu < 12 && evaluation_cu > 8) {
            remarque.setText("متوسط");
        }else if (evaluation_cu < 8) {
            remarque.setText("ضعيف");
        }






    }

}
