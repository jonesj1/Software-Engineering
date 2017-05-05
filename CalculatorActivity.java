/**
 * This class is in charge of the Basic Calculator function
 * As buttons are pressed, their value is added to the expression
 * Once the equal button is pressed, the value is calculated and displayed
 */

package com.ticetech.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static com.ticetech.calculator.R.id.enteredText;

public class CalculatorActivity extends AppCompatActivity {


    InfixToPostfix infixToPostfix = new InfixToPostfix();
    double answer;
    boolean equal = false;
    String text;
    int lastX = 0;

    //Connects the interface with this .java class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //When buttons are clicked, this adds their value to the expression
    public void onClicked(View v) throws Exception {

        TextView enteredText = (TextView) findViewById(R.id.enteredText);

        if (equal) {
            text = "";
            equal = false;
        } else
            text = enteredText.getText().toString();

        //Sets the text
        switch (v.getId()) {
            case (R.id.button0):
                enteredText.setText(text + "0");
                lastX = 0;
                break;
            case (R.id.button1):
                enteredText.setText(text + "1");
                lastX = 0;
                break;
            case (R.id.button2):
                enteredText.setText(text + "2");
                lastX = 0;
                break;
            case (R.id.button3):
                enteredText.setText(text + "3");
                lastX = 0;
                break;
            case (R.id.button4):
                enteredText.setText(text + "4");
                lastX = 0;
                break;
            case (R.id.button5):
                enteredText.setText(text + "5");
                lastX = 0;
                break;
            case (R.id.button6):
                enteredText.setText(text + "6");
                lastX = 0;
                break;
            case (R.id.button7):
                enteredText.setText(text + "7");
                lastX = 0;
                break;
            case (R.id.button8):
                enteredText.setText(text + "8");
                lastX = 0;
                break;
            case (R.id.button9):
                enteredText.setText(text + "9");
                lastX = 0;
                break;
            case (R.id.buttonMult):
                enteredText.setText(text + "*");
                lastX = 0;
                break;
            case (R.id.buttonDiv):
                enteredText.setText(text + "/");
                lastX = 0;
                break;
            case (R.id.buttonPlus):
                enteredText.setText(text + "+");
                lastX = 0;
                break;
            case (R.id.buttonMinus):
                enteredText.setText(text + "-");
                lastX = 0;
                break;
            case (R.id.decimal):
                enteredText.setText(text + ".");
                lastX = 0;
                break;
            case (R.id.clear):
                enteredText.setText(null);
                lastX = 0;
                break;
            case (R.id.leftParen):
                enteredText.setText(text + "(");
                lastX = 0;
                break;
            case (R.id.rightParen):
                enteredText.setText(text + ")");
                lastX = 0;
                break;
            case (R.id.delete):
                text = text.substring(0, text.length()-1);
                enteredText.setText(text);
                lastX = 0;
                break;
            case (R.id.mod):
                enteredText.setText(text + "%");
                lastX = 0;
                break;
            case (R.id.x):
                if(lastX == 0){
                    enteredText.setText(text + "x");
                }
                else if(lastX%3 == 0){
                    text = text.substring(0, text.length()-1);
                    enteredText.setText(text + "x");
                }
                else if(lastX%3 == 1){
                    text = text.substring(0, text.length()-1);
                    enteredText.setText(text + "y");
                }
                else if(lastX%3 == 2){
                    text = text.substring(0, text.length()-1);
                    enteredText.setText(text + "z");
                }
                lastX++;
                break;
            case (R.id.xEqual):
                if(text == "")
                    enteredText.setText("x = ");
                else if(text == "z = ")
                    enteredText.setText("x = ");
                else if(text == "x = ")
                    enteredText.setText("y = ");
                else if(text == "y = ")
                    enteredText.setText("z = ");
                lastX = 0;
                break;

            //Calculates and displays answer
            case (R.id.buttonEqual):
                answer = infixToPostfix.calculate(text + ' ');
                if (answer == .12345)
                    enteredText.setText("Error");
                else
                    enteredText.setText("=" + Math.floor(answer * 100) / 100);
                equal = true;
                lastX = 0;
                break;
        }
    }

    //These launch the interfaces and Java classes upon being clicked
    public void startKids(View view) {
        Intent intent = new Intent(this, KidsCalculator.class);
        startActivity(intent);
    }
    public void startAdvanced(View view) {
        Intent intent = new Intent(this, AdvancedCalculator.class);
        startActivity(intent);
    }
    public void startGraphing(View view) {
        Intent intent = new Intent(this, GraphingCalculator.class);
        startActivity(intent);
    }
    public void startQuiz(View view) {
        Intent intent = new Intent(this, QuizCalculator.class);
        startActivity(intent);
    }
}
