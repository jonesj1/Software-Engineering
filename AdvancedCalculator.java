/**
 * This class is in charge of the Advanced Calculator function
 * As buttons are pressed, their value is added to the expression
 * Once the equal button is pressed, the value is calculated and displayed
 */

package com.ticetech.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


public class AdvancedCalculator extends AppCompatActivity {

    double answer;
    boolean equal = false;
    String text;
    Main calculate = new Main();

    //Connects the interface with this .java class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
    }

    //When a button is clicked
    public void onClicked(View v) throws Exception {

        TextView enteredText = (TextView) findViewById(R.id.enteredText);

        if (equal) {
            text = "";
            equal = false;
        } else
            text = enteredText.getText().toString();

        //Sets the text and adds it to the expression
        switch (v.getId()) {
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
            case (R.id.buttonMult):
                enteredText.setText(text + "*");
                break;
            case (R.id.buttonDiv):
                enteredText.setText(text + "/");
                break;
            case (R.id.buttonPlus):
                enteredText.setText(text + "+");
                break;
            case (R.id.buttonMinus):
                enteredText.setText(text + "-");
                break;
            case (R.id.decimal):
                enteredText.setText(text + ".");
                break;
            case (R.id.clear):
                enteredText.setText(null);
                break;
            case (R.id.leftParen):
                enteredText.setText(text + "(");
                break;
            case (R.id.rightParen):
                enteredText.setText(text + ")");
                break;
            case (R.id.delete):
                text = text.substring(0, text.length()-1);
                enteredText.setText(text);
                break;
            case (R.id.sin):
                enteredText.setText(text + "sin(");
                break;
            case (R.id.cos):
                enteredText.setText(text + "cos(");
                break;
            case (R.id.tan):
                enteredText.setText(text + "tan(");
                break;
            case (R.id.pi):
                enteredText.setText(text + "pi");
                break;
            case (R.id.asin):
                enteredText.setText(text + "asin(");
                break;
            case (R.id.acos):
                enteredText.setText(text + "acos(");
                break;
            case (R.id.atan):
                enteredText.setText(text + "atan(");
                break;
            case (R.id.log):
                enteredText.setText(text + "log(");
                break;
            case (R.id.ln):
                enteredText.setText(text + "ln(");
                break;
            case (R.id.abs):
                enteredText.setText(text + "abs(");
                break;
            case (R.id.pow):
                enteredText.setText(text + "^(");
                break;

            //Calculates and displays answer
            case (R.id.buttonEqual):
                answer = calculate.evaluate(text);
                if (answer == .12345)
                    enteredText.setText("Error");
                else
                    enteredText.setText("=" + Math.floor(answer * 100000) / 100000);
                equal = true;
                break;
        }
    }
}
