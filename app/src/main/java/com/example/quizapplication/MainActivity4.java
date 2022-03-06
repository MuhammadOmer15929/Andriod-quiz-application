package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    TextView txtno1;
    TextView txtqo2;
    Button btno1;
    Button btno2;
    Button btno3;
    Button btno4;
    public ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentscore=0;
    int Questionattempted=1;
    int currentpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().hide();
        txtno1=(TextView)findViewById(R.id.textView4);
        txtqo2=(TextView)findViewById(R.id.textView8);
        btno1=(Button) findViewById(R.id.radioButton);
        btno2=(Button) findViewById(R.id.radioButton2);
        btno3=(Button) findViewById(R.id.radioButton3);
        btno4=(Button) findViewById(R.id.radioButton4);
        quizModelArrayList = new ArrayList<>();
        random =new Random();
        getQuizQuestion(quizModelArrayList);
        currentpos=random.nextInt(quizModelArrayList.size());
        setDataView(currentpos);
        btno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(btno1.getText().toString().trim().toLowerCase()))
                {
                    currentscore++;
                }
                Questionattempted++;
                currentpos=random.nextInt(quizModelArrayList.size());
                setDataView(currentpos);
            }

        });
        btno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(btno2.getText().toString().trim().toLowerCase()))
                {
                    currentscore++;
                }
                Questionattempted++;
                currentpos=random.nextInt(quizModelArrayList.size());
                setDataView(currentpos);
            }

        });
        btno3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(btno3.getText().toString().trim().toLowerCase()))
                {
                    currentscore++;
                }
                Questionattempted++;
                currentpos=random.nextInt(quizModelArrayList.size());
                setDataView(currentpos);
            }
        });
         btno4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(quizModelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(btno4.getText().toString().trim().toLowerCase()))
                 {
                     currentscore++;
                 }
                 Questionattempted++;
                 currentpos=random.nextInt(quizModelArrayList.size());
                 setDataView(currentpos);
             }
         });

    }
    private void setDataView(int currentpos)
    {
         txtno1.setText("Questions Attempted : "+Questionattempted+ "/10");
         if(Questionattempted==10)
         {
             showScoresheet();
         }else {
             txtqo2.setText(quizModelArrayList.get(currentpos).getQuestion());
             btno1.setText(quizModelArrayList.get(currentpos).getOption1());
             btno2.setText(quizModelArrayList.get(currentpos).getOption2());
             btno3.setText(quizModelArrayList.get(currentpos).getOption3());
             btno4.setText(quizModelArrayList.get(currentpos).getOption4());
         }


    }
    private void showScoresheet()
    {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity4.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.scoresheet,(LinearLayout)findViewById(R.id.score1));
        TextView scoreTV =bottomSheetView.findViewById(R.id.score);
        Button restart =bottomSheetView.findViewById(R.id.restart);
        scoreTV.setText("YOUR SCORE IS\n"+currentscore+ "/10");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpos=random.nextInt(quizModelArrayList.size());
                setDataView(currentpos);
                Questionattempted=1;
                currentscore=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
    private void getQuizQuestion(ArrayList<QuizModel>quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("Which of the following is the name of the Android version 1.5?","Eclair","Froyo","Cupcake","Donut","Donout"));
        quizModelArrayList.add(new QuizModel("Which of the layer is below the topmost layer of android architecture?","System Libraries and Android Runtime","Linux Kernel","Applications","Applications Framework","Applications Framework"));
        quizModelArrayList.add(new QuizModel("What is contained in manifest.xml?","Source code","List of strings used in the app","Permission that the application requires","None of the above","Permission that the application requires"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a state in the service lifecycle?","Destroyed","Start","Paused","Running","Paused"));
        quizModelArrayList.add(new QuizModel("Which of the following is not a nickname of any android version?","Donut","Muffin","Honeycomb","Cupcake","Muffin"));
        quizModelArrayList.add(new QuizModel(" Which of the following is the built-in database of Android?","SQLite","MySQL","Oracle","None of the above","SQLite"));
        quizModelArrayList.add(new QuizModel(" Which of the following android version is named Jelly Bean?","3.1","2.1","1.1","4.1","4.1"));
        quizModelArrayList.add(new QuizModel("Which of the following is the API level of Android version 5.0?","21","20","11","41","21"));
        quizModelArrayList.add(new QuizModel("Is it true that There can be only one running activity at a given time?","True","False","May be","Can't say","True"));
        quizModelArrayList.add(new QuizModel("In which of the following tab an error is shown?","CPU","Memory","ADB Logs","Logcat","logcat"));
    }
}