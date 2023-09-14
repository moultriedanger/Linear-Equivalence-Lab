package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	
	
	@Test
	void testAddToFront() {
		LinkedList list = new LinkedList();
		
		list.addToFront(5);
		list.addToFront(10);
		
		assertTrue(list._size == 2);
		
		//list.clear();
		
		assertTrue(list.contains(10));
		
		
	}

}
