package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class LinkedEquivalenceTest {
	
	Comparator<Integer> c = new Comparator<Integer>()
	 {
	 // All even integers are 'equivalent'
	// All odd integers are 'equivalent'
	public int compare(Integer x, Integer y)
	 { return x % 2 == y % 2 ? 0 : 1; }
	 };
	 
	Comparator<Integer> c1 = new Comparator<Integer>()
	 {
	//Checks if greater than 5
	public int compare(Integer x, Integer y)
	 { return x >=5 == y>= 5 ? 0 : 1; }
	 };

	public LinkedEquivalenceClass listBuilder(int c1, int x1, int x2, int x3, Comparator<Integer> c) {
		
		LinkedEquivalenceClass l = new LinkedEquivalenceClass(c);
		l.add(c1);
		l.add(x1);
		l.add(x2);
		l.add(x3);
	
		return l;
	}
	
	@Test
	void testClear() {
		LinkedEquivalenceClass list = listBuilder(2, 4, 6, 8, c);
		
		assertEquals("2 | 8 6 4", list.toString());
		
		list.clear();
		
		assertEquals(0, list.size());
	}
	
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
		
		LinkedEquivalenceClass list = listBuilder(2, 4, 6, 8,c);
		
		//Testing if the canonical element is not in the list AND if the compared elements are contained in the list
		assertFalse(list.contains(2));
		assertTrue(list.contains(4));
		assertTrue(list.contains(6));
		
		//Testing if an element that is not equivalent with the canonical does not exist in the list
		assertFalse(list.contains(5));
		assertFalse(list.contains(null));
		assertFalse(list.contains(0));
	}
	@Test
	void testRemove() {
		LinkedEquivalenceClass l = listBuilder(2, 4, 6, 8, c);
				
		assertTrue(l.size() == 4);
		
		l.remove(4);
		l.remove(6);
		
		assertTrue(l.size() == 2);
		
		l.remove(2);
		
		assertTrue(l.size() == 2);
	}
	
	//Does 4 become the new canonical if you remove 2(the canonical)?
	@Test
	void testRemoveCanonical() {
		LinkedEquivalenceClass l = listBuilder(2, 4, 6, 8,c);
		
		assertTrue(l.size() == 4);
		
		assertFalse(l.removeCanonical(4));
		assertFalse(l.removeCanonical(8));
		assertTrue(l.removeCanonical(2));
		
		//System.out.println(l.toString());
	}
	
	//See note
	@Test
	void testBelongs() {
		LinkedEquivalenceClass l = listBuilder(2, 4, 6, 8,c);
		 
		//System.out.println(l.toString());
		assertTrue(l.belongs(2));
		assertFalse(l.belongs(null));
		assertFalse(l.belongs(4));
	}
	
	@Test
	void demoteAndSetCanonical() {
		LinkedEquivalenceClass list = listBuilder(2, 4, 6, 8,c);
		
		assertEquals("2 | 8 6 4", list.toString());
	
		list.demoteAndSetCanonical(-1);
		
		assertEquals("2 | 8 6 4",list.toString());
		
		list.demoteAndSetCanonical(5);
		 
		assertEquals("2 | 8 6 4",list.toString());
		 
		list.demoteAndSetCanonical(20);
		
		assertEquals("20 | 8 6 4",list.toString());
	}
	
	
	
}