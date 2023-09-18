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
	
	

}
