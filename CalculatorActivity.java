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

    public void onClicked(View v) throws Exception {

        TextView enteredText = (TextView) findViewById(R.id.enteredText);

        //Bugs with positive and negative error entries
        if (equal) {
            text = "";
            equal = false;
        } else
            text = enteredText.getText().toString();

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
            case (R.id.mod):
                enteredText.setText(text + "%");
                break;
            case (R.id.buttonEqual):
                answer = infixToPostfix.calculate(text + ' ');
                if (answer == .12345)
                    enteredText.setText("Error");
                else
                    enteredText.setText("=" + answer);
                equal = true;
                break;
        }
    }

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
       // Intent intent = new Intent(this, QuizCalculator.class);
       // startActivity(intent);
    }
}
