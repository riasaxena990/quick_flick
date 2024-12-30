package com.example.quizflicknew.gk;

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

public class gk_result extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button btnRestart;
    CircularProgressBar circularProgressBar;
    TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gk_result);

        // Handle system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind UI elements
        tv1 = findViewById(R.id.tvres1);
        tv2 = findViewById(R.id.tvres2);
        tv3 = findViewById(R.id.tvres3);
        btnRestart = findViewById(R.id.buttonrestart);
        resultText = findViewById(R.id.resulttext);
        circularProgressBar = findViewById(R.id.gkprogressbar);

        // Calculate progress and scale it (assuming total questions are 25)
        int scaledProgress = (gk_quiz.correct * 100) / 25; // Assuming there are 25 questions
        circularProgressBar.setProgress(scaledProgress);

        // Create StringBuffers to hold the result information
        StringBuffer sb1 = new StringBuffer();
        sb1.append("Correct Answers: " + gk_quiz.correct + "/25");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + gk_quiz.wrong + "/25");

        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + gk_quiz.correct + "/25");

        StringBuffer sb4 = new StringBuffer();
        sb4.append(gk_quiz.correct + "/" + "25"); // This is the result text to be displayed

        // Set the results to the TextViews
        tv1.setText(sb1);
        tv2.setText(sb2);
        tv3.setText(sb3);
        resultText.setText(sb4);

        // Reset the quiz data
        gk_quiz.correct = 0;
        gk_quiz.wrong = 0;

        // Restart button functionality
        btnRestart.setOnClickListener(view -> {
            Intent intent = new Intent(gk_result.this, menu.class);
            startActivity(intent);
        });
    }
}
