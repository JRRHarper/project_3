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
public class PoniesAnswer extends AppCompatActivity {

    TextView mAnswerText;
    TextView mInputQuestion;
    ImageView mAnswerImage;
    TextView mResponseText;
    TextView mActualResponse;
    Button mChoicesButton;


    String responseList[] = {
            "Yes, It's all true",
            "Yes Yes Yes Yes Yes Yes Yes Yes....",
            "E-Yup",
            "Of course!",
            "Well, Duh",
            "I don't know about you, But i can't make important decisions on an empty stomach",
            "Are you loco in the coco?!",
            "That's so not true!!"
    };

    int audioList[] = {
            R.raw.ponies_yes_all_true_rd_0,
            R.raw.ponies_yes_yes_pp_1,
            R.raw.ponies_eyup_bigmac_2,
            R.raw.ponies_of_course_ts_3,
            R.raw.ponies_well_duh_pp_4,
            R.raw.ponies_cant_decide_ts_5,
            R.raw.ponies_loco_in_coco_pp_6,
            R.raw.ponies_not_true_pp_7
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ponies_answer);


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
            MediaPlayer mp = MediaPlayer.create(this, R.raw.ponies_boring_no_q_pp);
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
                Intent submitQuestion = new Intent(PoniesAnswer.this, ChoicesList.class);

                submitQuestion.putExtra("question", mInputQuestion.getText().toString().trim());
                startActivity(submitQuestion);
            }

        });


    }
}