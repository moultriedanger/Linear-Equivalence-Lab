package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void testCompareTo() {
		
		//P1 less than p2
		Point p1 = new Point(0,1);
		Point p2 = new Point(0,2);
		
		assertEquals(-1,p1.compareTo(p2));
		
		Point p3 = new Point(0,1);
		Point p4 = new Point(1,2);
		
		assertEquals(-1,p3.compareTo(p4));
		
		//Same x, lesser y
		Point p5 = new Point(1,1);
		Point p6 = new Point(1,2);
		
		assertEquals(-1,p5.compareTo(p6));
		
		
		//Same x, greater y
		Point p7 = new Point(0,2);
		Point p8 = new Point(0,1);
		
		assertEquals(1,p7.compareTo(p8));
		
		
		//Equal
		Point p9 = new Point(0,2);
		Point p10 = new Point(0,2);
		
		assertEquals(0,p9.compareTo(p10));
	}

	@Test
	void testEqualsObject() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,0);
		
		assertTrue(p1.equals(p2));
		
		//Test different point names
		Point p3 = new Point("point",1,1);
		Point p4 = new Point("point26",1,1);
		
		assertTrue(p3.equals(p4));
		
		assertFalse(p1.equals(p3));
	}

}
