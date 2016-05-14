package com.school.bio4554.algebragame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class DisplayMainGame extends AppCompatActivity {

    static int numq = 3;

    String[] questions = new String[numq];
    String[] answers = new String[numq];

    Random rand = new Random();
    int choice = rand.nextInt(questions.length);
    int score = 0;
    int qit = 0;
    String answer;

    private void insertQuestion(String ques, String ans) {
        questions[qit] = ques;
        answers[qit] = ans;
        qit++;
    }

    private void initializeQuestions() {
        insertQuestion("x+2 = 4", "2");
        insertQuestion("x-5 = 7", "12");
        insertQuestion("2x+8=25", "8.5");
    }




    //  Initialize questions end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_main_game);
        initializeQuestions();
        TextView questionbox = (TextView)findViewById(R.id.textView3);
        questionbox.setText(questions[choice]);
        TextView scorebox = (TextView)findViewById(R.id.textView6);
        scorebox.setText("0");
    }




    public void newQuestion(View view) {
        getRandChoice();
        answer = "";
        TextView checkText = (TextView)findViewById(R.id.textView4);
        checkText.setText("");
        EditText editans = (EditText)findViewById(R.id.editText);
        editans.setText("");
        TextView questionbox = (TextView)findViewById(R.id.textView3);
        questionbox.setText(questions[choice]);
        Button nextbutton = (Button)findViewById(R.id.button2);
        nextbutton.setEnabled(true);
    }

    public void checkAnswer(View view) {
        TextView scorebox = (TextView)findViewById(R.id.textView6);
        TextView checkText = (TextView)findViewById(R.id.textView4);
        EditText editans = (EditText)findViewById(R.id.editText);
        Button nextbutton = (Button)findViewById(R.id.button2);
        answer = editans.getText().toString();
        if(answer.equals(answers[choice])) {
            checkText.setTextColor(Color.GREEN);
            checkText.setText("CORRECT");
            score++;
            scorebox.setText(String.valueOf(score));
        } else if(!(answer.equals(answers[choice]))){
            checkText.setTextColor(Color.RED);
            checkText.setText("INCORRECT");
            if(score > 0) {
                score--;
            }
            scorebox.setText(String.valueOf(score));
        }
        nextbutton.setEnabled(false);
    }

    private void getRandChoice() {
        Random rand = new Random();
        int test;
        do {
            test = rand.nextInt(questions.length);
        } while(test == choice);
        choice = test;
    }


}
