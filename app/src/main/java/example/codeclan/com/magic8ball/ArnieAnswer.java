package example.codeclan.com.magic8ball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 03/05/2016.
 */
public class ArnieAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Affirmative",
            "Correct",
            "Yesss!",
            "Yes",
            "I don't know",
            "I'm not interested in that",
            "Don’t be ridiculous",
            "One of us is in deep trouble"
    };

    int audioList[] = {
            R.raw.arnie_affirmative_0,
            R.raw.arnie_correct_1,
            R.raw.arnie_yesssss_2,
            R.raw.arnie_yes_3,
            R.raw.arnie_dont_know_4,
            R.raw.arnie_not_interested_5,
            R.raw.arnie_ridiculous_6,
            R.raw.arnie_deep_trouble_7

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arnie_answer);


        mAnswerText = (TextView) findViewById(R.id.answerText);
        mInputQuestion = (TextView) findViewById(R.id.inputQuestion);
        mAnswerImage = (ImageView) findViewById(R.id.answerImage);
        mResponseText = (TextView) findViewById(R.id.responseText);
        mActualResponse = (TextView) findViewById(R.id.actualResponse);
        mChoicesButton = (Button) findViewById(R.id.choicesButton);


        String question = this.getIntent().getExtras().getString("question");
        String mainQuestion = getString(R.string.main_page_ask);
        String noQuestion = getString(R.string.no_question);

        if (question.isEmpty() || question.equals(mainQuestion) || question.equals(noQuestion)) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.arnie_break_spine);
            mp.start();

        } else {
            int index = new Random().nextInt(responseList.length);
            mInputQuestion.setText(question);
            mActualResponse.setText(responseList[index]);
            MediaPlayer mp = MediaPlayer.create(this, audioList[index]);
            mp.start();
        }


        mChoicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitQuestion = new Intent(ArnieAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }

        });


    }
}