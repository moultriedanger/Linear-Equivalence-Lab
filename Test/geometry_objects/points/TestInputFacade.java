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
	public void testExtractFigure() {
		
		String file = "JSON tests/single_triangle.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
		SimpleEntry<PointDatabase, Set<Segment>> geoMap=(SimpleEntry<PointDatabase, Set<Segment>>) InputFacade.toGeometryRepresentation(fn);
		
		System.out.println(geoMap.getKey().toString());
		System.out.println(geoMap.getValue().toString());
		
		
//		System.out.print(fn.toString());
	}
//	@Test
//	public void testToGeometryRepresentation() {
//		
//	}
}
