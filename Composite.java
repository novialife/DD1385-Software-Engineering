package labb4;

import java.util.List;
import java.util.ArrayList;

public class Composite extends Component {
	public List<Component> children = new ArrayList<>();
	

	public Composite(String name, int weight) {
		super(name, weight);
	}
	
	@Override
	public int getWeight() {
		
		for (Component child: children) {
			weight += child.getWeight();
		}
		return weight;
	}
	
	@Override
	public String toString() {
		String childrens = "";
		for (Component child: children) {
			childrens += " " + child.toString();
		}
		return name + ": " + childrens;
	}
	
	@Override
	public void Add(Component in) {
		this.children.add(in);
	}

	@Override
	public void Remove(Component in) {
		this.children.remove(in);
	}

	@Override
	public void GetChild(int in) {
    	System.out.println("-" + toString() + " " + " weight: " + Integer.toString(getWeight()));
		for (Component child: children) {
			child.GetChild(in + 2);
		}
	}
}
