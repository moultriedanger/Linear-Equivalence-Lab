package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Set;
import java.util.AbstractMap.SimpleEntry;

import org.junit.jupiter.api.Test;

import geometry_objects.Segment;
import input.InputFacade;
import input.components.FigureNode;
import input.visitor.UnparseVisitor;

class TestInputFacade{

	@Test
	public void testSingleTriangle() {
		
		String file = "JSON tests/single_triangle.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("SingleTriangle");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testCollinearLineSegments() {
		
		String file = "JSON tests/collinear_line_segments.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("CollinearLineSegments");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testCrossingSymmetricTriangle() {
		
		String file = "JSON tests/crossing_symmetric_triangle.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("CrossingSymmetricTriangle");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testDentedTrapezoid() {
		
		String file = "JSON tests/dentedtrapezoid.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("DentedTrapezoid");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testFullyConnectedIrregularPolygon() {
		
		String file = "JSON tests/fully_connected_irregular_polygon.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("FullyConnectedIrregularPolygon");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testIrregularHexagon() {
		
		String file = "JSON tests/irregular_Hexagon.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("IrregularHexagon");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
	@Test
	public void testParallelogram() {
		
		String file = "JSON tests/parallelogram.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println();
		System.out.println("Parrallelogram");
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
}
