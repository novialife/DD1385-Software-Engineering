package labb4;

public class Leaf extends Component {
	
	
	public Leaf(String name, int weight) {
		super(name, weight);
	}
	
	@Override
	public void Add(Component in){
        System.out.println("Cannot add to a leaf");
    }
	
	@Override
    public void Remove(Component in){
        System.out.println("Cannot remove from a leaf");
    }
}
