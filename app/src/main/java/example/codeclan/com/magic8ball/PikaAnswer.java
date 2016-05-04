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
public class PikaAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Pika! - It is certain",
            "Pi-Ka! - Without a doubt",
            "Pika, Pi-Ka! - Yes, definitely",
            "Piii-ka - I don't know!",
            "Pii-kaa! - Better not tell you now",
            "Piiiika - Outlook not so good",
            "Piiii-ka - Very doubtful"
    };

    int audioList[] = {
            R.raw.pika_yes_0,
            R.raw.pika_enthusiastic_1,
            R.raw.pika_definetly_2,
            R.raw.pika_dont_know_3,
            R.raw.pika_questionmark_4,
            R.raw.pika_sad_5,
            R.raw.pika_also_sad_6
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pika_answer);




        mAnswerText = (TextView) findViewById(R.id.answerText);
        mInputQuestion = (TextView) findViewById(R.id.inputQuestion);
        mAnswerImage = (ImageView) findViewById(R.id.answerImage);
        mResponseText = (TextView) findViewById(R.id.responseText);
        mActualResponse = (TextView) findViewById(R.id.actualResponse);
        mChoicesButton = (Button) findViewById(R.id.choicesButton);

        String question = this.getIntent().getExtras().getString("question");
        if(question.isEmpty()){
            mActualResponse.setText(R.string.wookie_default_answer);
            MediaPlayer mp = MediaPlayer.create(this, R.raw.wookie_idiot);
            mp.start();
        }else {
            int index = new Random().nextInt(responseList.length);
            mInputQuestion.setText(question);
            mActualResponse.setText(responseList[index]);
            MediaPlayer mp = MediaPlayer.create(this, audioList[index]);
            mp.start();
        }

        mChoicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submitQuestion = new Intent(PikaAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }
        });



    }

}
