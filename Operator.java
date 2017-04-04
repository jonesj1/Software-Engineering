package com.ticetech.calculator;

public class Operator implements Term {

	public char operator;

	Operator(char value) {
		operator = value;
	}

	public char getOperator() {
		return operator;
	}

	@Override
	public boolean isOperand() {
		return false;
	}

	@Override
	public String toString() {
		return "" + operator;
	}

	//evaluates operation
	public static Operand applyOperator(Operator o, Operand second, Operand first) {
		if (o.operator == 'x' || o.operator == '*')
			return new Operand(first.operand * second.operand);
		else if (o.operator == '/')
			return new Operand(first.operand / second.operand);
		else if (o.operator == '%')
			return new Operand(first.operand % second.operand);
		else if (o.operator == '+')
			return new Operand(first.operand + second.operand);
		else
			return new Operand(first.operand - second.operand);
	}

	//checks which operator has a higher precedence
	public static boolean isHigher(Operator value, Operator top) {
		if(getPrecedence(value) > getPrecedence(top))
			return true;
		else
			return false;
	}
	
	//gets a value associated with the precedence of the operator
	private static int getPrecedence(Operator o) {
		if(o.operator == 'x' || o.operator == '*' || o.operator == '/' || o.operator == '%')
			return 3;
		else if(o.operator == '+' || o.operator == '-')
			return 2;
		else
			return 1;
	}
}