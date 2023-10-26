package utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import geometry_objects.points.Point;

public class Main {

	public static void main(String[] args) {
		
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,2);
		
		
		
		System.out.println(p1.equals(p2));
	}

}