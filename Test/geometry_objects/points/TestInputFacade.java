package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import org.junit.jupiter.api.Test;

import input.InputFacade;
import input.components.FigureNode;
import input.visitor.UnparseVisitor;

class TestInputFacade{

	@Test
	public void testExtractFigure() {
		
		String file = "JSON tests/single_triangle.json";
		
		FigureNode fn;
		
		fn = InputFacade.extractFigure(file);
		
<<<<<<< Updated upstream
		//System.out.println(fn.toString());
=======
		assertTrue(fn instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparse=new UnparseVisitor();
		unparse.visitFigureNode((FigureNode) fn, new AbstractMap.SimpleEntry<StringBuilder, Integer> (sb, 0));
		System.out.println(sb.toString());
		
		System.out.print(fn.toString());
>>>>>>> Stashed changes
	}
}
