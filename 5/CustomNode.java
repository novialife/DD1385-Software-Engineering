package labb5;

import java.util.List;

import javax.swing.*;
import javax.swing.tree.*;


	
	class CustomNode extends DefaultMutableTreeNode {
		
		String level;
		String text;
		CustomNode parent;
		TreePath path;
		
		
		public CustomNode(String name, String level, String text, CustomNode parent, List<CustomNode> path) {
			super(name);
			this.text = text;
			this.level = level;
			this.parent = parent;
			this.path = new TreePath(path);
		}
		
		public String Levelgetter() {
			return level;
		}
		
		public String getText() {
			return text;
		}
	}


