package example.codeclan.com.magic8ball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 02/05/2016.
 */
public class MainActivity extends AppCompatActivity {


    TextView mInitialText;
    EditText mQuestionInput;
    ImageView mFortuneImage;
    Button mFortuneButton;
    Button mAlternateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInitialText = (TextView) findViewById(R.id.initialText);
        mQuestionInput = (EditText) findViewById(R.id.descriptionText);
        mFortuneImage = (ImageView) findViewById(R.id.fortuneImage);
        mFortuneButton = (Button) findViewById(R.id.fortuneButton);
        mAlternateButton = (Button) findViewById(R.id.alternateButton);


        mFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(MainActivity.this, MainAnswer.class);

                submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });
        mAlternateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitQuestion = new Intent(MainActivity.this, Choices.class);

                submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                startActivity(submitQuestion);

            }
        });

    }
}


