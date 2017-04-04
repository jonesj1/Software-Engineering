package com.ticetech.calculator;



/**

 * An interface for expression nodes.

 * 

 * Every concrete type of expression node has to implement this interface.

 */

public interface ExpressionNode

{

  /** Node id for variable nodes */

  public static final int VARIABLE_NODE = 1;

  /** Node id for constant nodes */

  public static final int CONSTANT_NODE = 2;

  /** Node id for addition nodes */

  public static final int ADDITION_NODE = 3;

  /** Node id for multiplication nodes */

  public static final int MULTIPLICATION_NODE = 4;

  /** Node id for exponentiation nodes */

  public static final int EXPONENTIATION_NODE = 5;

  /** Node id for function nodes */

  public static final int FUNCTION_NODE = 6;

  public int getType();

  public double getValue();

  public void accept(ExpressionNodeVisitor visitor);



}