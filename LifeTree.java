package labb5;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;

class LifeTree extends TreeFrame{
	
	NewOperator root;
	
	static Scanner sc;
	static String fileName = "Life.txt";
	
	
	
	
	
	void initTree() {
		
		sc.nextLine(); //få bort xml brus
		
		
		root = createNode (sc.nextLine());
		
		
		treeModel = new DefaultTreeModel(root);
		
		
		tree = new JTree(treeModel);
		
		buildTree(sc.nextLine(), root);
		
	}
	
	NewOperator createNode(String line) {
		
		
		String name = line.substring(line.indexOf("=\"") +2, line.indexOf(">"));

		
		String level = line.substring(line.indexOf("<" )+ 1 , line.indexOf("namn"));
		
		
		String text = line.substring(line.indexOf("> ") +2, line.length());
		
		
		return new NewOperator(name, level, text);
	}
	
	
		
	void buildTree(String line, NewOperator parent) {
		
		if (line.substring(0, 2).equals("</")) {
			if (line.substring(line.indexOf("/") +1, line.indexOf(">")).equals(parent.LevelGetter())) {
				if (sc.hasNextLine()) {
					NewOperator jalla = (NewOperator) parent.getParent();
				buildTree(sc.nextLine(), jalla);
				}
			return;
			}
			
			else {
				System.out.println("nope nope, börja om å avsluta med false din nacas");
				System.out.println(parent.LevelGetter());
				System.out.println(line.substring(line.indexOf("/") +1, line.indexOf(">")));
				System.exit(0);
			}
	}
		else {
			NewOperator child = createNode(line);
			parent.add(child);
			if (sc.hasNextLine()) {
				buildTree (sc.nextLine(), child);
			}
		}
	
	}
	
	void ShowDetails (TreePath path) {
		
		
	}
	
	
}
	