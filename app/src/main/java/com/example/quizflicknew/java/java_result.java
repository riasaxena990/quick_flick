package com.example.quizflicknew.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizflicknew.R;
import com.example.quizflicknew.menu;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class java_result extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button btnRestart;
    CircularProgressBar circularProgressBar;
    TextView resultText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1=(TextView) findViewById(R.id.tvres1);
        tv2=(TextView) findViewById(R.id.tvres2);
        tv3=(TextView) findViewById(R.id.tvres3);

        btnRestart=(Button) findViewById(R.id.buttonrestart);
        resultText=findViewById(R.id.resulttext);
        circularProgressBar=findViewById(R.id.javaprogressbar);
        circularProgressBar.setProgress(java_quiz.correct);


        //string buffere is used here to check whether the answers are right or not

        StringBuffer sb=new StringBuffer();
        sb.append("correct answer :" +java_quiz.correct +"/25");


        StringBuffer sb2=new StringBuffer();
        sb2.append("wrong answer :" +java_quiz.wrong +"/25");


        StringBuffer sb3=new StringBuffer();
        sb3.append("Final Score :" +java_quiz.correct + "/25");

        StringBuffer sb4=new StringBuffer();
        sb4.append(java_quiz.correct + "/" + "25");   //this is for result text

        tv1.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        resultText.setText(sb4);


        java_quiz.correct=0;
        java_quiz.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(java_result.this, menu.class);
                startActivity(intent);
            }
        });
    }
}