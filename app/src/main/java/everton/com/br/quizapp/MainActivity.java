package everton.com.br.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    Button   goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        goButton     = (Button)   findViewById(R.id.go_button);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namePlayer = nameEditText.getText().toString();

                if(namePlayer.equals("")){
                    Toast.makeText(MainActivity.this, "Preencha o campo com seu nick name", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,GameActivity.class);
                    intent.putExtra("player", namePlayer);
                    startActivity(intent);
                }
            }
        });
    }
}
