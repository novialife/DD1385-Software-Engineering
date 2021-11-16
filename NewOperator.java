package labb5;

import javax.swing.*;
import javax.swing.tree.*;

	
	class NewOperator extends DefaultMutableTreeNode {
		
		String level;
		String text;
		
		public NewOperator(String name, String level, String text) {
			super(name);
			this.text = text;
			this.level = level;
		}
		
		public String LevelGetter() {
			return level;
		}
		
		public String TextGetter() {
			return text;
		}
		
		
		
	}


