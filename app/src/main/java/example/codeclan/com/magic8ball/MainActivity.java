package example.codeclan.com.magic8ball;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 02/05/2016.
 */
public class MainActivity extends AppCompatActivity {

    TextView mInputQuestion;
    Button mEightBall;
    Button mAskChewie;
    Button mAskPika;
    Button mAskHomer;
    Button mAskPonies;
    Button mAskFamilyGuy;
    Button mAskGlados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choices);


        mInputQuestion = (TextView) findViewById(R.id.inputQuestion);
        mEightBall = (Button) findViewById(R.id.eightBall);
        mAskChewie = (Button) findViewById(R.id.askChewie);
        mAskPika = (Button) findViewById(R.id.askPika);
        mAskHomer = (Button) findViewById(R.id.askHomer);
        mAskPonies = (Button) findViewById(R.id.askPonies);
        mAskFamilyGuy = (Button) findViewById(R.id.askFamilyGuy);
        mAskGlados = (Button) findViewById(R.id.askGlados);



        mEightBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, EightBall.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskChewie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, WookieAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

    }

}