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
public class HomerAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Yes sir!",
            "Yes Master! *sarc*",
            "Yeah!",
            "Oh! Sure!!",
            "Will you shut up and quit bugging me!!!!",
            "I don't know",
            "No!!!",
            "If i said no the first time, what makes you think i'll say yes the second time!?"
    };

    int audioList[] = {
            R.raw.homer_yes_sir_0,
            R.raw.homer_yes_master_sarc_1,
            R.raw.homer_yeah_2,
            R.raw.homer_oh_sure_3,
            R.raw.homer_quit_bugging_4,
            R.raw.homer_dont_know_5,
            R.raw.homer_no_6,
            R.raw.homer_no_sarc_7
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homer_answer);


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
            MediaPlayer mp = MediaPlayer.create(this, R.raw.homer_no_q);
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
                Intent submitQuestion = new Intent(HomerAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }

        });


    }
}