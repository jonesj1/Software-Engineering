package com.ticetech.calculator;

public class Stack<T> {

	T[] array;
	private int size = 0;

	public Stack() {
		array = (T[]) new Object[10];
	}

	//adds to top of stack
	public void push(T value) {
		if (size == array.length) {
			T[] newArray = (T[]) new Object[size * 2];
			for(int j = 0; j < size; j++)
				newArray[j] = array[j];
			array = newArray;
		}
		array[size] = value;
		size++;
	}

	//takes from top of stack
	public T pop() {
		if (size == 0)
			throw new IndexOutOfBoundsException();  //ISSUES HERE
		size--;
		return array[size];
	}

	//returns value at index
	public T peek(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException();
		return array[index];
	}

	//returns value at top
	public T top() {
		if(size == 0)
			throw new IndexOutOfBoundsException();
		return array[size - 1];
	}

	//checks if stack is empty
	public boolean isEmpty() {
		return (size == 0);
	}

	//returns size of stack
	public int size() {
		return size;
	}

}