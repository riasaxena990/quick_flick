package com.example.quizflicknew.cplus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizflicknew.R;
import com.example.quizflicknew.java.java_result;

public class cplus_quiz extends AppCompatActivity {

    String[] questions = {
            "Who is the creator of the C++ programming language?",
            "Which header file is used for input/output in C++?",
            "What is the default access specifier for class members in C++?",
            "Which of the following is not a fundamental data type in C++?",
            "What does the keyword `virtual` represent in C++?",
            "Which of these is an invalid identifier in C++?",
            "Which operator is used for dynamic memory allocation in C++?",
            "What is a correct way to declare a pointer in C++?",
            "Which type of inheritance involves multiple base classes in C++?",
            "What is the return type of the main function in C++?",
            "Which function is used to deallocate memory allocated by `new` in C++?",
            "What is the size of an int data type in C++ on most systems?",
            "Which of the following is not a storage class specifier in C++?",
            "What does the `this` pointer point to in C++?",
            "Which keyword is used to prevent a variable from being modified in C++?",
            "What does the term 'overloading' mean in C++?",
            "What is the purpose of the `friend` keyword in C++?",
            "Which feature of C++ allows multiple functions with the same name but different parameters?",
            "What is a template in C++ used for?",
            "What happens if a constructor is declared private in C++?",
            "Which of the following is not a valid looping structure in C++?",
            "What is the purpose of a destructor in C++?",
            "Which type of error occurs at runtime in C++?",
            "What does `cout` stand for in C++?",
            "Which function is automatically called when an object is created in C++?"
    };

    String[] answers = {
            "Bjarne Stroustrup",
            "<iostream>",
            "Private",
            "Boolean",
            "Polymorphism",
            "2myVariable",
            "new",
            "int* ptr;",
            "Multiple inheritance",
            "int",
            "delete",
            "4 bytes",
            "mutable",
            "The calling object",
            "const",
            "Defining multiple methods with the same name",
            "Access private members of a class",
            "Function overloading",
            "Generic programming",
            "Object cannot be created outside the class",
            "foreach",
            "Free resources when object is destroyed",
            "Exception",
            "Character Output",
            "Constructor"
    };

    String[][] options = {
            {"Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Guido van Rossum"},
            {"<stdio.h>", "<fstream>", "<iostream>", "<cstring>"},
            {"Public", "Private", "Protected", "Default"},
            {"Integer", "Boolean", "Float", "Character"},
            {"Encapsulation", "Inheritance", "Polymorphism", "Abstraction"},
            {"2myVariable", "_myVariable", "my_variable", "MyVariable2"},
            {"malloc", "new", "calloc", "malloc_new"},
            {"int ptr;", "int* ptr;", "int &ptr;", "pointer ptr;"},
            {"Single inheritance", "Multilevel inheritance", "Hierarchical inheritance", "Multiple inheritance"},
            {"void", "int", "main", "None"},
            {"free", "release", "delete", "remove"},
            {"2 bytes", "4 bytes", "8 bytes", "16 bytes"},
            {"auto", "register", "mutable", "static"},
            {"Base class", "The calling object", "Global variables", "None"},
            {"final", "static", "const", "mutable"},
            {"Defining multiple methods with the same name", "Defining one method for multiple objects", "Both", "None"},
            {"Access private members of a class", "To end a loop", "To avoid inheritance", "None"},
            {"Function overloading", "Abstract classes", "Templates", "Virtual functions"},
            {"Generic programming", "Access control", "Memory allocation", "Encapsulation"},
            {"Object cannot be created outside the class", "Private constructor is not allowed", "Object is deleted", "None"},
            {"foreach", "while", "do-while", "for"},
            {"Initialize variables", "Free resources when object is destroyed", "Allocate memory", "None"},
            {"Compile-time error", "Linker error", "Exception", "Logic error"},
            {"Character Output", "Constant Output", "Compute Output", "None"},
            {"Destructor", "Overloaded function", "Constructor", "Virtual function"}
    };

    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    TextView tv, questionNumber;
    Button submitButton, quitButton;
    RadioGroup radioGroup;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplus_quiz);

        tv = findViewById(R.id.cplus_question);

        final TextView score = findViewById(R.id.score1);
        questionNumber = findViewById(R.id.DisplayName1);
        submitButton = findViewById(R.id.next1);
        quitButton = findViewById(R.id.quit1);
        radioGroup = findViewById(R.id.answerGroup1);
        rb1 = findViewById(R.id.radiobutton11);
        rb2 = findViewById(R.id.radiobutton12);
        rb3 = findViewById(R.id.radiobutton13);
        rb4 = findViewById(R.id.radiobutton14);

        tv.setText(questions[flag]);
        rb1.setText(options[flag][0]);
        rb2.setText(options[flag][1]);
        rb3.setText(options[flag][2]);
        rb4.setText(options[flag][3]);

        submitButton.setOnClickListener(view -> {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(cplus_quiz.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton userAnswer = findViewById(radioGroup.getCheckedRadioButtonId());
            if (userAnswer.getText().toString().equals(answers[flag])) {
                correct++;
                Toast.makeText(cplus_quiz.this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                wrong++;
                Toast.makeText(cplus_quiz.this, "Wrong!", Toast.LENGTH_SHORT).show();
            }

            flag++;
            if (score != null) {
                score.setText(String.valueOf(correct));
            }
            if (flag < questions.length) {
                tv.setText(questions[flag]);
                rb1.setText(options[flag][0]);
                rb2.setText(options[flag][1]);
                rb3.setText(options[flag][2]);
                rb4.setText(options[flag][3]);
                questionNumber.setText((flag + 1) + "/" + questions.length + " Question");
                radioGroup.clearCheck();
            } else {
                marks = correct;
                Intent intent = new Intent(cplus_quiz.this, cplus_result.class);
                startActivity(intent);
            }
        });

        quitButton.setOnClickListener(view -> {
            Intent intent = new Intent(cplus_quiz.this, cplus_result.class);
            startActivity(intent);
        });
    }
}
