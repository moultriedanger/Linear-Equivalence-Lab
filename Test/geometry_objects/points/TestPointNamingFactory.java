package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TestPointNamingFactory extends PointNamingFactory{

	
	 public PointNamingFactory build()
	 {
		 	//builds a list a PointNamingFactory
			List ptList=new ArrayList<Point>();
			Point pt0=new Point("A", 0,0);
			Point pt1=new Point(1,0);
			Point pt2=new Point("B", 78.237828,4);
			Point pt3=new Point(89,-28.7897);
			Point pt4=new Point(Math.sqrt(2),-3);
			
			ptList.add(pt0);
			ptList.add(pt1);
			ptList.add(pt2);
			ptList.add(pt3);
			ptList.add(pt4);
			
	    	return new PointNamingFactory(ptList);
	  }
	
	@Test
	void testPointNamingFactoryListOfPoint() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		Point ptnot=new Point(-76,9);
		
		assertTrue (pnf.contains(pt0));
		assertTrue (pnf.contains(pt1));
		assertTrue (pnf.contains(pt2));
		assertTrue (pnf.contains(pt3));
		assertTrue (pnf.contains(pt4));
		
		assertEquals (5, pnf.size());
		
		assertTrue (pnf.contains(0, 0));
		assertTrue (pnf.contains(Math.sqrt(2), -3));
		assertFalse (pnf.contains(0, 1));
		
		assertEquals ("A", pnf.get(pt0).getName());
		assertEquals ("*_A", pnf.get(pt1).getName());
		assertEquals ("B", pnf.get(pt2).getName());
		assertEquals ("*_B", pnf.get(pt3).getName());
		assertEquals ("*_C", pnf.get(pt4).getName());
		
		assertFalse (pnf.contains(ptnot));
	}

	@Test
	void testPutPoint() {
		PointNamingFactory pnf=new PointNamingFactory();
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		Point ptnot=new Point(-76,9);
		pnf.put(pt0);
		pnf.put(pt1);
		pnf.put(pt2);
		pnf.put(pt3);
		pnf.put(pt4);
		
		assertTrue (pnf.contains(pt0));
		assertTrue (pnf.contains(pt1));
		assertTrue (pnf.contains(pt2));
		assertTrue (pnf.contains(pt3));
		assertTrue (pnf.contains(pt4));
		
		assertEquals (5, pnf.size());
		assertTrue (pnf.contains(0, 0));
		assertTrue (pnf.contains(Math.sqrt(2), -3));
		assertFalse (pnf.contains(0, 1));
		
		assertFalse (pnf.contains(ptnot));
	}

	@Test
	void testPutDoubleDouble() {
		PointNamingFactory pnf=new PointNamingFactory();
		pnf.put("C", 0, 0);
		pnf.put(Math.sqrt(2), -98);
		pnf.put("A",-6, -7);
		pnf.put(67, 8);
		
		
		assertTrue (pnf.contains(0, 0));
		assertTrue (pnf.contains(Math.sqrt(2),-98));
		assertTrue (pnf.contains(-6, -7));
		assertTrue (pnf.contains(67,8));
		
		assertEquals ("C", pnf.get(0, 0).getName());
		assertEquals ("*_A", pnf.get(Math.sqrt(2),-98).getName());
		assertEquals ("A", pnf.get(-6,-7).getName());
		assertEquals ("*_B", pnf.get(67, 8).getName());
		assertEquals (4, pnf.size());
		
		assertFalse (pnf.contains(5,5));
		assertFalse (pnf.contains(0, 1));
		
	}

	@Test
	void testGetDoubleDouble() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		
		assertEquals (pt0, pnf.get(0, 0));
		assertEquals (pt1, pnf.get(1, 0));
		assertEquals (pt2, pnf.get(78.237828,4));
		assertEquals (pt3, pnf.get(89,-28.7897));
		assertEquals (pt4, pnf.get(Math.sqrt(2),-3));
	}

	@Test
	void testGetPoint() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		Point ptnot=new Point(-76,9);
		
		assertEquals (pt0, pnf.get(pt0));
		assertEquals (pt1, pnf.get(pt1));
		assertEquals (pt2, pnf.get(pt2));
		assertEquals (pt3, pnf.get(pt3));
		assertEquals (pt4, pnf.get(pt4));
	}

	@Test
	void testContainsDoubleDouble() {
		PointNamingFactory pnf=build();
		
		assertTrue (pnf.contains(0, 0));
		assertTrue (pnf.contains(1, 0));
		assertTrue (pnf.contains(78.237828,4));
		assertTrue (pnf.contains(89,-28.7897));
		assertTrue (pnf.contains(Math.sqrt(2),-3));
		
		assertFalse(pnf.contains(-2,-5));
		
	}

	@Test
	void testContainsPoint() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		Point ptnot=new Point(-76,9);
		Point ptnot2=new Point("F", 9.89,89.872);
		
		assertTrue (pnf.contains(pt0));
		assertTrue (pnf.contains(pt1));
		assertTrue (pnf.contains(pt2));
		assertTrue (pnf.contains(pt3));
		assertTrue (pnf.contains(pt4));
		
		assertFalse(pnf.contains(ptnot));
		assertFalse(pnf.contains(ptnot2));
	}

	@Test
	void testGetAllPoints() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		Point ptnot=new Point(-76,9);
		Point ptnot2=new Point("F", 9.89,89.872);
		
		assertEquals (5, pnf.size());
		
		Set<Point> ptSet=pnf.getAllPoints();
		
		assertEquals(pnf.size(), ptSet.size());
		assertTrue(ptSet.contains(pt0));
		assertTrue(ptSet.contains(pt1));
		assertTrue(ptSet.contains(pt2));
		assertTrue(ptSet.contains(pt3));
		assertTrue(ptSet.contains(pt4));
		
		assertFalse(ptSet.contains(ptnot));
		assertFalse(ptSet.contains(ptnot2));
		
		
	}

	@Test
	void testClear() {
		PointNamingFactory pnf=build();
		
		Point pt0=new Point("A", 0,0);
		
		assertEquals (5, pnf.size());
		pnf.clear();
		assertEquals(0, pnf.size());
		pnf.clear();
		assertEquals(0, pnf.size());
		pnf.put(pt0);
		pnf.put(2, 0);
		assertEquals(2, pnf.size());
		
	}

	@Test
	void testSize() {
		PointNamingFactory pnf=new PointNamingFactory();
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(1,0);
		Point pt2=new Point("B", 78.237828,4);
		Point pt3=new Point(89,-28.7897);
		Point pt4=new Point(Math.sqrt(2),-3);
		
		pnf.put(pt0);
		assertEquals(1, pnf.size());
		
		pnf.put(pt1);
		assertEquals(2, pnf.size());
		
		pnf.put(pt2);
		assertEquals(3, pnf.size());
		
		pnf.put(pt3);
		assertEquals(4, pnf.size());
		
		pnf.put(pt4);
		assertEquals(5, pnf.size());
		
		pnf.put(pt1);
		pnf.put(pt0);
		assertEquals(5, pnf.size());
		
		pnf.put("D", 78, 9);
		pnf.put(78, 9);
		assertEquals(6, pnf.size());
		
		pnf.clear();
		assertEquals(0, pnf.size());
		
		pnf.put(65,7);
		assertEquals(1, pnf.size());
		
		
	}

	@Test
	void testToString() {
		PointNamingFactory pnf=new PointNamingFactory();
		Point pt0=new Point("A", 0,0);
		Point pt1=new Point(583,-3);
		Point pt2=new Point(-76.3542,9);
		Point pt3=new Point("C",-48.51,-9.637);
		
		pnf.put(pt0);
		pnf.put(pt1);
		pnf.put(pt2);
		pnf.put(pt3);
		
		assertEquals ("A(0.0, 0.0) *_A(583.0, -3.0) *_B(-76.3542, 9.0) C(-48.51, -9.637) ", pnf.toString());

	}

}
