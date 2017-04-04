package com.ticetech.calculator;

public class SymbolTable {
	
	Variable[] array;
	int size;

	public SymbolTable() {
		array = new Variable[10];
		size = 0;
	}
	
	//adds entry to symbol table
	public void add(Variable entry) {
		int index = search(entry.key);
		if (index == -1) {
			if (size == array.length) {
				Variable[] array2 = new Variable[2 * array.length];
				for (int i = 0; i < size; i++)
					array2[i] = array[i];

				array = array2;
			}
			array[size++] = entry;

		}
		else
			array[index] = entry;
	}

	//searches through symbol table, returns index of key if found
	private int search(String key) {
		for (int i = 0; i < size; i++)
			if (array[i].key.equals(key))
				return i;
		return -1;
	}

	//check if key is in the symbol table
	public boolean exists(String key) {
		return search(key) != -1;
	}

	//returns value associated with key
	public double get(String key) {
		return array[search(key)].value;
	}
}
