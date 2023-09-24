package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class EquivalenceClassesTest {
	
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
	 Comparator<Integer> c2 = new Comparator<Integer>()
	 {
	//Checks if greater than 5
	public int compare(Integer x, Integer y)
	 { return x <= 2 == y<= 2 ? 0 : 1; }
	 };
	 
	public LinkedEquivalenceClass listBuilder(int c1, int x1, int x2, int x3, Comparator c) {
		
		LinkedEquivalenceClass l = new LinkedEquivalenceClass(c);
		l.add(c1);
		l.add(x1);
		l.add(x2);
		l.add(x3);
	
		return l;
	}
	
	@Test
	void addTest() {
		
		EquivalenceClasses l = new EquivalenceClasses(c);
		
		l.add(2);
		l.add(4);
		l.add(8);
		
		l.add(5);
		l.add(15);
		l.add(25);
		
		l.add(16);
		
		l.add(-1);
		l.add(-3);		
		assertEquals(3,l.numClasses());
			
	}
	
	@Test
	void sizeTest() {
		
		EquivalenceClasses l = new EquivalenceClasses(c);

		assertEquals(0,l.size());
		
		//Class 1
		l.add(2);
		l.add(4);
		l.add(8);
		
		assertEquals(3, l.size());
		
		l.add(5);
		l.add(15);
		l.add(25);
		
		assertEquals(6, l.size());
		
		l.add(-1);
		l.add(-3);
		
		assertEquals(3,l.numClasses());
	}
	
	@Test
	void contains() {
		EquivalenceClasses l = new EquivalenceClasses(c);

		assertEquals(0,l.size());
		
		//Class 1
		l.add(2);
		l.add(4);
		l.add(8);
		
		assertTrue(l.contains(2));
		assertTrue(l.contains(8));
		
		assertFalse(l.contains(3));
		
		
		
	}
	
	@Test 
	void numClassTest(){
		
		
	}
	

}
