package com.ticetech.calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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

public class GraphingCalculator extends AppCompatActivity {



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
        setContentView(R.layout.activity_graphing_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

    }

    public void setPic(View v){
        //Determines number of rows and columns needed in grid


        GridLayout gridLayout;
        gridLayout = (GridLayout)findViewById(R.id.pic1);
        gridLayout.removeAllViews();

        Bitmap bitmap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        for(int i =0;i<500;++i)
            for(int j=0;j<500;++j)
                bitmap.setPixel(i,j, Color.RED);

        Canvas canvas = new Canvas(bitmap);

        ImageView image;
        GridLayout.LayoutParams param;




            image = new ImageView(this);
            image.setImageBitmap(bitmap);
            param = new GridLayout.LayoutParams();
            param.height = bitmap.getHeight();
            param.width = bitmap.getWidth();
            param.setGravity(Gravity.CENTER);
            image.setLayoutParams(param);
            gridLayout.addView(image);



    }

}
