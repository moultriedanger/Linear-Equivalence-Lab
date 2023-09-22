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
		
		EquivalenceClasses list = new EquivalenceClasses(c);
		
		LinkedEquivalenceClass l1 = listBuilder(2, 4, 6, 13, c);
		LinkedEquivalenceClass l2 = listBuilder(5, 3, 10, 20, c1);
		
		list.add(l1);
		
		list.add(l2);
		
		
		//System.out.println(list.toString());
	}
	
	@Test
	void sizeTest() {
		
		EquivalenceClasses list = new EquivalenceClasses(c);
		
		LinkedEquivalenceClass l1 = listBuilder(2, 4, 6, 13, c);
		LinkedEquivalenceClass l2 = listBuilder(5, 3, 10, 20, c1);
		LinkedEquivalenceClass l3 = listBuilder(2, 1, -15, 0, c2);
		
		list.add(l1);
		
		list.add(l2);
		
		list.add(l3);
		
		System.out.println(list.toString());
		
		
		assertTrue(list.size()==3);
		//assertFalse(list.size()==1);
	}
	
	@Test
	void indexOfClassTest() {
		
	}

}
