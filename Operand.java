package com.ticetech.calculator;

public class Operand implements Term{

	public double operand;

	public Operand(double value) {
		operand = value;
	}

	@Override
	public boolean isOperand() {
		return true;
	}

	@Override
	public String toString() {
		return Double.toString(operand);
	}

}
