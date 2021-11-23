package labb6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeVector <E extends Comparable<E>> extends TreeMap<Integer, E> implements SparseVec<E> {
	
	
	public TreeVector() {
		super();
	}
	
	@Override
	public void add(E elem) {
		int index = this.minIndex();
		
		for (; this.get(index) != null; ) {
			index++;
		}
		this.put(index, elem);
	}

	
	@Override
	public void add(int pos, E elem) {
		if (pos < 0 ) {pos = 0;}
		this.put(pos, elem);
	}

	@Override
	public int indexOf(E elem) {
		Set<Entry<Integer, E>> allElems = this.entrySet();
		
		for (Entry<Integer, E> e: allElems) {
			if (e.getValue().equals(elem)) {
				return e.getKey();
			}
		}
		return -1;
	}

	@Override
	public void removeAt(int pos) {
		E elem = this.get(pos);
		this.remove(elem);
	}

	@Override
	public void removeElem(E elem) {
		this.remove(elem);
	}

	@Override
	public int size() {
		return super.size();
	}

	@Override
	public int minIndex() {
		try {
			return this.firstKey();
		}catch (Exception e) {
			return -1;
		}
	}
	@Override
	public int maxIndex() {
		try {
			return this.lastKey();
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public E get(int pos) {
		return super.get(pos);
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[this.maxIndex()+1];
		
		for (int i = 0; i <= this.maxIndex(); i++ ) {
			
			if (this.get(i) != null) {
				arr[i] = this.get(i);
			}else {
				arr[i] = null;
			}
		}
		return arr;
	}

	@Override
	public List<E> sortedValues() {
		List<E> out = new ArrayList<E>(this.values());
		Collections.sort(out);
		return out;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder(this.size());
		
		Set<Entry<Integer, E>> allElems = this.entrySet();
		for (Entry<Integer, E> e: allElems) {
			output.append("Key: ");
			output.append(e.getKey());
			output.append(" Value: ");
			output.append(e.getValue());
			output.append("\n");
			}
		
		return output.toString();
	}
	
}
