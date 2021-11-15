package labb4;

public abstract class Component {
	public String name;
	public int weight;
	
	
	public Component(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		return name;
	}
	
	public void Add(Component in) {
	}
	public void Remove(Component in) {
	}
	public void GetChild(int in) {
    	System.out.println("-" + toString() + " " + " weight: " + Integer.toString(getWeight()));
	}
}