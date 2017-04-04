package com.ticetech.calculator;

public class Queue<T> {

	T[] array;
	private int size = 0;
	private int start = 0;

	public Queue() {
		array = (T[]) new Object[10];
	}

	//adds to front of queue
	public void enqueue(T value) {
		if(size == array.length) {
			T[] newArray = (T[]) new Object[size * 2];
			for(int j = 0; j < size; j++)
				newArray[j] = array[(start + j) % array.length];
			array = newArray;
		}
		
		array[(start + size) % array.length] = value;
		size++;
	}

	//takes from back of queue
	public T dequeue() {
		if(size == 0)
			throw new ArrayIndexOutOfBoundsException();
		T value = array[start];
		start = (start + 1) % array.length;
		size--;
		return value;
	}

	//returns value at index
	public T peek(int index) {
		if(index >= (size + start) % array.length)
			throw new ArrayIndexOutOfBoundsException();
		else
			return array[index];
	}

	//returns front of queue
	public T peekFront() {
		return array[start];
	}

	//returns size
	public int size() {
		return size;
	}

	//returns index of start
	public int start() {
		return start;
	}
}