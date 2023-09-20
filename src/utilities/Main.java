package utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {

	public static void main(String[] args) {
		
		LinkedList list2 = new LinkedList();
		
		//Adding elements to a list
		list2.addToFront(50);
		list2.addToBack(51);
		list2.addToBack(52);
		
		System.out.println(list2.toString());
	}

}
