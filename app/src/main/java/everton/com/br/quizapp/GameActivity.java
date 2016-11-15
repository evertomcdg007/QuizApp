package everton.com.br.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    int nextQuestion = 0;
    int correctAnswer = 1;
    int answerCorrect = 0;
    private AlertDialog alerta;
    String player;

    TextView playerTextView;
    ImageView imageView;
    TextView questionTextView;
    ListView itemsListView;

    List<Integer> imageList = new ArrayList<>();
    HashMap<Integer, String> questionList = new HashMap<Integer, String>();
    List<String[]> itemsQuestion = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();

        player = getIntent().getStringExtra("player");
        playerTextView.setText(player);

        setQuestion();

        setView();

        itemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == correctAnswer){
                    answerCorrect++;
                    alertDialog("Certa resposta!!!");
                }else{
                    alertDialog("Desculpe, resposta errada!");
                }
            }
        });



    }

    private void alertDialog(String title) {

        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle(title);
        //define a mensagem
        builder.setMessage("Prepare-se?");
        //define um botão como positivo
        builder.setPositiveButton("Próxima pergunta", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
//                Toast.makeText(GameActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                nextQuestion++;
                if(nextQuestion == 1){
                    correctAnswer = 4;
                    setView();
                }else if(nextQuestion == 2){
                    correctAnswer = 2;
                    setView();
                }else if(nextQuestion == 3){
                    correctAnswer = 3;
                    setView();
                }else{
                    Intent i = new Intent(GameActivity.this, ResultActivity.class);
                    i.putExtra("result", answerCorrect);
                    i.putExtra("player", player);
                    startActivity(i);
                }


            }
        });
//        //define um botão como negativo.
//        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface arg0, int arg1) {
//                Toast.makeText(GameActivity.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
//            }
//        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    }

    private void setView() {

        imageView.setImageResource(imageList.get(nextQuestion));
        questionTextView.setText(questionList.get(nextQuestion));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsQuestion.get(nextQuestion));
        itemsListView.setAdapter(arrayAdapter);
    }

    private void initView() {
        playerTextView = (TextView) findViewById(R.id.player_textView);
        imageView = (ImageView) findViewById(R.id.image_imageView);
        questionTextView = (TextView) findViewById(R.id.question_textView);
        itemsListView = (ListView) findViewById(R.id.items_listView);

    }


    private void setQuestion() {

        String question1 = getResources().getString(R.string.question1);
        String question2 = getResources().getString(R.string.question2);
        String question3 = getResources().getString(R.string.question3);
        String question4 = getResources().getString(R.string.question4);
        String question5 = getResources().getString(R.string.question5);

        questionList.put(0, question1);
        questionList.put(1, question2);
        questionList.put(2, question3);
        questionList.put(3, question4);

        String itemsQuestion1[] = getResources().getStringArray(R.array.items_question1);
        String itemsQuestion2[] = getResources().getStringArray(R.array.items_question2);
        String itemsQuestion3[] = getResources().getStringArray(R.array.items_question3);
        String itemsQuestion4[] = getResources().getStringArray(R.array.items_question4);

        itemsQuestion.add(itemsQuestion1);
        itemsQuestion.add(itemsQuestion2);
        itemsQuestion.add(itemsQuestion3);
        itemsQuestion.add(itemsQuestion4);

        imageList.add(R.drawable.servia_montenegro);
        imageList.add(R.drawable.guerra_civil);
        imageList.add(R.drawable.margot_robbie);
        imageList.add(R.drawable.opera_sidney_australia);



    }


}
