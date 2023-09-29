package labb6;

public class NumberedItem<T> {
	
	private int index;
	private T obj;
	
	
	
	public NumberedItem(int index, T obj) {
		if (index < 0) {
			this.index = 0;
		}else {
			this.index = index;
		}
		
		this.obj = obj;
	}
	
	public int compareTo(NumberedItem<Integer> compare) {
		return this.index-compare.index;
	}
	
	public boolean equals(NumberedItem<Integer> compare) {		
		
		if (compare == null) {
			return false;
		}
		
		if (this.obj == compare || this.index == compare.index) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return "Index: " + Integer.toString(this.index) + " Value: " + this.obj;
	}
}
