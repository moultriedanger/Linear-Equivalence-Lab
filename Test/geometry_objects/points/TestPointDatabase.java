package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TestPointDatabase extends PointDatabase {

	 public PointDatabase build()
	 {
			List<Point> ptList=new ArrayList<Point>();
			Point pt0=new Point("A", 0,0);
			Point pt1=new Point(1,0);
			Point pt2=new Point("B", 78.237828,4);
			Point pt3=new Point(89,-28.7897);
			Point pt4=new Point(Math.sqrt(2),-3);
			Point pt5=new Point("C", -51.5432,15.0000);
			ptList.add(pt0);
			ptList.add(pt1);
			ptList.add(pt2);
			ptList.add(pt3);
			ptList.add(pt4);
			ptList.add(pt5);
			
	    	return new PointDatabase(ptList);
	}
	
	@Test
	void testGetPoints() {
		//Using created PointDatabase build with content already inside
		PointDatabase pd = build();
		
		Point pt0 = new Point("A", 0,0);
		Point pt1 = new Point(1,0);
		Point pt2 = new Point("B", 78.237828,4);
		Point pt3 = new Point(89,-28.7897);
		Point pt4 = new Point(Math.sqrt(2),-3);
		Point pt5 = new Point("C", -51.5432,15.0000);
		
		assertEquals(6, pd.size());
	
		Set<Point> ptSet = pd.getPoints();
		
		//The following tests below check if all points were distributed to ptSet from getPoints()
		assertTrue(ptSet.contains(pt0));
		assertTrue(ptSet.contains(pt1));
		assertTrue(ptSet.contains(pt2));
		assertTrue(ptSet.contains(pt3));
		assertTrue(ptSet.contains(pt4));
		assertTrue(ptSet.contains(pt5));
	
	}

//	@Test
//	void testPointDatabase() {
//		
//		PointDatabase pd = build();
//		
//	}
//
//	@Test
//	void testPointDatabaseListOfPoint() {
//		PointDatabase pd = build();
//		
//		Point pt0 = new Point("A", 0,0);
//		Point pt1 = new Point(1,0);
//		Point pt2 = new Point("B", 78.237828,4);
//		Point pt3 = new Point(89,-28.7897);
//		Point pt4 = new Point(Math.sqrt(2),-3);
//		Point pt5 = new Point("C", -51.5432,15.0000);
//		
//		assertTrue (pd.contains(pt0));
//		assertTrue (pd.contains(pt1));
//		assertTrue (pd.contains(pt2));
//		assertTrue (pd.contains(pt3));
//		assertTrue (pd.contains(pt4));
//		
//		assertEquals (6, pd.size());
//		
////		assertTrue (pd.contains(0, 0));
////		assertTrue (pd.contains(Math.sqrt(2), -3));
////		assertFalse (pd.contains(0, 1));
//		
////		assertEquals ("A", pd.get(pt0).getName());
////		assertEquals ("*_A", pd.get(pt1).getName());
////		assertEquals ("B", pd.get(pt2).getName());
////		assertEquals ("*_B", pd.get(pt3).getName());
////		assertEquals ("*_C", pd.get(pt4).getName());
//	}
//
	@Test
	void testSize() {
		PointDatabase pd = build();
		
		assertEquals(6, pd.size());
		
	}
	@Test
	void testPut() {
		PointDatabase pd = new PointDatabase();
		
		pd.put("A", 0,0);
		pd.put("B", 1,0);
		pd.put(null, 51, 51);
		pd.put("C", 78.237828,4);
		pd.put("D", 89,-28.7897);
		pd.put("_*E", Math.sqrt(2),-3);
		
		assertEquals (6, pd.size());

	}

	@Test
	void testGetNamePoint() {

		
	}
//
//	@Test
//	void testGetPointString() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetPointPoint() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetPointDoubleDouble() {
//		fail("Not yet implemented");
//	}
//
}
