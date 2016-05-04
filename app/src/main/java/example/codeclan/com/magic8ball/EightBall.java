package example.codeclan.com.magic8ball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by user on 02/05/2016.
 */
public class EightBall extends AppCompatActivity {


    TextView mInitialText;
    EditText mQuestionInput;
    ImageView mFortuneImage;
    Button mFortuneButton;
    Button mChoicesButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eight_ball);
        String question = this.getIntent().getExtras().getString("question");
        String mainQuestion = getString(R.string.main_page_ask);
        String noQuestion = getString(R.string.no_question);


        mInitialText = (TextView) findViewById(R.id.initialText);
        mQuestionInput = (EditText) findViewById(R.id.descriptionText);
        mFortuneImage = (ImageView) findViewById(R.id.fortuneImage);
        mFortuneButton = (Button) findViewById(R.id.fortuneButton);
        mChoicesButton = (Button) findViewById(R.id.choicesButton);

        if (question.isEmpty() || question.equals(mainQuestion) || question.equals(noQuestion)) {
            mQuestionInput.setText(" ");

        } else {
            Log.d("MainText: ", mainQuestion);
            mQuestionInput.setText(question);

        }
        //onkeylistener will wait for a certain key to be pressed and return true/false after each key.
        mQuestionInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //action_down = button being pressed down. keycode_enter is for the enter key.
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Performs this action on enter key press
                    Intent submitQuestion = new Intent(EightBall.this, EightBallAnswer.class);

                    submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                    startActivity(submitQuestion);
                    return true;
                } else {
                    //else it returns false.
                    return false;
                }
            }
        });


        mFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tester: ", "button click!");

                Intent submitQuestion = new Intent(EightBall.this, EightBallAnswer.class);

                submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });


        mChoicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitQuestion = new Intent(EightBall.this, ChoicesList.class);

                submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                startActivity(submitQuestion);

            }
        });
    }
}


