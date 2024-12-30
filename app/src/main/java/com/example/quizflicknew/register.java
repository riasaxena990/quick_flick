package com.example.quizflicknew;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.quizflicknew.databinding.ActivityRegisterBinding;

public class register extends AppCompatActivity {

    ActivityRegisterBinding binding;
    MyDatabase mydb;
    UserDao userDao;
    public static boolean isAllowed=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityRegisterBinding.inflate(getLayoutInflater());


        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        mydb= Room.databaseBuilder(this,MyDatabase.class,"usertable")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDao=mydb.getDao();
        binding.userName.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2){

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2){

            }

            @Override
            public void afterTextChanged(Editable editable){
                String userName = editable.toString();
                if(userDao.is_taken(userName)){
                    isAllowed= false;
                    Toast.makeText(register.this, "Username already Taken", Toast.LENGTH_SHORT).show();
                }
                else{
                    isAllowed= true;
                }
            }


        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            Button btnnewlogin=findViewById(R.id.newlogin);
            btnnewlogin.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    String fullName = binding.fullName.getText().toString();
                    String username = binding.userName.getText().toString();
                    String password = binding.passwrd.getText().toString();
                    String retypepassword = binding.retypePasswrd.getText().toString();
                    if(isAllowed){
                        if((fullName.isEmpty()) || (username.isEmpty()) || (password.isEmpty()) || (retypepassword.isEmpty())){
                            Toast.makeText(register.this, "Please complete all fields", Toast.LENGTH_SHORT).show();
                        }else {
                            UserTable userTable = new UserTable(0, binding.userName.getText().toString(), binding.passwrd.getText().toString());
                            userDao.insertUser(userTable);
                            Intent intent = new Intent(register.this, login_screen.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(register.this, "Username Already Taken", Toast.LENGTH_SHORT).show();
                    }
                }
        });

    }
}