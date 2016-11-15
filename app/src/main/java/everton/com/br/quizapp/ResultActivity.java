package everton.com.br.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView testTextView;
    TextView playerTextView;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();

        String player = getIntent().getStringExtra("player");
        String result = getIntent().getStringExtra("result");

        int answerCorrect = Integer.parseInt(result);

        if(answerCorrect < 3){
            testTextView.setText("Desculpe! Você perdeu.");
        }else{
            testTextView.setText("Parabéns! Você ganhou.");
        }

        playerTextView.setText(player);
        resultTextView.setText("Sua pontuação foi : "+answerCorrect);

    }

    private void initView() {
        testTextView = (TextView) findViewById(R.id.test_textView);
        playerTextView = (TextView) findViewById(R.id.player_textView);
        resultTextView = (TextView) findViewById(R.id.result_textView);
    }
}
