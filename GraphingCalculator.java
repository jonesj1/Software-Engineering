/**
 * This class is in charge of the Graphing Calculator function on the calculator
 * This graphs a static function
 */

package com.ticetech.calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.*;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class GraphingCalculator extends AppCompatActivity {
    static int size = 100;
    Bitmap bitmap = Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    static Paint paint;
    static Paint paint2;

    private static float index = -50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

    }

    public void setPic(View v){


        GridLayout gridLayout;
        gridLayout = (GridLayout)findViewById(R.id.pic1);
        gridLayout.removeAllViews();

        paint = new Paint();
        paint.setColor(Color.RED);
        paint2 = new Paint();
        paint2.setColor(Color.BLACK);

        switch (v.getId()) {
            case (R.id.x):
                run1(new Main(),canvas);
                break;
            case (R.id.x2):
                run2(new Main(),canvas);
                break;
            case (R.id.x3):
                run3(new Main(),canvas);
                break;
           case (R.id.sin):
               run4(new Main(),canvas);
                break;
            case (R.id.cos):
                run5(new Main(),canvas);
                break;
            case (R.id.tan):
                run6(new Main(),canvas);
                break;

        }



        ImageView image;
        GridLayout.LayoutParams param;
        image = new ImageView(this);


        image.setImageBitmap(bitmap);
        param = new GridLayout.LayoutParams();
        param.height = gridLayout.getHeight();
        param.width = gridLayout.getWidth();
        image.setLayoutParams(param);
        gridLayout.addView(image);

    }



    public void run1(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .1f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            canvas.drawPoint(size / 2 + x, (float) (size / 2 - function.evaluate(x+"")), paint);
        }
    }
    public void run2(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .05f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            if (x < 0) {
                canvas.drawPoint(size / 2 + 4*x, (float) (size / 2 + function.evaluate("4*(" + x + "^2)")), paint);
            } else {
                canvas.drawPoint(size / 2 + 4*x, (float) (size / 2 - function.evaluate("4*(" + x + "^2)")), paint);
            }
        }
    }
    public void run3(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .05f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            canvas.drawPoint(size / 2 + 4*x, (float) (size / 2 - function.evaluate("4*(" + x + "^3)")), paint);
        }
    }
    public void run4(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .05f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            canvas.drawPoint((float) (size / 2 + 4 * x), (float) (size / 2 - function.evaluate("(4)*sin(" + x + ")")), paint);
        }
    }
    public void run5(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .05f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            canvas.drawPoint((float) (size / 2 + 4 * x), (float) (size / 2 - function.evaluate("(4)*cos(" + x + ")")), paint);
        }
    }
    public void run6(Main function,Canvas canvas) {
        float x;
        while (index < size / 2) {
            x = index;
            index += .05f;

            canvas.drawPoint(size/2+x, size/2, paint2);
            canvas.drawPoint(size/2, size/2+x, paint2);

            canvas.drawPoint((float) (size / 2 + 8 * x), (float) (size / 2 - function.evaluate("(8)*tan(" + x + ")")), paint);
        }
    }

}

