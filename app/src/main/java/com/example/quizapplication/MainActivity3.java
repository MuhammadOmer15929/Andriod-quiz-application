package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    String[] questions,answers;
    TextView txtx1;
    TextView txty2;
    TextView txtq3;
    TextView txta4;
    Button btnl1;
    Button btna2;
    Button btnr3;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
       txtx1=(TextView)findViewById(R.id.textView3);
       txty2=(TextView)findViewById(R.id.textView5);
       txtq3=(TextView)findViewById(R.id.textView6);
       txta4=(TextView)findViewById(R.id.textView7);

       btnl1=(Button)findViewById(R.id.button8);
       btna2=(Button)findViewById(R.id.button);
       btnr3=(Button)findViewById(R.id.button5);


       questions=getResources().getStringArray(R.array.questions);
       answers=getResources().getStringArray(R.array.answerS);



            index=0;
            txtq3.setText(questions[index]);
            txta4.setText("Press A for Answer");
            txtx1.setText(String.valueOf(index+1));
            txty2.setText("/"+String.valueOf(questions.length));

            btnl1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txta4.setText("Press A for the Answer");
                    index--;
                    txtq3.setText(questions[index]);
                    txtx1.setText(String.valueOf(index+1));
                }
            });
        btna2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txta4.setText(answers[index]);

            }
        });
        btnr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txta4.setText("Press A for Answer");
                index++;
                txtq3.setText(questions[index]);
                txtx1.setText(String.valueOf(index+1));

            }
        });
        }


    }


