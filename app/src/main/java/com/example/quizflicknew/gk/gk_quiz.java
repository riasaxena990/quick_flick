//package com.example.quizflicknew.gk;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.quizflicknew.R;
//import com.example.quizflicknew.java.java_quiz;
//import com.example.quizflicknew.java.java_result;
//
//public class gk_quiz extends AppCompatActivity {
//
//    String questions[] = {
//            "What is the name of the world's largest radio telescope inaugurated in 2024?",
//            "Which country hosted COP28 in 2024?",
//            "Which country won the ICC Cricket World Cup 2023?",
//            "What is the name of the recently launched NASA mission to explore a metal-rich asteroid?",
//            "Which nation launched the Chandrayaan-3 mission and achieved a successful moon landing in 2023?",
//            "What is the new global climate fund introduced at COP28 called?",
//            "Which city hosted the 2024 Summer Olympics?",
//            "What is the recently developed AI model by OpenAI named?",
//            "Which country became the newest member of BRICS in 2024?",
//            "What is the name of the new COVID-19 variant identified in 2024?",
//            "Which movie won the Best Picture award at the 2024 Oscars?",
//            "Who won the 2024 Nobel Peace Prize?",
//            "What is the name of the recently announced Tesla electric truck?",
//            "Which country launched the world’s first hydrogen-powered train in 2024?",
//            "What is the theme of World Environment Day 2024?",
//            "Which nation recorded the highest GDP growth in 2023?",
//            "What breakthrough fusion energy milestone was achieved in 2024?",
//            "Who was the top goal scorer in the FIFA Women’s World Cup 2023?",
//            "What is the name of the newest exoplanet discovered in 2024?",
//            "Which country introduced the digital euro in 2024?",
//            "Which tech giant released the Vision Pro headset in 2024?",
//            "What is the name of the comet that made a rare appearance in 2024?",
//            "Which country has the fastest-growing space exploration program in 2024?",
//            "Who is the current Secretary-General of the United Nations?",
//            "What is the name of the book by a Nobel laureate released in 2024?"
//    };
//
//    String answer[] = {
//            "Square Kilometer Array (SKA)",
//            "UAE",
//            "India",
//            "Psyche",
//            "India",
//            "Loss and Damage Fund",
//            "Paris",
//            "GPT-4",
//            "Saudi Arabia",
//            "Pirola",
//            "Oppenheimer",
//            "Volodymyr Zelenskyy",
//            "Cybertruck",
//            "Germany",
//            "Restore Nature, Revive Life",
//            "India",
//            "Ignition in Laser Fusion",
//            "Hinata Miyazawa",
//            "Kepler-452c",
//            "France",
//            "Apple",
//            "Comet Nishimura",
//            "China",
//            "António Guterres",
//            "The Future We Choose"
//    };
//
//    String options[] = {
//            "Square Kilometer Array (SKA)", "FAST", "ALMA", "MeerKAT",
//            "UAE", "India", "Germany", "Brazil",
//            "Australia", "India", "England", "Pakistan",
//            "Psyche", "Lucy", "Artemis", "Perseverance",
//            "India", "China", "USA", "Russia",
//            "Climate Recovery Fund", "Green Earth Fund", "Loss and Damage Fund", "Net Zero Fund",
//            "Tokyo", "Paris", "Los Angeles", "Beijing",
//            "GPT-3", "Bard", "GPT-4", "Claude",
//            "Argentina", "Saudi Arabia", "South Africa", "Mexico",
//            "Pirola", "Delta-Plus", "Omicron-X", "Eris",
//            "Oppenheimer", "Avatar 2", "Everything Everywhere All at Once", "The Whale",
//            "Greta Thunberg", "Volodymyr Zelenskyy", "Malala Yousafzai", "Pope Francis",
//            "Semi", "Cybertruck", "Model Y", "Plaid Truck",
//            "USA", "Germany", "Japan", "Norway",
//            "Protect the Planet", "Restore Nature, Revive Life", "Save Wildlife", "Zero Pollution",
//            "China", "USA", "India", "Brazil",
//            "Fusion Stability", "Ignition in Laser Fusion", "Cold Fusion Test", "Energy Net Experiment",
//            "Megan Rapinoe", "Hinata Miyazawa", "Alex Morgan", "Sam Kerr",
//            "Kepler-452c", "TOI-700d", "Proxima Centauri b", "Gliese 581g",
//            "France", "Germany", "Spain", "Italy",
//            "Meta", "Google", "Apple", "Samsung",
//            "Halley’s Comet", "Comet Nishimura", "Comet Leonard", "Comet McNaught",
//            "USA", "China", "India", "Russia",
//            "António Guterres", "Ban Ki-moon", "Kofi Annan", "Tedros Adhanom",
//            "The Future We Choose", "Lessons from the Pandemic", "Hope for Tomorrow", "Climate Change in Focus"
//    };
//
//    int flag=0;
//    public static int marks=0,correct=0,wrong=0;
//
//
//    TextView tv;
//    Button submitbutton,quitbutton;
//    RadioGroup radio_g;
//    RadioButton rb1,rb2,rb3,rb4;
//    private TextView questionnumber;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_gk_quiz);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//
//        final TextView score = (TextView) findViewById(R.id.score2);
//        TextView textView = (TextView) findViewById(R.id.DisplayName2);
//        Intent intent = getIntent();
//
//        questionnumber = findViewById(R.id.DisplayName2);
//        submitbutton = (Button) findViewById(R.id.next2);
//        quitbutton = (Button) findViewById(R.id.quit2);
//        tv = (TextView) findViewById(R.id.gk_question);
//
//
//        radio_g = (RadioGroup) findViewById(R.id.answerGroup2);
//        rb1 = (RadioButton) findViewById(R.id.radiobutton21);
//        rb2 = (RadioButton) findViewById(R.id.radiobutton22);
//        rb3 = (RadioButton) findViewById(R.id.radiobutton23);
//        rb4 = (RadioButton) findViewById(R.id.radiobutton24);
//
//        tv.setText(questions[flag]);
//        rb1.setText(options[0]);
//        rb2.setText(options[1]);
//        rb3.setText(options[2]);
//        rb4.setText(options[3]);
//
//        submitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (radio_g.getCheckedRadioButtonId() == -1) {
//                    Toast.makeText(gk_quiz.this, "please select one choice", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
//                String ansText = uans.getText().toString();
//
//                if (ansText.equals(answer[flag])) {
//                    correct++;
//                    Toast.makeText(gk_quiz.this, "correct", Toast.LENGTH_SHORT).show();
//                } else {
//                    wrong++;
//                    Toast.makeText(gk_quiz.this, "wrong", Toast.LENGTH_SHORT).show();
//
//                }
//
//                flag++;
//                if (score != null) {
//                    score.setText("" + correct);
//
//                    if (flag < questions.length) {
//                        tv.setText(questions[flag]);
//                        rb1.setText(options[flag * 4]);
//                        rb2.setText(options[flag * 4 + 1]);
//                        rb3.setText(options[flag * 4 + 2]);
//                        rb4.setText(options[flag * 4 + 3]);
//                        questionnumber.setText(flag + "/" + questions.length + "question");
//
//                    } else {
//                        marks = correct;
//                        Intent in = new Intent(gk_quiz.this, gk_result.class);
//                        startActivity(in);
//                    }
//
//                    radio_g.clearCheck();
//
//                }
//
//            }
//        });
//
//        quitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent1 = new Intent(getApplicationContext(), gk_result.class);
//                startActivity(intent1);
//            }
//        });
//    }
//}

package com.example.quizflicknew.gk;

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

public class gk_quiz extends AppCompatActivity {

    String questions[] = {
            "What is the name of the world's largest radio telescope inaugurated in 2024?",
            "Which country hosted COP28 in 2024?",
            "Which country won the ICC Cricket World Cup 2023?",
            "What is the name of the recently launched NASA mission to explore a metal-rich asteroid?",
            "Which nation launched the Chandrayaan-3 mission and achieved a successful moon landing in 2023?",
            "What is the new global climate fund introduced at COP28 called?",
            "Which city hosted the 2024 Summer Olympics?",
            "What is the recently developed AI model by OpenAI named?",
            "Which country became the newest member of BRICS in 2024?",
            "What is the name of the new COVID-19 variant identified in 2024?",
            "Which movie won the Best Picture award at the 2024 Oscars?",
            "Who won the 2024 Nobel Peace Prize?",
            "What is the name of the recently announced Tesla electric truck?",
            "Which country launched the world’s first hydrogen-powered train in 2024?",
            "What is the theme of World Environment Day 2024?",
            "Which nation recorded the highest GDP growth in 2023?",
            "What breakthrough fusion energy milestone was achieved in 2024?",
            "Who was the top goal scorer in the FIFA Women’s World Cup 2023?",
            "What is the name of the newest exoplanet discovered in 2024?",
            "Which country introduced the digital euro in 2024?",
            "Which tech giant released the Vision Pro headset in 2024?",
            "What is the name of the comet that made a rare appearance in 2024?",
            "Which country has the fastest-growing space exploration program in 2024?",
            "Who is the current Secretary-General of the United Nations?",
            "What is the name of the book by a Nobel laureate released in 2024?"
    };

    String answer[] = {
            "Square Kilometer Array (SKA)",
            "UAE",
            "India",
            "Psyche",
            "India",
            "Loss and Damage Fund",
            "Paris",
            "GPT-4",
            "Saudi Arabia",
            "Pirola",
            "Oppenheimer",
            "Volodymyr Zelenskyy",
            "Cybertruck",
            "Germany",
            "Restore Nature, Revive Life",
            "India",
            "Ignition in Laser Fusion",
            "Hinata Miyazawa",
            "Kepler-452c",
            "France",
            "Apple",
            "Comet Nishimura",
            "China",
            "António Guterres",
            "The Future We Choose"
    };

    String options[] = {
            "Square Kilometer Array (SKA)", "FAST", "ALMA", "MeerKAT",
            "UAE", "India", "Germany", "Brazil",
            "Australia", "India", "England", "Pakistan",
            "Psyche", "Lucy", "Artemis", "Perseverance",
            "India", "China", "USA", "Russia",
            "Climate Recovery Fund", "Green Earth Fund", "Loss and Damage Fund", "Net Zero Fund",
            "Tokyo", "Paris", "Los Angeles", "Beijing",
            "GPT-3", "Bard", "GPT-4", "Claude",
            "Argentina", "Saudi Arabia", "South Africa", "Mexico",
            "Pirola", "Delta-Plus", "Omicron-X", "Eris",
            "Oppenheimer", "Avatar 2", "Everything Everywhere All at Once", "The Whale",
            "Greta Thunberg", "Volodymyr Zelenskyy", "Malala Yousafzai", "Pope Francis",
            "Semi", "Cybertruck", "Model Y", "Plaid Truck",
            "USA", "Germany", "Japan", "Norway",
            "Protect the Planet", "Restore Nature, Revive Life", "Save Wildlife", "Zero Pollution",
            "China", "USA", "India", "Brazil",
            "Fusion Stability", "Ignition in Laser Fusion", "Cold Fusion Test", "Energy Net Experiment",
            "Megan Rapinoe", "Hinata Miyazawa", "Alex Morgan", "Sam Kerr",
            "Kepler-452c", "TOI-700d", "Proxima Centauri b", "Gliese 581g",
            "France", "Germany", "Spain", "Italy",
            "Meta", "Google", "Apple", "Samsung",
            "Halley’s Comet", "Comet Nishimura", "Comet Leonard", "Comet McNaught",
            "USA", "China", "India", "Russia",
            "António Guterres", "Ban Ki-moon", "Kofi Annan", "Tedros Adhanom",
            "The Future We Choose", "Lessons from the Pandemic", "Hope for Tomorrow", "Climate Change in Focus"
    };

    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;

    TextView tv, questionnumber;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gk_quiz);

        final TextView score = findViewById(R.id.score2);
        questionnumber = findViewById(R.id.DisplayName2);
        submitbutton = findViewById(R.id.next2);
        quitbutton = findViewById(R.id.quit2);
        tv = findViewById(R.id.gk_question);
        radio_g = findViewById(R.id.answerGroup2);
        rb1 = findViewById(R.id.radiobutton21);
        rb2 = findViewById(R.id.radiobutton22);
        rb3 = findViewById(R.id.radiobutton23);
        rb4 = findViewById(R.id.radiobutton24);

        // Display the first question
        tv.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        submitbutton.setOnClickListener(view -> {
            if (radio_g.getCheckedRadioButtonId() == -1) {
                Toast.makeText(gk_quiz.this, "Please select one choice", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton uans = findViewById(radio_g.getCheckedRadioButtonId());
            String ansText = uans.getText().toString();

            if (ansText.equals(answer[flag])) {
                correct++;
                Toast.makeText(gk_quiz.this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                wrong++;
                Toast.makeText(gk_quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
            }

            flag++;
            if (score != null) {
                score.setText(String.valueOf(correct));
            }

            if (flag < questions.length) {
                tv.setText(questions[flag]);
                rb1.setText(options[flag * 4]);
                rb2.setText(options[flag * 4 + 1]);
                rb3.setText(options[flag * 4 + 2]);
                rb4.setText(options[flag * 4 + 3]);
                questionnumber.setText(String.format("%d/%d questions", flag + 1, questions.length));
                radio_g.clearCheck();
            } else {
                marks = correct;
                Intent in = new Intent(gk_quiz.this, gk_result.class);
                startActivity(in);
            }
        });
        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), gk_result.class);
                startActivity(intent1);
            }
        });
    }
}

