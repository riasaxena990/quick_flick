package com.example.quizflicknew;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class verify extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Correct implementation of the Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Move to the menu activity after 2 seconds
                Intent intent = new Intent(verify.this, menu.class);
                startActivity(intent);
                finish(); // End the activity
            }
        }, 1500);  // Delay of 2000 milliseconds (2 seconds)
    }
}
