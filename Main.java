package com.ticetech.calculator;

/**
 * Created by Sarah on 3/24/2017.
 */
public class Main {

    public double evaluate(String line)
    {

        Parser parser = new Parser();

        try
        {
            ExpressionNode expr = parser.parse(line);
            expr.accept(new SetVariable("pi", Math.PI));
            return expr.getValue();
        }

        catch (ParserException e)

        {
            System.out.println(e.getMessage());
        }

        catch (EvaluationException e)
        {
            System.out.println(e.getMessage());
        }
    return 0;
    }
}
