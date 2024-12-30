package com.example.quizflicknew.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizflicknew.R;
import com.example.quizflicknew.menu;

public class java_quiz extends AppCompatActivity {

    String questions[] = {
            "Which of the following option leads to the portability and security of Java?",
            "Which of the following is not a Java feature?",
            "_____ is used to find and fix bugs in the Java program.",
            "Evaluate the following Java expression, if x=3, y=5, and z=10:\n++z + y - y + z + x++",
            "Which keyword is used to define a constant in Java?",
            "What is the size of the int data type in Java?",
            "Which of these is not a keyword in Java?",
            "What is the default value of a boolean variable in Java?",
            "Which of these is the wrapper class for the int primitive type?",
            "Which method can be used to find the length of a string in Java?",
            "Which of these access modifiers allows access only within the same class?",
            "What is the default value of a char variable in Java?",
            "Which package contains the Random class in Java?",
            "Which of the following is not a type of constructor in Java?",
            "Which method is used to compare two strings in Java?",
            "Which of the following loops is a post-test loop?",
            "What is the purpose of the 'final' keyword in Java?",
            "Which class in Java is used to handle input and output streams?",
            "Which exception is thrown when dividing by zero in Java?",
            "Which collection class in Java allows duplicate values?",
            "Which thread method is used to stop the thread execution?",
            "Which of the following is not an OOP concept in Java?",
            "What is the default value of a static variable in Java?",
            "Which interface does java.util.HashMap implement?",
            "Which of the following statements is true about Java?"
    };

    String answer[] = {
            "Bytecode is executed by JVM",
            "Use of pointers",
            "JDB",
            "25",
            "final",
            "4 bytes",
            "goto",
            "false",
            "Integer",
            "length()",
            "private",
            "'\\u0000'",
            "java.util",
            "Static constructor",
            "equals()",
            "do-while",
            "To prevent inheritance",
            "java.io",
            "ArithmeticException",
            "ArrayList",
            "stop()",
            "Pointer manipulation",
            "0",
            "Map",
            "Java supports platform independence"
    };

    String options[] = {
            "Bytecode is executed by JVM", "The applet makes the Java code secure and portable", "Use of exception handling", "Dynamic binding between objects",
            "Dynamic", "Use of pointers", "Architecture neutral", "Object-oriented",
            "JVM", "JRE", "JDK", "JDB",
            "24", "25", "30", "20",
            "static", "final", "constant", "const",
            "2 bytes", "4 bytes", "8 bytes", "16 bytes",
            "goto", "finalize", "volatile", "instanceof",
            "true", "false", "null", "undefined",
            "Integer", "Int", "intWrapper", "Number",
            "length()", "size()", "getLength()", "stringSize()",
            "private", "public", "protected", "default",
            "'0'", "' '", "'\\u0000'", "null",
            "java.util", "java.lang", "java.random", "java.io",
            "Parameterized constructor", "Default constructor", "Copy constructor", "Static constructor",
            "compare()", "equals()", "==", "compareTo()",
            "for", "while", "do-while", "foreach",
            "To prevent inheritance", "To enable inheritance", "To create abstract classes", "To overload methods",
            "java.util", "java.io", "java.streams", "java.files",
            "ArithmeticException", "NullPointerException", "IOException", "NumberFormatException",
            "HashSet", "ArrayList", "HashMap", "TreeSet",
            "stop()", "pause()", "terminate()", "end()",
            "Encapsulation", "Polymorphism", "Pointer manipulation", "Inheritance",
            "null", "0", "undefined", "default",
            "Map", "Set", "Queue", "List",
            "Java supports multiple inheritance", "Java is platform-independent", "Java allows direct memory access", "Java uses call-by-reference"
    };

    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    TextView tv;
    Button submitbutton,quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    private TextView questionnumber;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        final TextView score = (TextView) findViewById(R.id.score);
        TextView textView = (TextView) findViewById(R.id.DisplayName);
        Intent intent = getIntent();

        questionnumber = findViewById(R.id.DisplayName);
        submitbutton = (Button) findViewById(R.id.next);
        quitbutton = (Button) findViewById(R.id.quit);
        tv = (TextView) findViewById(R.id.java_question);


        radio_g = (RadioGroup) findViewById(R.id.answerGroup);
        rb1 = (RadioButton) findViewById(R.id.radiobutton1);
        rb2 = (RadioButton) findViewById(R.id.radiobutton2);
        rb3 = (RadioButton) findViewById(R.id.radiobutton3);
        rb4 = (RadioButton) findViewById(R.id.radiobutton4);

        tv.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(java_quiz.this, "please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText.equals(answer[flag])) {
                    correct++;
                    Toast.makeText(java_quiz.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(java_quiz.this, "wrong", Toast.LENGTH_SHORT).show();

                }

                flag++;
                if (score != null) {
                    score.setText("" + correct);

                    if (flag < questions.length) {
                        tv.setText(questions[flag]);
                        rb1.setText(options[flag * 4]);
                        rb2.setText(options[flag * 4 + 1]);
                        rb3.setText(options[flag * 4 + 2]);
                        rb4.setText(options[flag * 4 + 3]);
                        questionnumber.setText(flag + "/" + questions.length + "question");

                    } else {
                        marks = correct;
                        Intent in = new Intent(java_quiz.this, java_result.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();

                }

            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), java_result.class);
                startActivity(intent1);
            }
        });
    }
}