// Import the necessary classes from labb4X4
import java.util.Iterator;

import x4.*;


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
        
        Composite LittleBag = new Composite("Little Bag", 5);
        LittleBag.Add(new Leaf("Mobil", 1));
        
        Bag.Add(LittleBag);
        
        
        Suitcase.GetChild(1);
        
        System.out.println("-----------X4--------------");

        CompositeX4 Suitcase2 = new CompositeX4("Suitcase", 5);
		Suitcase2.addChild(new LeafX4("Jeans", 1));
        Suitcase2.addChild(new LeafX4("Schampoo", 2));
        
        CompositeX4 Bag2 = new CompositeX4("Bag", 1);
        Bag2.addChild(new LeafX4("Mobil", 1));
        Bag2.addChild(new LeafX4("Kam", 1));
        Suitcase2.addChild(Bag2);
        Suitcase2.addChild(new LeafX4("Towel", 1));
        
        CompositeX4 LittleBag2 = new CompositeX4("Little Bag", 5);
        LittleBag2.addChild(new LeafX4("Mobil", 1));
        
        Bag2.addChild(LittleBag2);
        
        System.out.println("----------------BFS----------------");
        Iterator<ComponentX4> bfs = Suitcase2.iterator();
        while (bfs.hasNext()) {
            System.out.println(bfs.next().toString());
        }
        
        System.out.println("----------------DFS----------------");
        Iterator<ComponentX4> dfs = Suitcase2.deepiIterator();
        while(dfs.hasNext()){
            System.out.println(dfs.next().toString());
        }

	}

}
