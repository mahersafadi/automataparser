package com.automata.grammar.left;

import java.util.*;

import com.automata.grammar.right.RightPartItem;

public class LeftPart implements Comparable<String>{
	private String name;
	private List<RightPartItem> rightPartItems;
	
	public LeftPart(String name) {
		this.name = name;
		this.rightPartItems = new ArrayList<RightPartItem>();
	}
	
	public void addRightPartItem(RightPartItem rightPartItem){
		this.rightPartItems.add(rightPartItem);
	}
	public RightPartItem getRightPartItem(int indx){
		return rightPartItems.get(indx);
	}
	public String getName() {
		return name;
	}
	
	public RightPartItem getRandomPartItem(){
		Random random = new Random();
		return this.rightPartItems.get(random.nextInt(this.rightPartItems.size()));
	}
	
	@Override
	public int compareTo(String o) {
		if(this.getName().equalsIgnoreCase(o))
			return 1;
		else
			return 0;
	}
}
