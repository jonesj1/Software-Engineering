/**
 * This class is in charge of the Quiz function on the calculator
 * It walks the user through entering an expression and guessing the answer
 * Upon finishing, the app lets the user know if they were right or not, then allows them to start over
 */

package com.ticetech.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class QuizCalculator extends AppCompatActivity {

    InfixToPostfix infixToPostfix = new InfixToPostfix();
    //Part: num=1 sym=2 num=3 quiz=4
    int part = 1;
    String text, text2;
    String equation = "";
    double answer;
    boolean numEntered = false;

    //Connects the interface with this .java class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

    }

    //When a number is clicked
    public void numClick(View v) {
        if (part == 2 || part == 5)
            return;

        TextView enteredText = (TextView) findViewById(R.id.bottomView);
        text = enteredText.getText().toString();
        numEntered = true;

        //Sets the text
        switch (v.getId()) {
            case (R.id.buttonNeg):
                enteredText.setText(text + "-");
                break;
            case (R.id.button0):
                enteredText.setText(text + "0");
                break;
            case (R.id.button1):
                enteredText.setText(text + "1");
                break;
            case (R.id.button2):
                enteredText.setText(text + "2");
                break;
            case (R.id.button3):
                enteredText.setText(text + "3");
                break;
            case (R.id.button4):
                enteredText.setText(text + "4");
                break;
            case (R.id.button5):
                enteredText.setText(text + "5");
                break;
            case (R.id.button6):
                enteredText.setText(text + "6");
                break;
            case (R.id.button7):
                enteredText.setText(text + "7");
                break;
            case (R.id.button8):
                enteredText.setText(text + "8");
                break;
            case (R.id.button9):
                enteredText.setText(text + "9");
                break;
        }


    }

    //When a symbol is clicked
    public void symbClick(View v) {
        if (part != 2)
            return;

        TextView enteredText = (TextView) findViewById(R.id.topView);
        text = enteredText.getText().toString();

        //Sets the text
        switch (v.getId()) {
            case (R.id.buttonPlus):
                enteredText.setText(text + "+");
                break;
            case (R.id.buttonDiv):
                enteredText.setText(text + "/");
                break;
            case (R.id.buttonMult):
                enteredText.setText(text + "*");
                break;
            case (R.id.buttonMinus):
                enteredText.setText(text + "-");
                break;
        }

        part = 3;

        TextView enteredText2 = (TextView) findViewById(R.id.bottomView);
        enteredText2.setHint("Enter another Number");

    }

    //When the "I'm Done!" button is clicked
    public void nextClick(View v) throws Exception {
        if (part == 2)
            return;
        if(part != 5 && numEntered == false)
            return;
        numEntered = false;

        //Sets the top text and clears the bottom
        TextView enteredText = (TextView) findViewById(R.id.bottomView);
        text = enteredText.getText().toString();
        TextView enteredText2 = (TextView) findViewById(R.id.topView);
        String text2 = enteredText2.getText().toString();
        if (part != 4)
            enteredText2.setText(text2 + text);
        text2 = enteredText2.getText().toString();

        if (text == "")
            return;
        enteredText.setText("");

        if (part == 1)
            enteredText.setHint("Enter an Operation");
        else if (part == 5) {
            enteredText.setHint("Enter a Number");
            enteredText.setText("");
            enteredText2.setText("");
            part = 1;
            return;
        }
        else if (part == 3) {
            enteredText.setHint("Guess the Answer");
            equation = text2;
            answer = infixToPostfix.calculate(equation + ' ');
        }
        //Does comparison  to see if correct
        else if (part == 4) {
            text2 = enteredText2.getText().toString();
            enteredText2.setText(text2 + answer);
            if (answer == .12345)
                enteredText.setText("Error");
            else if (answer == Double.parseDouble(text))
                enteredText.setText("That's Right!");
            else
                enteredText.setText("Better Luck Next Time");
            part = 5;

            return;
        }

        equation += text;
        if (part == 3)
            enteredText2.setText(text2 + '=');
        part++;
    }
}