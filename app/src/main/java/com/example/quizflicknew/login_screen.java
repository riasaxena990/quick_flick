package com.example.quizflicknew;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.quizflicknew.databinding.ActivityLoginScreenBinding;
import com.example.quizflicknew.databinding.ActivityMainBinding;

public class login_screen extends AppCompatActivity {

    ActivityLoginScreenBinding binding;
    MyDatabase mydb;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginScreenBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);


        setContentView(binding.getRoot());
        mydb= Room.databaseBuilder(this,MyDatabase.class,"usertable")
                        .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDao=mydb.getDao();

        binding.newsigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=binding.username.getText().toString();
                String password=binding.password.getText().toString();
                if(userDao.login(userName,password)){
                    startActivity(new Intent(login_screen.this, verify.class));
                }
                else{
                    Toast.makeText(login_screen.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnlogin=findViewById(R.id.newsignin_button);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login_screen.this,register.class);
                startActivity(intent);
            }
        });

        Button buttonlogin = findViewById(R.id.loginButton);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_screen.this, verify.class);
                startActivity(intent);
            }
        });

      Button btnfgt = findViewById(R.id.forget_btn);
        btnfgt.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(login_screen.this,forgetpassword.class);
                startActivity(intent);
            }
        });


        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=binding.username.getText().toString();
                String password=binding.password.getText().toString();
                if((userName == null) || password.isEmpty()){
                    Toast.makeText(login_screen.this, "Please enter valid Username or Password", Toast.LENGTH_SHORT).show();
                }
                else if(userDao.login(userName,password)){
                    Intent intent2 = new Intent(login_screen.this, verify.class);
                    startActivity(intent2);
                }
                else{
                    Toast.makeText(login_screen.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}