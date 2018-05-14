package com.example.android.animalworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Instance variables for view elements
    private EditText editTextQ5 = null, editTextQ6 = null;
    private RadioGroup radioGroupQ1, radioGroupQ2 = null;
    private CheckBox checkBoxQ3_1, checkBoxQ3_2, checkBoxQ3_3, checkBoxQ3_4 = null;
    private CheckBox checkBoxQ4_1, checkBoxQ4_2, checkBoxQ4_3, checkBoxQ4_4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);

        radioGroupQ1 = findViewById(R.id.elephantButtonQestions);
        radioGroupQ2 = findViewById(R.id.horsesButtonQestions);

        checkBoxQ3_1 = findViewById(R.id.dogCheckBoxLoving);
        checkBoxQ3_2 = findViewById(R.id.dogCheckBoxCaring);
        checkBoxQ3_3 = findViewById(R.id.dogCheckBoxHate);
        checkBoxQ3_4 = findViewById(R.id.dogCheckBoxProtecting);

        checkBoxQ4_1 = findViewById(R.id.flamingoIndia);
        checkBoxQ4_2 = findViewById(R.id.flamingoJapan);
        checkBoxQ4_3 = findViewById(R.id.flamingoSouthAfrica);
        checkBoxQ4_4 = findViewById(R.id.flamingoSrilanka);

        editTextQ5 = findViewById(R.id.gorillaAnswer);
        editTextQ6 = findViewById(R.id.meerkatAnswer);

    }

    // Solutions for the Quiz Questions
    int Q1_solution = R.id.elephantAge70;     //Question 1 solution.
    int Q2_solution = R.id.horsesBones205;    //Question 2 solution.

    String Q5_solution1 = "400 POUNDS";       //Question 5 Solution if user enters All letters in Caps
    String Q5_solution2 = "400 Pounds";       //Question 5 Solution if user enters Starting Word Capital Letter
    String Q5_solution3 = "400 pounds";       //Question 5 Solution if user enters All small letters

    String Q6_solution1 = "SUN ANGEL";        //Question 6 Solution if user enters All letters in Caps
    String Q6_solution2 = "Sun Angel";        //Question 6 Solution if user enters Starting Word Capital Letter
    String Q6_solution3 = "sun angel";        //Question 6 Solution if user enters All small letters

    int correctQuestions = 0;       //Correct Ans Count
    int wrongQuestions = 0;         //Wrong Ans Count


    // This below code is Radio Button Questions in the Quiz

    private void Question1() {
        if (radioGroupQ1.getCheckedRadioButtonId() == Q1_solution) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question2() {
        if (radioGroupQ2.getCheckedRadioButtonId() == Q2_solution) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }

    // This below code is CheckBox Questions in the Quiz
    private void Question3() {
        if (checkBoxQ3_1.isChecked() && checkBoxQ3_2.isChecked() && !checkBoxQ3_4.isChecked()) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question4() {
        if (checkBoxQ4_1.isChecked() && checkBoxQ4_3.isChecked()) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }


    // This below code is InputText Questions in the Quiz

    private void Question5() {
        if (editTextQ5.getText().toString().equalsIgnoreCase(Q5_solution1) ||
                editTextQ5.getText().toString().equalsIgnoreCase(Q5_solution2) ||
                editTextQ5.getText().toString().equalsIgnoreCase(Q5_solution3)) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }

    private void Question6() {
        if (editTextQ6.getText().toString().equalsIgnoreCase(Q6_solution1) ||
                editTextQ6.getText().toString().equalsIgnoreCase(Q6_solution2) ||
                editTextQ6.getText().toString().equalsIgnoreCase(Q6_solution3)) {
            correctQuestions = correctQuestions + 1;
        } else {
            wrongQuestions = wrongQuestions + 1;
        }
    }


    // THE ABOVE CODE IS CORRECTED BY NAGARAJ


    public void submitQuiz(View view) {
        correctQuestions = 0;
        wrongQuestions = 0;
        Question1();
        Question2();
        Question3();
        Question4();
        Question5();
        Question6();

        if (wrongQuestions == 0) {
            Toast.makeText(getApplicationContext(), R.string.allCorrectAns, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), String.format(getString(R.string.quizResultText), correctQuestions, wrongQuestions), Toast.LENGTH_LONG).show();
        }
    }


    public void shareResult(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.shareResultText), correctQuestions, wrongQuestions));
        startActivity(Intent.createChooser(shareIntent, String.format(getString(R.string.shareResult))));
    }

    public void reset(View view) {
        radioGroupQ1.clearCheck();
        radioGroupQ2.clearCheck();
        checkBoxQ3_1.setChecked(false);
        checkBoxQ3_2.setChecked(false);
        checkBoxQ3_3.setChecked(false);
        checkBoxQ3_4.setChecked(false);
        checkBoxQ4_1.setChecked(false);
        checkBoxQ4_2.setChecked(false);
        checkBoxQ4_3.setChecked(false);
        checkBoxQ4_4.setChecked(false);
        editTextQ5.setText("");
        editTextQ6.setText("");


        Toast.makeText(getApplicationContext(), R.string.reset, Toast.LENGTH_LONG).show();
    }

}
