package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputFacade;
import input.components.FigureNode;

class TestInputFacade extends InputFacade{

	@Test
	public void testExtractFigure(String file) {
		
		file = "JSON tests/single_triangle.json";
		
		FigureNode fn;
		
		fn = extractFigure(file);
		
		//System.out.println(fn.toString());
	}
}
