package com.automata.stack;

public class Stack {
	private StackItem top;
	public Stack() {
		top = null;
	}
	
	public StackItem getTop() {
		return top;
	}
	
	public void push(String name){
		StackItem  si = new StackItem(name);
		if(top == null)
			top = si;
		else
		{
			si.setNext(top);
			top = si;
		}
	}
	public String pop(){
		if(top != null){
			String temp = top.getStackItemName();
			top = top.getNext();
			return temp;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return top == null?true:false;
	}
}
