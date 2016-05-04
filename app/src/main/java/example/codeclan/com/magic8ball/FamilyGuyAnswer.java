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
public class FamilyGuyAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Yeah!",
            "Yeahhhh!",
            "Yeah, that sounds good",
            "It was my understand that there would be no questions asked!!",
            "I don't care!!",
            "I'm sorry, what was that?",
            "No no no, I don't think so!",
            "Close, but still no",
            "You ask a lot of questions, dontcha!"
    };

    int audioList[] = {
            R.raw.peter_yeah_0,
            R.raw.peter_yeahhhh_1,
            R.raw.peter_sounds_good_2,
            R.raw.peter_no_questions_3,
            R.raw.peter_dont_care_4,
            R.raw.peter_dont_know_5,
            R.raw.peter_dont_think_so_6,
            R.raw.peter_close_but_no_7,
            R.raw.peter_ask_alot_q_8

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.familyguy_answer);


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
            MediaPlayer mp = MediaPlayer.create(this, R.raw.peter_angry_no_q);
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
                Intent submitQuestion = new Intent(FamilyGuyAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }

        });


    }
}