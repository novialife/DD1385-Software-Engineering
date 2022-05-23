package labb4;

public class main {

	public static void main(String[] args) {
		Composite Suitcase = new Composite("Suitcase", 5);
		Suitcase.Add(new Leaf("Jeans", 1));
        Suitcase.Add(new Leaf("Schampoo", 2));
        
        
        Composite Bag = new Composite("Bag", 1);
        Bag.Add(new Leaf("Mobil", 1));
        Bag.Add(new Leaf("Kam", 1));
        Suitcase.Add(Bag);
        Suitcase.Add(new Leaf("Towel", 1));
        
        Suitcase.GetChild(1);
	}

}
