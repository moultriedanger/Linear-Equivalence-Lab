package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceTest {
	
	@Test
	void testAdd() {
		//Test comparator
		Comparator<Integer> c = new Comparator<Integer>()
		 {
		 // All even integers are 'equivalent'
		// All odd integers are 'equivalent'
		public int compare(Integer x, Integer y)
		 { return x % 2 == y % 2 ? 0 : 1; }
		 };
		 
		LinkedEquivalenceClass l = new LinkedEquivalenceClass(c);
		
		assertTrue(l.isEmpty());
		l.add(2);
		
		assertTrue(l.size() == 1);
		
		l.add(8);
		l.add(10);
		
		assertTrue(l.size() == 3);
	}
	
	@Test
	void testContains() {
		//Test comparator
				Comparator<Integer> c = new Comparator<Integer>()
				 {
				 // All even integers are 'equivalent'
				// All odd integers are 'equivalent'
				public int compare(Integer x, Integer y)
				 { return x % 2 == y % 2 ? 0 : 1; }
				 };
		LinkedEquivalenceClass list = new LinkedEquivalenceClass(c);
		
		//Adding elements to a list
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(5);
		
		//Testing if the canonical element is not in the list AND if the compared elements are contained in the list
		assertFalse(list.contains(2));
		assertTrue(list.contains(4));
		assertTrue(list.contains(6));
		
		//Testing if an element that is not equivalent with the canonical does not exist in the list
		assertFalse(list.contains(5));
}
	@Test
	void testBelongs() {
		//Test comparator
		Comparator<Integer> c = new Comparator<Integer>()
		 {
		 // All even integers are 'equivalent'
		// All odd integers are 'equivalent'
		public int compare(Integer x, Integer y)
		 { return x % 2 == y % 2 ? 0 : 1; }
		 	};
		 LinkedEquivalenceClass list = new LinkedEquivalenceClass(c);
		 
		 list.add(2);
		 list.add(4);
		 list.add(6);
		 list.add(8);
		 
		 assertTrue(list.belongs(4));
	}
	
	
	
}