package labb6;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		TreeVector<Integer> vec = new TreeVector<Integer>();

	    vec.add(0, 5000);
	    vec.add(17, 3000);
	    vec.add(21, 3050);
	    vec.add(3, 10000);
	    vec.add(7, 900);

	    System.out.println(vec);
	    Object[] arr = vec.toArray();
	    List<Integer> values = vec.sortedValues();
	    System.out.println(values);

	    // Test result of toArray()
	    int i = 0;
	    for (Object o : arr) {
	      System.out.print(o);
	      System.out.println(" " + i++);
	    }
	}
}

