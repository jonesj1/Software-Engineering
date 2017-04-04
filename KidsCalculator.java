package com.ticetech.calculator;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class KidsCalculator extends AppCompatActivity {


    InfixToPostfix infixToPostfix = new InfixToPostfix();
    double answer;
    boolean equal = false;
    String text;
    boolean expectNum = true;
    int place = 1;
    double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
    }


    public void numbClick(View v) throws Exception {



        if (place == 1 || place == 3) {

            TextView enteredText;
            //change enteredText to 3 different text boxes: these are 1 and 3
            if (place == 1) {
                clearClick(v);
                enteredText = (TextView) findViewById(R.id.place1);
            }
            else {
                enteredText = (TextView) findViewById(R.id.place3);

            }

            switch (v.getId()) {
                case (R.id.button0):
                    enteredText.setText("0");
                    num=0;
                    break;
                case (R.id.button1):
                    enteredText.setText("1");
                    num=1;
                    break;
                case (R.id.button2):
                    enteredText.setText("2");
                    num=2;
                    break;
                case (R.id.button3):
                    enteredText.setText("3");
                    num=3;
                    break;
                case (R.id.button4):
                    enteredText.setText("4");
                    num=4;
                    break;
                case (R.id.button5):
                    enteredText.setText("5");
                    num=5;
                    break;
                case (R.id.button6):
                    enteredText.setText("6");
                    num=6;
                    break;
                case (R.id.button7):
                    enteredText.setText("7");
                    num=7;
                    break;
                case (R.id.button8):
                    enteredText.setText("8");
                    num=8;
                    break;
                case (R.id.button9):
                    enteredText.setText("9");
                    num=9;
                    break;
            }

            setPic();


            place++;
            if(place==4) {
                calculation();
                enteredText = (TextView) findViewById(R.id.symbol2);
                enteredText.setText("=");
            }

        }
    }


    public void symClick(View v) throws Exception {

        if (place == 2) {

            TextView enteredText = (TextView) findViewById(R.id.place2);

            switch (v.getId()) {
                  case (R.id.buttonMult):
                    enteredText.setText("x");
                      enteredText = (TextView) findViewById(R.id.symbol);
                      enteredText.setText("x");
                    break;
                case (R.id.buttonDiv):
                    enteredText.setText("/");
                    enteredText = (TextView) findViewById(R.id.symbol);
                    enteredText.setText("/");
                    break;
                case (R.id.buttonPlus):
                    enteredText.setText("+");
                    enteredText = (TextView) findViewById(R.id.symbol);
                    enteredText.setText("+");
                    break;
                case (R.id.buttonMinus):
                    enteredText.setText("-");
                    enteredText = (TextView) findViewById(R.id.symbol);
                    enteredText.setText("-");
                    break;
            }



            place++;
        }


    }

    private void setPic(){
        //Determines number of rows and columns needed in grid
        double temp = Math.sqrt(num);
        if((temp % Math.floor(temp)) != 0)
            temp++;
        int rows = (int)temp;
        int cols = rows;
        if(rows*(rows-1) >= num)
            cols--;

        GridLayout gridLayout;
        if(place == 1)
            gridLayout = (GridLayout)findViewById(R.id.pic1);
        else if(place == 3)
            gridLayout = (GridLayout)findViewById(R.id.pic2);
        else
            gridLayout = (GridLayout)findViewById(R.id.pic3);

        gridLayout.removeAllViews();
        gridLayout.setColumnCount(cols);
        gridLayout.setRowCount(rows);

       // Canvas canvas;
        //canvas = new Canvas();
        //gridLayout.set
        ImageView image;
        GridLayout.LayoutParams param;

        int size = gridLayout.getHeight()/rows;

        int r=0;
        int c=0;
        int i=0;

        for(i=0; i<num; i++) {
            image = new ImageView(this);
            image.setImageResource(R.drawable.apple);
            param = new GridLayout.LayoutParams();
            param.height = size;
            param.width = size;
            //param.rightMargin = 5;
            //param.topMargin = 5;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);
            image.setLayoutParams(param);
            gridLayout.addView(image);

            r++;
            if(r>=rows)
                r=0;
            if(r==0)
                c++;

        }

    }

    public void clearClick(View v) throws Exception {

        place = 1;
        TextView enteredText;
        enteredText= (TextView) findViewById(R.id.place1);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.place2);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.place3);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.place4);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.place5);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.place1);
        enteredText.setText(" ");

        enteredText = (TextView) findViewById(R.id.symbol);
        enteredText.setText(" ");
        enteredText = (TextView) findViewById(R.id.symbol2);
        enteredText.setText(" ");

        GridLayout gridLayout = (GridLayout) findViewById(R.id.pic1);
        gridLayout.removeAllViews();
        gridLayout = (GridLayout) findViewById(R.id.pic2);
        gridLayout.removeAllViews();
        gridLayout = (GridLayout) findViewById(R.id.pic3);
        gridLayout.removeAllViews();


    }

    private void calculation() throws Exception{
        TextView equal = (TextView) findViewById(R.id.place4);
        equal.setText("=");

        TextView answer = (TextView) findViewById(R.id.place5);
        TextView place1 = (TextView) findViewById(R.id.place1);
        TextView place2 = (TextView) findViewById(R.id.place2);
        TextView place3 = (TextView) findViewById(R.id.place3);
        String text = place1.getText().toString();
        text += place2.getText().toString();
        text += place3.getText().toString();
        int place5 = (int)infixToPostfix.calculate(text + ' ');

        num = place5;
        setPic();
        answer.setText(Integer.toString(place5));


        place = 1;

    }
}
