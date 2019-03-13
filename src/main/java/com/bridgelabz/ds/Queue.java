package com.bridgelabz.ds;

/**
 * Purpose : Program to create custom queue
 * @author admin1
 * @version 1.0
 * @param <T>
 */
public class Queue<T> {
	
	LinkedList<T> linkedlist;
	
	public Queue() {
		linkedlist = new LinkedList<T>();
	}
	
	public void enqueue(T data) {
		linkedlist.add(data);
	}
	
	public void dequeue() {
		linkedlist.deleteFront();
	}
	
	public boolean isEmpty() {
		return linkedlist.isEmpty();
	}
	
	public int size() {
		return linkedlist.size();
	}
	
	public void print() {
		linkedlist.print();
	}
	
	public T getQueue() {
		return linkedlist.getElement(0);
	}
}
