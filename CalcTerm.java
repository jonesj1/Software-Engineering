package com.ticetech.calculator;

/**
 * Created by Sarah on 3/24/2017.
 */

public class CalcTerm {
    public boolean positive;
    public ExpressionNode expression;

    public CalcTerm(boolean positive, ExpressionNode expression) {
        super();
        this.positive = positive;
        this.expression = expression;
    }
}