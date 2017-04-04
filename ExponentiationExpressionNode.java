package com.ticetech.calculator;

public class ExponentiationExpressionNode implements ExpressionNode

{

  /** the node containing the base */

  private ExpressionNode base;

  /** the node containing the exponent */

  private ExpressionNode exponent;



  /**

   * Construct the ExponentiationExpressionNode with base and exponent

   * @param base the node containing the base

   * @param exponent the node containing the exponent

   */

  public ExponentiationExpressionNode(ExpressionNode base, ExpressionNode exponent)

  {

    this.base = base;

    this.exponent = exponent;

  }



  /**

   * Returns the type of the node, in this case ExpressionNode.EXPONENTIATION_NODE

   */

  public int getType()

  {

    return ExpressionNode.EXPONENTIATION_NODE;

  }


  public double getValue()

  {

    return Math.pow(base.getValue(), exponent.getValue());

  }


  public void accept(ExpressionNodeVisitor visitor)

  {

    visitor.visit(this);

    base.accept(visitor);

    exponent.accept(visitor);

  }





}