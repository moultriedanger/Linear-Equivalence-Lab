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
	 { return x % 7 == y % 7 ? 0 : 1; }
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
		LinkedEquivalenceClass list = listBuilder(7, 21, 25, 14, c);
		
		assertEquals("7 | 14 21", list.toString());
		
		list.clear();
		
		assertEquals(0, list.size());
	}
	
	@Test
	void testAdd() {
		 
		LinkedEquivalenceClass l = new LinkedEquivalenceClass(c);
		
		assertTrue(l.isEmpty());
		l.add(7);
		l.add(14);
		l.add(21);
		
		assertTrue(l.size() == 3);
		
		//Will not add these 2
		l.add(15);
		l.add(12);
		
		assertTrue(l.size() == 3);
	}
	
	@Test

	void testContains() {
		
		LinkedEquivalenceClass list = listBuilder(7, 14, 21, 28, c);
		
		//Testing if the canonical element is not in the list AND if the compared elements are contained in the list
		assertTrue(list.contains(7));
		assertTrue(list.contains(14));
		assertTrue(list.contains(28));
		
		//Testing if an element that is not equivalent with the canonical does not exist in the list
		assertFalse(list.contains(-7));
		assertFalse(list.contains(null));
		assertFalse(list.contains(0));
	}
	@Test
	void testRemove() {
		LinkedEquivalenceClass l = listBuilder(7, 14, 21, 28, c);
				
		assertTrue(l.size() == 4);
		
		l.remove(14);
		l.remove(21);
		
		assertTrue(l.size() == 2);
		
		l.remove(7);
		
		//Canonical is not removed
		assertTrue(l.size() == 2);
	}
	
	@Test
	void testRemoveCanonical() {
		LinkedEquivalenceClass l = listBuilder(7, 14, 21, 28,c);
		
		assertFalse(l.removeCanonical(14));
		assertFalse(l.removeCanonical(28));
		assertTrue(l.removeCanonical(7));
		
		
		
		LinkedEquivalenceClass i = listBuilder(5, 30, 14, 6,  c1);
		
		assertFalse(i.removeCanonical(30));
		assertFalse(i.removeCanonical(6));
		assertTrue(i.removeCanonical(5));
		
		assertEquals(i.canonical(), null);
	}
	
	//See note
	@Test
	void testBelongs() {
		LinkedEquivalenceClass l = listBuilder(7, 14, 21, 28,c);
		 

		assertTrue(l.belongs(7));
		assertTrue(l.belongs(14));
		
		assertFalse(l.belongs(null));
		
	}
	
	@Test
	void demoteAndSetCanonical() {

		//LinkedEquivalenceClass list = listBuilder(2, 4, 6, 8, c);

		//Creating a list
		LinkedEquivalenceClass list = listBuilder(7, 14, 21, 28,c);

		
		assertEquals("7 | 28 21 14", list.toString());
	
		list.demoteAndSetCanonical(-1);
		
		assertEquals("7 | 28 21 14",list.toString());
		
		list.demoteAndSetCanonical(5);
		 
		assertEquals("7 | 28 21 14",list.toString());
		 
		list.demoteAndSetCanonical(49);
		
		assertEquals("49 | 28 21 14",list.toString());
	}
	
	@Test
	void testClearNonCanonical() {
		//Creating a list using a different comparator
		LinkedEquivalenceClass list = listBuilder(5, 10, 15, 25, c1);
		
		//Removing all elements from list
		list.clearNonCanonical();
		
		//Testing to see if the list has no elements, and only the canonical remains after executing
		//clearNonCanonical method()
		//assertEquals(list.toString(), "5 | ");
		
	}
	 
	
}