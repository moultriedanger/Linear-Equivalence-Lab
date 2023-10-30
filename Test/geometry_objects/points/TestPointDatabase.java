package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestPointDatabase extends PointDatabase {

	 public PointDatabase build()
	 {
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
			
	    	return new PointDatabase(ptList);
	}
	
	@Test
	void testGetPoints() {
		PointDatabase pd=build();
	}

	@Test
	void testPointDatabase() {
		fail("Not yet implemented");
	}

	@Test
	void testPointDatabaseListOfPoint() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		fail("Not yet implemented");
	}

	@Test
	void testPut() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNameDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNamePoint() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPointString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPointPoint() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPointDoubleDouble() {
		fail("Not yet implemented");
	}

}
