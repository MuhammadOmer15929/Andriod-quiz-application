package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation animation;
    TextView tx1;
    TextView tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        tx1=(TextView)findViewById(R.id.textView);
        tx2=(TextView)findViewById(R.id.textView2);
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation1);
        tx1.setVisibility(View.VISIBLE);
        tx1.startAnimation(animation);
        tx2.setVisibility(View.VISIBLE);
        tx2.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                onBackPressed();

            }
        },3000);
    }
}