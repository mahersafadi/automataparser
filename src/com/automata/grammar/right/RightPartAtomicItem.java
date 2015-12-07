package com.automata.grammar.right;

public class RightPartAtomicItem implements Comparable<String> {
	private String name;

	public RightPartAtomicItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(String o) {
		try {
			if (this.name.equalsIgnoreCase(o)) {
				return 1;
			}
		} catch (Exception ex) {

		}
		return 0;
	}
}
