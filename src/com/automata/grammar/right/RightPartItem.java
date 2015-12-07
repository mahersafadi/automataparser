package com.automata.grammar.right;
import java.util.*;

import com.automata.stack.Stack;
import com.automata.stack.StackItem;
public class RightPartItem{
	List<RightPartAtomicItem> simpleItems;
	public RightPartItem() {
		simpleItems = new ArrayList<RightPartAtomicItem>();
	}
	public List<RightPartAtomicItem> getSimpleItems() {
		return simpleItems;
	}
	public void addSimpleItem(RightPartAtomicItem r){
		this.simpleItems.add(r);
	}
}
