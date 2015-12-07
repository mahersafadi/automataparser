package com.automata.grammar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.automata.grammar.left.LeftPart;
import com.automata.grammar.right.RightPartAtomicItem;
import com.automata.grammar.right.RightPartItem;
public class Grammars {
	List<LeftPart> leftPartItems;
	private static Grammars instance;
	public static Grammars getInstance(){
		if(instance == null)
			instance = new Grammars();
		return instance;
	}
	
	private Grammars() {
		this.leftPartItems = new ArrayList<LeftPart>();
	}
	
	public List<LeftPart> getLeftPartItems() {
		return leftPartItems;
	}
	
	public void fillFromFile(String filePath){
		try{
			this.leftPartItems.clear();
			BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
			while(br.ready()){
				String line = br.readLine();
				String [] parts = line.split("::=", 2);
				String leftPartName = parts[0];
				String rightPartName = parts[1];
				leftPartName = leftPartName.trim();
				rightPartName = rightPartName.trim();
				LeftPart currLetPartObj = new LeftPart(leftPartName);
				String rightPartItems [] = rightPartName.split("\\|");
				for(int i=0; i<rightPartItems.length; i++){
					String currRightPartItem = rightPartItems[i];
					RightPartItem currRightItemPartObj = new RightPartItem();
					currRightPartItem = currRightPartItem.trim();
					String [] currRightPartAtumicItems = currRightPartItem.split(" ");
					for(int k = 0; k<currRightPartAtumicItems.length; k++){
						String currRightPartAtumicItem = currRightPartAtumicItems[k];
						currRightPartAtumicItem = currRightPartAtumicItem.trim();
						RightPartAtomicItem rightPartAtomicItemObj = new RightPartAtomicItem(currRightPartAtumicItem);
						currRightItemPartObj.addSimpleItem(rightPartAtomicItemObj);
					}
					currLetPartObj.addRightPartItem(currRightItemPartObj);
				}
				this.leftPartItems.add(currLetPartObj);
			}
			br.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
