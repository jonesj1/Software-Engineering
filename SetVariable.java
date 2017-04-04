package com.ticetech.calculator;

public class SetVariable implements ExpressionNodeVisitor

{



  private String name;

  private double value;



  /**

   * Construct the visitor with the name and the value of the variable to set

   * 

   * @param name

   *          the name of the variable

   * @param value

   *          the value of the variable

   */

  public SetVariable(String name, double value)

  {

    super();

    this.name = name;

    this.value = value;

  }



  /**

   * Checks the nodes name against the name to set and sets the value if the two

   * strings match

   */

  public void visit(VariableExpressionNode node)

  {

    if (node.getName().equals(name))

      node.setValue(value);

  }



  /** Do nothing */

  public void visit(ConstantExpressionNode node)

  {}



  /** Do nothing */

  public void visit(AdditionExpressionNode node)

  {}



  /** Do nothing */

  public void visit(MultiplicationExpressionNode node)

  {}



  /** Do nothing */

  public void visit(ExponentiationExpressionNode node)

  {}



  /** Do nothing */

  public void visit(FunctionExpressionNode node)

  {}



}