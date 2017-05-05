
package com.ticetech.calculator;

import android.widget.TextView;

import java.util.Scanner;

public class InfixToPostfix {


	SymbolTable table = new SymbolTable();
	Queue<Term> inputQueue;
	Variable variableName;
	boolean expectingOperand;
	boolean middleOfOperand;
	int beginning;
	boolean isAssignment;
	Queue<Term> outputQueue;
	Stack<Operator> operatorStack;
	String currentVariable;
	Operator value;
	Stack<Operand> postfixStack;
	int start;


	public  InfixToPostfix(){

        int i;
    }

    public double calculate(String line) {



				expectingOperand = true;
				middleOfOperand = false;
				start = 0;
				
				inputQueue = new Queue<Term>();
				variableName = new Variable();

				beginning = 0;
				isAssignment = false;
				//putting assignment of variable into symbol table
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '=') {
						try {
							variableName.key = Variable.readKey(line, i);
						} catch (Exception e) {
							e.printStackTrace();
						}
						if(variableName.key == null)
								return '\0';
						isAssignment = true;
						beginning = i + 1;
					}
				}

				//puts data in queue
				for (int i = beginning; i < line.length(); i++) {
					if (expectingOperand && !middleOfOperand) {
						if (Character.isDigit(line.charAt(i)) || line.charAt(i) == '.' || line.charAt(i) == '+' || line.charAt(i) == '-') {
							start = i;
							middleOfOperand = true;
						}
						else if (Character.isJavaIdentifierStart(line.charAt(i))) {
							int j = i;
							while (Character.isJavaIdentifierPart(line.charAt(j)))
								j++;
							currentVariable = line.substring(i, j);
							i = j;
							if (table.exists(currentVariable)) {
								inputQueue.enqueue(new Operand(table.get(currentVariable)));
								expectingOperand = false;
							}	
							else
								return '\0';
						}
						
						//search for variable with substring
						else if (line.charAt(i) != '(' && line.charAt(i) != ' ')
                            return '\0';
						
						//add to list
						else if (line.charAt(i) == '(')
							inputQueue.enqueue(new Operator(line.charAt(i)));
					}
					
					//puts operand into queue
					else if (middleOfOperand && !Character.isDigit(line.charAt(i)) && line.charAt(i) != '.') {
						inputQueue.enqueue(new Operand(Double.parseDouble(line.substring(start, i))));
						middleOfOperand = false;
						expectingOperand = false;
					}

					//puts operator into queue
					if (!expectingOperand) {
						if (line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == 'x' || line.charAt(i) == '*' || line.charAt(i) == '/' || line.charAt(i) == '%') {
							if (i == line.length()-1)
                                return .12345;
							inputQueue.enqueue(new Operator(line.charAt(i)));
							expectingOperand = true;
						}
						else if (line.charAt(i) == ')')
							inputQueue.enqueue(new Operator(line.charAt(i)));

						else if (line.charAt(i) != ' ')
                            return .12345;
					}
				}

				if (inputQueue.size() == 0)
                    return .12345;

				//prints out standardized version of expression
				//System.out.print("Standardized infix: ");
				for (int i = 0; i < inputQueue.size(); i++)
					System.out.print(inputQueue.peek(i) + " ");

				outputQueue = new Queue<Term>();
				operatorStack = new Stack<Operator>();

				//converts from infix to postfix
				for (int i = 0; i < inputQueue.size() + inputQueue.start(); i++) {
					//Operand
					if (inputQueue.peekFront().isOperand())
						outputQueue.enqueue(inputQueue.dequeue());
					else {
						value = (Operator) inputQueue.dequeue();

						//Left Parenthesis
						if(value.operator == '(') 
							operatorStack.push(value);

						//Right Parenthesis
						else if(value.operator == ')') {
							while (!(operatorStack.top().operator == '(')) {
								if (operatorStack.size() == 1)
                                    return .12345;
								outputQueue.enqueue(operatorStack.pop());
							} 
							operatorStack.pop();
						}

						//Any Other Operator
						else {
							if(operatorStack.isEmpty())
								operatorStack.push(value);
							else {
								while(operatorStack.size() != 0 && !Operator.isHigher(value, operatorStack.top()))
									outputQueue.enqueue(operatorStack.pop());
								operatorStack.push(value);
							}
						}
					}
				}

				while (operatorStack.size() != 0) {
					if (operatorStack.top().operator == '(')
                        return .12345;
					outputQueue.enqueue(operatorStack.pop());
				}

				
				postfixStack = new Stack<Operand>();

				//evaluate expression
				while (outputQueue.size() != 0) {
					if (outputQueue.peekFront().isOperand())
						postfixStack.push((Operand) outputQueue.dequeue());


					else 
						postfixStack.push(Operator.applyOperator((Operator) outputQueue.dequeue(), postfixStack.pop(), postfixStack.pop()));
				}

				if (isAssignment) {
					variableName.value = postfixStack.top().operand;
					table.add(variableName);
				}
				//print out answer
				return(postfixStack.pop().operand);




	}
}