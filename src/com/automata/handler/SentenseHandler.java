package com.automata.handler;

import org.omg.CORBA.OMGVMCID;

import com.automata.grammar.Grammars;
import com.automata.grammar.right.RightPartItem;
import com.automata.stack.Stack;

public class SentenseHandler {
	

	public StringBuffer handleSentense(String startGrammar, String fileConfigePath) {
		if(fileConfigePath != null && !"".equals(fileConfigePath)){
			Grammars grammars = Grammars.getInstance();
			grammars.fillFromFile(fileConfigePath);
			if (startGrammar != null) {
				if (!"".equals(startGrammar)) {
					StringBuffer stringBuffer = new StringBuffer();
					Stack stack = new Stack();
					stack.push(startGrammar);
					while(!stack.isEmpty()){
						String s = stack.pop();
						int appearInLeft = -1;
						int i = 0;
						int compare = -1;
						while(i<grammars.getLeftPartItems().size() && compare <= 0){
							compare = grammars.getLeftPartItems().get(i).compareTo(s);
							if(compare <= 0)
								i++;
						}
						if(compare <= 0){
							if(!"lambda".equalsIgnoreCase(s))
								stringBuffer.append(s).append(" ");
						}
						else{
							RightPartItem rightPartItem = grammars.getLeftPartItems().get(i).getRandomPartItem();
							for(int j = rightPartItem.getSimpleItems().size()-1; j >= 0; j--){
								stack.push(rightPartItem.getSimpleItems().get(j).getName());
							}
						}
					}
					return stringBuffer;
				}
			}
		}
		return new StringBuffer();
	}
}
