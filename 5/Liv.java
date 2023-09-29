package labb5;

import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;

class Liv extends TreeFrame{
	
	CustomNode root;
	
	static String fileName = "Liv.txt";
	static Scanner sc;

	void initTree() {
		
		String[] rootattr = formatTXT(sc.nextLine());
		List<CustomNode> path = new ArrayList<CustomNode>();
		root = createNode(rootattr[0], rootattr[1], rootattr[2], null, path);		// Sista null kanske ska vara CustomNode[] {root};?
		path.add(root);
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		String curr = root.Levelgetter();
		buildTree(sc.nextLine(), root, path, curr);
	}
	
	CustomNode createNode(String name, String level, String text, CustomNode parent, List<CustomNode> path) {
		return new CustomNode(name, level, text, parent, path);
	}
	
	
	public String[] formatTXT(String line) {
		String[] test = line.split(">");	
		String[] nameLevel = test[0].split(" ");
		
		if (nameLevel.length > 2) {
			String thename = "";
			for (int i = 1; i<nameLevel.length; i++) {
				thename += nameLevel[i] + " ";
			}
			thename = thename.substring(0, thename.length()-1);
			nameLevel = new String[] {nameLevel[0], thename};
		}
		
		String[] name2 = nameLevel[1].split("namn=");
		String level = nameLevel[0].substring(1);		
		String name = name2[1].substring(1, name2[1].length()-1);
		String text = test[1];

		String[] out = {name, level, text};
		
		return out;
	}
	
	void sysExit(String currTag, String curr, CustomNode parent) {
		System.out.println("Wrong closing tag! -> " + currTag + " " + parent.parent.level);
		System.exit(ERROR);
	}
	
	void buildTree(String line, CustomNode parent, List<CustomNode> path, String curr) {
		
		String currTag = line.substring(2, line.length()-1);
		
		if (line.substring(0, 2).equals("</")) {
 			if (!currTag.equals(curr)) {
				sysExit(currTag, curr, null);

			}
 			
			if (sc.hasNextLine()) {
				curr = parent.parent.Levelgetter();
				path.remove(parent);
				buildTree(sc.nextLine(), parent.parent, path, curr);
			}else {
				if (parent.parent != null && !currTag.equals(parent.parent.level)) {
					sysExit(currTag, null, parent);
				}
			}
			
		} else {
			if (sc.hasNextLine()) {
				String[] attr = formatTXT(line);
				curr = attr[1];
				CustomNode child = createNode(attr[0], attr[1], attr[2], parent, path);
				parent.add(child);
				path.add(child);
				buildTree(sc.nextLine(), child, path, curr);
			}else {
				sysExit(parent.level, null, parent);
			}
		}
	}
	
	@Override
	void showDetails(TreePath path) {
		if (path == null)
		    return;
		String info = ((CustomNode) path.getLastPathComponent()).getText();
		JOptionPane.showMessageDialog(this, info);
	}
	
	
	 public static void main(String[] args) {
		if(args.length>0) {
		}
		try {
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		new Liv();
	 }
}
	