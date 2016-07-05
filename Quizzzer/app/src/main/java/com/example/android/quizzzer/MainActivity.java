package com.example.android.quizzzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int correct = 0;
    int unanswered = 5;
    String errorMessage = "All question must be answered!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gradeQuiz(View view) {
        grade_q1();
        grade_q2();
        grade_q3();
        grade_q4();
        grade_q5();
        if (unanswered > 0) {
            Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG).show();
            errorMessage = "All question must be answered!\nTry Again.";
            correct = 0;
            unanswered = 5;
            return;
        }
        else {
            Toast.makeText(getApplicationContext(), "You got " + correct + " correct out of 5 questions", Toast.LENGTH_LONG).show();
            correct=0;
        }
    }

    private void grade_q1() {
        RadioGroup rg_q1 = (RadioGroup) findViewById(R.id.q1radio_group);
        RadioButton rb_q1a3 = (RadioButton) findViewById(R.id.q1a3_radio_button_correct);
        //checks if correct answer and increments accordingly
        if (rb_q1a3.isChecked()) {
            correct += 1;
            unanswered -= 1;
        }
        //checks if none were chosen
        else if (rg_q1.getCheckedRadioButtonId() == -1)
            errorMessage += "\nDid not answer Question 1.";
            //incorrect answer
        else {
            unanswered -= 1;
        }

    }

    private void grade_q2() {
        int counter=0;
        CheckBox cb1 = (CheckBox) findViewById(R.id.q2a1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.q2a2_correct1);
        CheckBox cb3 = (CheckBox) findViewById(R.id.q2a3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.q2a4_correct2);
        if(cb1.isChecked())counter+=1;
        if(cb2.isChecked())counter+=1;
        if(cb3.isChecked())counter+=1;
        if(cb4.isChecked())counter+=1;
        //checks if correct answer and increments accordingly
        if (cb2.isChecked() && cb4.isChecked()) {
            correct += 1;
            unanswered -= 1;
        }
        //checks if none were chosen
        else if (counter==0)
            errorMessage += "\nDid not answer Question 2.";
            //incorrect answer
        else {
            unanswered -= 1;
        }

    }

    private void grade_q3() {
        EditText userInput = (EditText) findViewById(R.id.q3a);
        String userInputString = userInput.getText().toString().toLowerCase();
        //checks if correct answer and increments accordingly
        if (userInputString.matches("six day war")) {
            correct += 1;
            unanswered -= 1;
        }
        //checks if no user input
        else if (userInputString.matches(""))
            errorMessage += "\nDid not answer Question 3.";
            //incorrect answer
        else {
            unanswered -= 1;
        }
    }

    private void grade_q4() {
        RadioGroup rg_q4 = (RadioGroup) findViewById(R.id.q4radio_group);
        RadioButton rb_q4a3 = (RadioButton) findViewById(R.id.q4a3_radio_button_correct);
        //checks if correct answer and increments accordingly
        if (rb_q4a3.isChecked()) {
            correct += 1;
            unanswered -= 1;
        }
        //checks if none were chosen
        else if (rg_q4.getCheckedRadioButtonId() == -1)
            errorMessage += "\nDid not answer Question 4.";
            //incorrect answer
        else {
            unanswered -= 1;
        }
    }

    private void grade_q5() {
        EditText userInput = (EditText) findViewById(R.id.q5a);
        String userInputString = userInput.getText().toString().toLowerCase();
        //checks if correct answer and increments accordingly
        if (userInputString.matches("intel")) {
            correct += 1;
            unanswered -= 1;
        }
        //checks if no user input
        else if (userInput.getText().toString().matches(""))
            errorMessage += "\nDid not answer Question 5.";
            //incorrect answer
        else {
            unanswered -= 1;
        }
    }
}
