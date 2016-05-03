package example.codeclan.com.magic8ball;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 02/05/2016.
 */
public class MainAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;


    String responseList[] = {
            "It is certain",
            "Without a doubt",
            "Yes, definitely",
            "Most likely",
            "Yes",
            "I’m Hungry, Ask later",
            "Better not tell you now",
            "Don’t count on it",
            "Outlook not so good",
            "Very doubtful"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_answer);


        mAnswerText = (TextView) findViewById(R.id.answerText);
        mInputQuestion = (TextView) findViewById(R.id.inputQuestion);
        mAnswerImage = (ImageView) findViewById(R.id.answerImage);
        mResponseText = (TextView) findViewById(R.id.responseText);
        mActualResponse = (TextView) findViewById(R.id.actualResponse);

        String question = this.getIntent().getExtras().getString("question");
        if (question.isEmpty()) {
            MediaPlayer mp = MediaPlayer.create(this, R.raw.sad_trombone);
            mp.start();

        } else {
            int index = new Random().nextInt(responseList.length);
            mInputQuestion.setText(question);
            mActualResponse.setText(responseList[index]);

            MediaPlayer mp = MediaPlayer.create(this, R.raw.eight_ball);
            mp.start();
        }

    }

}


