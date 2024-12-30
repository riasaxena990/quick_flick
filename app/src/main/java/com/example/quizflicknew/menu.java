package com.example.quizflicknew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizflicknew.cplus.cplus_countdown;
import com.example.quizflicknew.gk.gkcountdown;
import com.example.quizflicknew.java.java_countdown;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton btnjava = findViewById(R.id.java);
        btnjava.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(menu.this, java_countdown.class);
                startActivity(intent);
            }
        });
        ImageButton btncplus = findViewById(R.id.cplus);
        btncplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, cplus_countdown.class);
                startActivity(intent);
            }
        });
        ImageButton btngk = findViewById(R.id.gnrlknwlg);
        btngk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this, gkcountdown.class);
                startActivity(intent);
            }
        });
        Button btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the login screen
                Intent intent = new Intent(menu.this, login_screen.class);
                startActivity(intent);
                finish(); // Optional: Closes the current activity to prevent returning to it
            }
        });

    }
}
