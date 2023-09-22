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
	 { return x % 7 == y % 7 ? 0 : 1; }
	 };
	 
	Comparator<Integer> c1 = new Comparator<Integer>()
	 {
	//Checks if greater than 5
	public int compare(Integer x, Integer y)
	 { return x >=5 == y>= 5 ? 0 : 1; }
	 };
	 
	public LinkedEquivalenceClass listBuilder(int c1, int x1, int x2, int x3) {
		
		Comparator<Integer> c = new Comparator<Integer>()
		 {
		 // All even integers are 'equivalent'
		// All odd integers are 'equivalent'
		public int compare(Integer x, Integer y)
		 { return x % 2 == y % 2 ? 0 : 1; }
		 };
		
		LinkedEquivalenceClass l = new LinkedEquivalenceClass(c);
		l.add(c1);
		l.add(x1);
		l.add(x2);
		l.add(x3);
	
		return l;
	}
	
	LinkedEquivalenceClass l1 = listBuilder(2, 4, 6, 8);
	
	EquivalenceClasses cl = new EquivalenceClasses(c1);
	
	//cl.add(l1);
	

	@Test
	void addTest() {
		
		
	}

}
