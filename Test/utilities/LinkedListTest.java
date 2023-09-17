package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void isEmptyTest() {
		LinkedList list = new LinkedList();
		
		assertTrue(list.isEmpty());
	}
	
	@Test
	void clearTest() {
		LinkedList list = new LinkedList();
		
		assertTrue(list.isEmpty());
		
		list.addToFront(5);
		list.addToFront(10);
		list.addToFront(15);
		
		list.clear();
		assertTrue(list.size() == 0);
	}
	
	@Test
	void testAddToFront() {
		//Test adding 3 elements
		LinkedList list = new LinkedList();
		
		list.addToFront(5);
		list.addToFront(10);
		list.addToFront(15);
		//Smth happening to other elements???
		
		assertTrue(list._size == 3);
		
		assertEquals("15 10 5 ", list.toString());
		
		assertTrue(list.contains(5));
		assertTrue(list.contains(15));
	}
	
	
	@Test
	void containsTest() {
		LinkedList list = new LinkedList();
		
		list.addToFront(5);
		list.addToFront(10);
		
		assertTrue(list.contains(10));
		assertTrue(list.contains(5));
	}
	
	@Test
	void removeTest() {
		//Need test for remove on empty list
		LinkedList list = new LinkedList();
		
		list.addToFront(10);
		list.addToFront(12);
		list.addToFront(20);
		
		
		list.remove(10);
		list.remove(20);
		
		//Return false for element not in the list
		assertFalse(list.remove(23));
		
		assertTrue(list.size() == 1);
		assertFalse(list.contains(10));
		
		assertEquals("12 ", list.toString());
	}
	
	@Test
	void addToBackTest() {
		LinkedList list = new LinkedList();
		list.addToFront(10);
		
		list.addToBack(12);
		
		list.addToBack(5);
		
		System.out.println(list.toString());
		
		assertTrue(list.size() == 3);
	}
	
	@Test
	void toStringTest() {
		LinkedList list = new LinkedList();
		
		
		list.addToFront(10);
		list.addToFront(12);
		
		assertEquals("12 10 ", list.toString());
	}

}
