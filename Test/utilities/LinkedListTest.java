package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTest {

	@Test
	void isEmptyTest() {
		//Creating an empty list
		LinkedList list = new LinkedList();
		
		//Testing if isEmpty() method returns true when list has no elements
		assertTrue(list.isEmpty());
		

		//Creating a list
		LinkedList list2 = new LinkedList();
		
		//Adding elements to a list
		list2.addToFront(50);
		list2.addToBack(51);
		list2.addToBack(52);
		
		//Testing if isEmpty() method returns false when list contains elements
		assertFalse(list2.isEmpty());
	}
	
	@Test
	void clearTest() {
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Checking if list is empty
		assertTrue(list.isEmpty());
		
		//Adding elements to a list
		list.addToFront(5);
		list.addToFront(10);
		list.addToFront(15);
		
		//Testing if the clear() method functions appropriately and if the size of the list sets to 0
		list.clear();
		assertTrue(list.size() == 0);
	}
	
	@Test
	void testAddToFront() {
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Adding elements to a list
		list.addToFront(5);
		list.addToFront(10);
		list.addToFront(15);
		//Smth happening to other elements???
		
		//Testing if the size of the list corresponds to the number of added elements
		assertTrue(list._size == 3);
		
		//Testing if the appropriate order of the list displays 
		assertEquals("15 10 5 ", list.toString());
		
		//Testing if the list has these specific elements
		assertTrue(list.contains(5));
		assertTrue(list.contains(15));
	}
	
	
	@Test
	void containsTest() {
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Adding elements to a list
		list.addToFront(5);
		list.addToFront(10);
		list.addToBack(50);
		
		//Testing the contains(T target) method returns true for the specific elements existing in the list
		assertTrue(list.contains(10));
		assertTrue(list.contains(5));
		assertTrue(list.contains(50));
		
		//Testing the contains(T target) method returns false for when an element does not exist in the list
		assertFalse(list.contains(3));
		
		//Testing the contains(T target) method returns false for when a list is empty
		assertFalse(list.contains(500));
	}
	
	@Test
	void removeTest() {
		
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Adding elements to a list
		list.addToFront(10);
		list.addToFront(12);
		list.addToFront(20);
		
		//Removing elements from a list
		list.remove(10);
		list.remove(20);
		
		//Testing if remove(T target) method returns false for element not in the list
		assertFalse(list.remove(23));
		
		//Testing if element(s) have been removed and do not exist in the list anymore
		assertTrue(list.size() == 1);
		assertFalse(list.contains(10));
		
		//Testing if elements that were not removed from the list are still in the list
		assertEquals("12 ", list.toString());
		
		
		//Creating an empty list
		LinkedList emptyList = new LinkedList();
		
		//Testing if remove(T object) method will return false on an empty list
		assertFalse(emptyList.remove(51));
		
		
	}
	
	@Test
	void addToBackTest() {
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Adding elements to a list
		list.addToFront(10);
		list.addToBack(12);
		list.addToBack(5);
		

		//Testing if the list contains the added elements

		//System.out.println(list.toString());
		
		assertTrue(list.size() == 3);
		
		//Testing if the elements are in an expected order set
		assertEquals("10 12 5 ", list.toString());
		
		
		//Creating an additional list
		LinkedList list2 = new LinkedList();
		
		//Adding elements to a list
		list2.addToBack(51);
		list2.addToFront(50);
		list2.addToBack(52);
		list2.addToFront(49);
		
		//Testing if the elements of this list are also in an expected order
		assertEquals("49 50 51 52 ", list2.toString());
		
	}
	
	@Test
	void toStringTest() {
		//Creating a list
		LinkedList list = new LinkedList();
		
		//Adding elements to a list
		list.addToFront(10);
		list.addToFront(12);
		
		//Testing for if a list of elements will display with the toString method
		assertEquals("12 10 ", list.toString());
		
		
		//Creating an empty list
		LinkedList emptyList = new LinkedList();
		//Testing for when list is empty, a message saying the list is empty will display
		assertEquals("List is empty", emptyList.toString());
	}
	
	@Test
	
	void reverseTest() {
		LinkedList list = new LinkedList();
		
		
		list.addToBack(10);
		list.addToBack(12);
		list.addToBack(15);
		
		list.reverse();
		
		//System.out.print("rev" + list.toString());
		
		
	}

}
