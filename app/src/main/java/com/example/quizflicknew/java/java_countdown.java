package com.example.quizflicknew.java;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizflicknew.R;

public class java_countdown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_countdown);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Correct implementation of the Handler
        new Handler().postDelayed(() -> {
            // Move to the menu activity after 2 seconds
            Intent intent = new Intent(java_countdown.this, java_quiz.class);
            startActivity(intent);
            finish(); // End the activity
        }, 2900);  // Delay of 2000 milliseconds (2 seconds)

    }
    public void java(View view) {
        Intent intent=new Intent(java_countdown.this,java_quiz.class);
        startActivity(intent);


    }

}
