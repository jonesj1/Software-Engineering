package com.ticetech.calculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.*;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
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
    static boolean greaterThanZero = true;
    static int size = 100;
    final static  Bitmap bitmap = Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
    //static Canvas canvas;
    static Paint paint;

    InfixToPostfix infixToPostfix = new InfixToPostfix();
    double answer;
    boolean equal = false;
    String text;
    boolean expectNum = true;
    int place = 1;
    double num;
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
        //Determines number of rows and columns needed in grid
        GridLayout gridLayout;
        gridLayout = (GridLayout)findViewById(R.id.pic1);
        gridLayout.removeAllViews();
       /*

        for(int i =0;i<size;++i)
            for(int j=0;j<size;++j)
                bitmap.setPixel(i,j, Color.BLACK);*/

        paint = new Paint();


        paint.setColor(Color.RED);

        GraphThread.main(4);

        ImageView image;
        GridLayout.LayoutParams param;
        image = new ImageView(this);

        //setContentView(drawView);
       image.setImageBitmap(bitmap);
       param = new GridLayout.LayoutParams();
        param.height = gridLayout.getHeight();
        param.width = gridLayout.getWidth();
        image.setLayoutParams(param);
        gridLayout.addView(image);

    }


    public static class GraphThread extends Thread
    {

        int threadNumber;
        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void run(int threadNumber,Main function,Canvas canvas)
        {
            float x;
            while(index<size/2)
            {
                x = getIndex();
                if (x  < 0)
                {
                    canvas.drawPoint(size / 2 + x, (float) (size / 2 + function.evaluate(x + "^2")), paint);
                    System.out.println("Thread Number+"+threadNumber+"Index:    "+x);
                }
                else {
                    canvas.drawPoint(size / 2 + x, (float) (size / 2 -function.evaluate(x + "^2")), paint);
                    System.out.println(x);
                }
            }

        }

        public GraphThread()
        {

        }

        public static void main(int threadCount)
        {
            float amount = (float)size/(float)threadCount;
            GraphThread[] tests = new GraphThread[threadCount];
            for(int i=0; i<threadCount;++i)
                tests[i] = new GraphThread();

            for(int i=0; i<threadCount;++i)
                tests[i].run(i,new Main(),new Canvas(bitmap));


            //tests[1].start();
        }

        public  void increment()
        {
            synchronized(lock1)
            {
                //if(index<=0)
                    index += .001f;
                //else
                    //index -= 1f;
            }
        }
        public float getIndex()
        {
            synchronized(lock1)
            {
                float i = index;
                increment();
                return i;
            }
        }

    }

}
