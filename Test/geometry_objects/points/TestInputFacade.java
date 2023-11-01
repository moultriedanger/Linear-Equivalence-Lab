package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import org.junit.jupiter.api.Test;

import geometry_objects.Segment;
import input.InputFacade;
import input.components.FigureNode;
/*
* Tests the InputFacade
*
* @author Moultrie DangerField, Jalen Livingston, and Jack Patterson
* @date 11/1/2023
*/
class TestInputFacade{

	@Test
	public void testSingleTriangle() {
		
		String file = "JSON tests/single_triangle.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		assertTrue(fn instanceof FigureNode);
		
		PointDatabase pd=geoMap.getKey();
		Point a=new Point("A", 0,0);
		Point b=new Point("B", 1, 1);
		Point c = new Point("C", 1,0);
		Point dummyPoint = new Point("Bob", 0, 4);
		
		assertTrue (a.equals(pd.getPoint(a)));
		assertTrue (b.equals(pd.getPoint(b)));
		assertTrue (c.equals(pd.getPoint(c)));
		
		assertEquals (null, pd.getPoint(dummyPoint));
		
		Set<Segment> segSet = geoMap.getValue();
		Segment ab = new Segment(a, b);
		Segment ac = new Segment(a, c);
		
		Segment ba = new Segment(b, a);
		
		Segment dummySeg = new Segment(a, dummyPoint);
		
		assertTrue (segSet.contains(ab));
		assertTrue (segSet.contains(ac));
		
		//Test undirected edge
		assertTrue (segSet.contains(ba));
		
		assertFalse (segSet.contains(dummySeg));
	}
	@Test
	public void testCollinearLineSegments() {
		
		String file = "JSON tests/collinear_line_segments.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		assertTrue(fn instanceof FigureNode);
		
		PointDatabase pd = geoMap.getKey();
		Point a=new Point("A", 0,0);
		Point b=new Point("B", 4, 0);
		Point c=new Point("C", 9, 0);
		Point d=new Point("D", 11, 0);
		Point f = new Point("F", 26,0);
		
		Point dummyPoint = new Point("Bob", 0, 4);
		
		assertTrue (a.equals(pd.getPoint(a)));
		assertTrue (b.equals(pd.getPoint(b)));
		assertTrue (d.equals(pd.getPoint(d)));
		assertTrue (f.equals(pd.getPoint(f)));
		
		assertFalse (dummyPoint.equals(pd.getPoint(a)));
		
		Set<Segment> segSet = geoMap.getValue();
		Segment ab = new Segment(a,b);
		Segment bc = new Segment(b,c);
		Segment cd = new Segment(c,d);
		Segment af = new Segment(a, f);
		Segment cf = new Segment(c, f);
		
		assertTrue (segSet.contains(ab));
		assertTrue (segSet.contains(bc));
		assertTrue (segSet.contains(cd));
		
		assertFalse (segSet.contains(af));
		assertFalse (segSet.contains(cf));
		
	}

	@Test
	public void testDentedTrapezoid() {
		
		String file = "JSON tests/dentedtrapezoid.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		assertTrue (fn instanceof FigureNode);
		
		PointDatabase pd = geoMap.getKey();
		Point a=new Point("A", 3,3);
		Point b=new Point("B", 8, 3);
		Point c=new Point("C", 6, 4);
		Point d=new Point("D", 8, 5);
		Point e = new Point("E", 5,5);
		
		Point dummyPoint = new Point("Bob", 0, 4);
		
		assertTrue (a.equals(pd.getPoint(a)));
		assertTrue (b.equals(pd.getPoint(b)));
		assertTrue (c.equals(pd.getPoint(c)));
		assertTrue (d.equals(pd.getPoint(d)));
		assertTrue (e.equals(pd.getPoint(e)));
		
		assertFalse (a.equals(pd.getPoint(e)));
		assertFalse (e.equals(pd.getPoint(d)));
		assertFalse (dummyPoint.equals(pd.getPoint(c)));
		
		
		Set<Segment> segSet = geoMap.getValue();
		Segment ab = new Segment(a,b);
		Segment ae = new Segment(a,e);
		Segment bc = new Segment(b,c);
		Segment dummy_b = new Segment(dummyPoint,b);
		
		
		Segment dc = new Segment(d, c);
		
		Segment cd = new Segment(c, d); //This is in the seg list?
		
		assertTrue (segSet.contains(ab));
		assertTrue (segSet.contains(ae));
		assertTrue (segSet.contains(bc));
		
		
		assertTrue (segSet.contains(dc));
		assertTrue (segSet.contains(cd));
		
		
		assertFalse (segSet.contains(dummy_b));
		
	}
//	@Test
//	public void testFullyConnectedIrregularPolygon() {
//		
//		String file = "JSON tests/fully_connected_irregular_polygon.json";
//		
//		FigureNode fn;
//		
//		fn = InputFacade.extractFigure(file);
//		
//		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
//		
//		System.out.println();
//		System.out.println("FullyConnectedIrregularPolygon");
//		System.out.println(geoMap.getKey().toString());
//		System.out.println(geoMap.getValue().toString());
//		
//		
////		System.out.print(fn.toString());
//	}
//	@Test
//	public void testIrregularHexagon() {
//		
//		String file = "JSON tests/irregular_Hexagon.json";
//		
//		FigureNode fn;
//		
//		fn = InputFacade.extractFigure(file);
//		
//		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
//		
//		System.out.println();
//		System.out.println("IrregularHexagon");
//		System.out.println(geoMap.getKey().toString());
//		System.out.println(geoMap.getValue().toString());
//		
//		
////		System.out.print(fn.toString());
//	}
//	@Test
//	public void testParallelogram() {
//		
//		String file = "JSON tests/parallelogram.json";
//		
//		FigureNode fn;
//		
//		fn = InputFacade.extractFigure(file);
//		
//		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
//		
//		System.out.println();
//		System.out.println("Parrallelogram");
//		System.out.println(geoMap.getKey().toString());
//		System.out.println(geoMap.getValue().toString());
//		
//		
////		System.out.print(fn.toString());
//	}
	
	
}
