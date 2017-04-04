package com.ticetech.calculator;

public class Variable implements Term {
	
	String key;
	double value;
	
	public Variable() {
		
	}

	//finds the variable name in line
	public static String readKey(String line, int index) throws Exception {
		int endpoint = 0;
		int start = 0;
		
		//checks spaces throughout substring
		while (line.charAt(start) == ' ')
			start++;
		
		endpoint = start;
		while (line.charAt(endpoint) != ' ' && line.charAt(endpoint) != '=')
			endpoint++;

		for (int i = endpoint; i < index; i++)
			if(line.charAt(i) != ' ')
				return "\0";

		for (int i = start; i < endpoint; i++)
			if(!Character.isJavaIdentifierPart(line.charAt(i)) || !Character.isJavaIdentifierStart(line.charAt(start)))
				return "\0";
		
		return line.substring(start, endpoint);
	}

	public boolean isOperand() {
		return true;
	}

	public String toString() {
		return key;
	}
}
