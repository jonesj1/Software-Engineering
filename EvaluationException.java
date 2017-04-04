
package com.ticetech.calculator;



/**

 * A simple subclass of RuntimeException that indicates errors when trying to

 * evaluate an expression.

 */

public class EvaluationException extends RuntimeException

{

  private static final long serialVersionUID = 4794094610927358603L;



  /**


   * @param message the message containing the cause of the exception

   */

  public EvaluationException(String message)

  {

    super(message);

  }

}