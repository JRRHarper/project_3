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
 * Created by user on 02/05/2016.
 */
public class FryAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Uh... yeah",
            "Yeah!",
            "Yes, no, yes, yes! yes!!",
            "You're right!",
            "Close enough",
            "Ohhh, I don't know",
            "Hey hey, Gimme a break!",
            "How is that possible?",
            "No Way!",
            "no, yeah, no, yeah, no, wait no yeah Yeah!... No... no"
    };

    int audioList[] = {
            R.raw.fry_uh_yeah_0,
            R.raw.fry_yeah_1,
            R.raw.fry_yes_no_yes_2,
            R.raw.fry_youre_right_3,
            R.raw.fry_close_enough_4,
            R.raw.fry_dont_know_5,
            R.raw.fry_gimme_break_6,
            R.raw.fry_how_possible_7,
            R.raw.fry_no_way_8,
            R.raw.fry_yeah_no_no_9


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fry_answer);


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
            MediaPlayer mp = MediaPlayer.create(this, R.raw.fry_your_stupid_no_q);
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
                Intent submitQuestion = new Intent(FryAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }

        });


    }
}