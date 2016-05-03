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
    Button mAskFry;
    Button mAskArnie;


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
        mAskFry = (Button) findViewById(R.id.askFry);
        mAskArnie = (Button) findViewById(R.id.askArnie);


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


        mAskPika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, PikaAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskHomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, HomerAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskPonies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, PoniesAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskFamilyGuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, FamilyGuyAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskFry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, FryAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });

        mAskArnie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, ArnieAsk.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });
    }

}