package com.automata.stack;

public class StackItem {
	private String stackItemName;
	private StackItem next;
	
	public StackItem(String name) {
		stackItemName = name;
		next = null;
	}
	public StackItem getNext() {
		return next;
	}
	public void setNext(StackItem next) {
		this.next = next;
	}
	public String getStackItemName() {
		return stackItemName;
	}
}
