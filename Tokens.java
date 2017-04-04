package com.ticetech.calculator;

public class Tokens

{

  /** Tokens id for the epsilon terminal */

  public static final int EPSILON = 0;

  /** Tokens id for plus or minus */

  public static final int PLUSMINUS = 1;

  /** Tokens id for multiplication or division */

  public static final int MULTDIV = 2;

  /** Tokens id for the exponentiation symbol */

  public static final int RAISED = 3;

  /** Tokens id for function names */

  public static final int FUNCTION = 4;

  /** Tokens id for opening brackets */

  public static final int OPEN_BRACKET = 5;

  /** Tokens id for closing brackets */

  public static final int CLOSE_BRACKET = 6;

  /** Tokens id for numbers */

  public static final int NUMBER = 7;

  /** Tokens id for variable names */

  public static final int VARIABLE = 8;



  /** the token identifier */

  public final int token;

  /** the string that the token was created from */

  public final String sequence;

  /** the position of the token in the input string */

  public final int pos;



  /**

   * Construct the token with its values

   * @param token the token identifier

   * @param sequence the string that the token was created from

   * @param pos the position of the token in the input string

   */

  public Tokens(int token, String sequence, int pos)

  {

    super();

    this.token = token;

    this.sequence = sequence;

    this.pos = pos;

  }



}