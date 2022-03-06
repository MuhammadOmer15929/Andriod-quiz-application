package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView txt1Grade;
    TextView txt2Finalscore;
    Button btn1retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getSupportActionBar().hide();
        txt1Grade = (TextView) findViewById(R.id.textView13);
        txt2Finalscore = (TextView) findViewById(R.id.textView14);
        btn1retry = (Button) findViewById(R.id.button7);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("FINAL SCORE");
        txt2Finalscore.setText(" YOU SCORED " + score + " OUT OF "  +  QuizApp.questions.length);
        if (score == 5) {
            txt1Grade.setText("OUTSTANDING");
        } else if (score == 4) {
            txt1Grade.setText("GOOD");
        } else if (score == 3) {
            txt1Grade.setText("GOOD EFFORT");
        }
        else if (score == 2)
        {
            txt1Grade.setText("NEED IMPROVEMENT");
        }

      btn1retry.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(ResultsActivity.this,MainActivity5.class));
              ResultsActivity.this.finish();
          }
      });
    }
}