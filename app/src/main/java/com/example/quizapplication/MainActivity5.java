package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
          TextView txt1score;
          TextView txt2Questions;
          Button btn1True;
          Button btn1False;

          boolean answer;
          int score=0;
          int QuestionNumber=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();
        txt1score=(TextView) findViewById(R.id.textView10);
        txt2Questions=(TextView) findViewById(R.id.textView11);
        btn1True=(Button) findViewById(R.id.radioButton5);
        btn1False=(Button) findViewById(R.id.radioButton6);

        updateQuestion();

        btn1True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer == true) {
                    score++;
                    UpdateScore(score);

                    if (QuestionNumber == QuizApp.questions.length)
                    {
                        Intent intent=new Intent(MainActivity5.this,ResultsActivity.class);
                        Bundle bundle =new Bundle();
                        bundle.putInt("FINAL SCORE",score);
                        intent.putExtras(bundle);
                        MainActivity5.this.finish();
                        startActivity(intent);
                    }
                    else
                    {
                        updateQuestion();
                    }
                }
                else
                {
                    if (QuestionNumber == QuizApp.questions.length)
                    {
                        Intent intent=new Intent(MainActivity5.this,ResultsActivity.class);
                        Bundle bundle =new Bundle();
                        bundle.putInt("FINAL SCORE",score);
                        intent.putExtras(bundle);
                        MainActivity5.this.finish();
                        startActivity(intent);
                    }
                    else
                    {
                        updateQuestion();
                    }
                }
            }
        });
        btn1False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer == false) {
                    score++;
                    UpdateScore(score);

                    if (QuestionNumber == QuizApp.questions.length)
                    {
                        Intent intent=new Intent(MainActivity5.this,ResultsActivity.class);
                        Bundle bundle =new Bundle();
                        bundle.putInt("FINAL SCORE",score);
                        intent.putExtras(bundle);
                        MainActivity5.this.finish();
                        startActivity(intent);
                    }
                    else
                    {
                        updateQuestion();
                    }
                }
                else
                {
                    if (QuestionNumber == QuizApp.questions.length)
                    {
                        Intent intent=new Intent(MainActivity5.this,ResultsActivity.class);
                        Bundle bundle =new Bundle();
                        bundle.putInt("FINAL SCORE",score);
                        intent.putExtras(bundle);
                        MainActivity5.this.finish();
                        startActivity(intent);
                    }
                    else
                    {
                        updateQuestion();
                    }
                }
            }
        });


    }
    public void updateQuestion()
    {
        txt2Questions.setText(QuizApp.questions[QuestionNumber]);
        answer =QuizApp.answers[QuestionNumber];
        QuestionNumber++;

    }
    public void UpdateScore(int point)
    {
        txt1score.setText(" SCORE: "+score);
    }
}