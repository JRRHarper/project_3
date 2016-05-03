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
            "Argh rugh-rugh - It is certain",
            "aargh-arghoo - Without a doubt",
            "Rwaah-oh-oh - Yes, definitely",
            "Ahhhgh! - Most likely",
            "whew! - Yes",
            "Rrrooaarrgghh! I’m Hungry, Ask later",
            "Wah! snort-snort-snort - Better not tell you now",
            "Arrrghh! - Don’t count on it",
            "Woh arg-oh-oh - Outlook not so good",
            "Rgrah rha - Very doubtful"
    };

    int audioList[] = {
            R.raw.wookie_certain_0,
            R.raw.wookie_without_doubt_1,
            R.raw.wookie_definitely_2,
            R.raw.wookie_likely_3,
            R.raw.wookie_yes_4,
            R.raw.wookie_hungry_5,
            R.raw.wookie_later_6,
            R.raw.wookie_dont_count_7,
            R.raw.wookie_not_good_8,
            R.raw.wookie_doubtful_9

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wookie_answer);




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
