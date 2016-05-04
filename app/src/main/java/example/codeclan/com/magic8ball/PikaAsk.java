package example.codeclan.com.magic8ball;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 03/05/2016.
 */
public class PikaAsk extends AppCompatActivity {

        TextView mInitialText;
        EditText mQuestionInput;
        ImageView mFortuneImage;
        Button mFortuneButton;
        Button mChoicesButton;

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pika);

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


            mFortuneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Tester: ", "button click!");

                    Intent submitQuestion = new Intent(PikaAsk.this, PikaAnswer.class);

                    submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                    startActivity(submitQuestion);
                }
            });


            mChoicesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent submitQuestion = new Intent(PikaAsk.this, ChoicesList.class);

                    submitQuestion.putExtra("question", mQuestionInput.getText().toString().trim());
                    startActivity(submitQuestion);
                }

            });


        }
}

