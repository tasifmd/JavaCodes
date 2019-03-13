package com.bridgelabz.ds;

import com.bridgelabz.ds.LinkedList;

/**
 * Purpose : Create custom class 
 * @author : Tasif Mohammed
 * @version : 1.0
 * @param <T>
 */
public class Stack<T> {
	
	LinkedList<T> linklist;
	
	public Stack(){
		linklist = new LinkedList<T>();
	}
	
	public void push(T data){
		linklist.insertAtLast(data);
	}
	
	public void pop() {
		linklist.deleteAtLast();
	}
	public boolean isEmpty() {
		return linklist.isEmpty();
	}
	
	public int size() {
		return linklist.size();
	}
	
	public void print() {
		linklist.print();
	}
}
