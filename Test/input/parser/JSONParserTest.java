package input.parser;


import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import input.components.ComponentNode;
import input.components.FigureNode;
import input.exception.ParseException;

class JSONParserTest
{
	public static ComponentNode runFigureParseTest(String filename)
	{
		JSONParser parser = new JSONParser();

		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filename);
		
		return parser.parse(figureStr);
	}
	
	@Test
	void empty_json_string_test()
	{
		JSONParser parser = new JSONParser();

		assertThrows(ParseException.class, () -> { parser.parse("{}"); });
	}

	@Test
	void single_triangle_test()
	{
		//
		// The input String ("single_triangle.json") assumes the file is
		// located at the top-level of the project. If you move your input
		// files into a folder, update this String with the path:
		//                                       e.g., "my_folder/single_triangle.json"
		//
		ComponentNode node = JSONParserTest.runFigureParseTest("Lib/single_triangle.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		node.unparse(sb, 0);
		System.out.println(sb.toString());
	}
//	@Test
//	void collinear_line_segments_test()
//	{
//		//
//		// The input String ("single_triangle.json") assumes the file is
//		// located at the top-level of the project. If you move your input
//		// files into a folder, update this String with the path:
//		//                                       e.g., "my_folder/single_triangle.json"
//		//
//		ComponentNode node = JSONParserTest.runFigureParseTest("Lib/collinear_line_segments.json");
//
//		assertTrue(node instanceof FigureNode);
//		
//		StringBuilder sb = new StringBuilder();
//		node.unparse(sb, 0);
//		System.out.println(sb.toString());
//	}
	@Test
	void crossing_symmetric_triangle_test()
	{
		//
		// The input String ("single_triangle.json") assumes the file is
		// located at the top-level of the project. If you move your input
		// files into a folder, update this String with the path:
		//                                       e.g., "my_folder/single_triangle.json"
		//
		ComponentNode node = JSONParserTest.runFigureParseTest("Lib/crossing_symmetric_triangle.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		node.unparse(sb, 0);
		System.out.println(sb.toString());
	}
	@Test
	void fully_connected_irregular_polygon_test()
	{
		//
		// The input String ("single_triangle.json") assumes the file is
		// located at the top-level of the project. If you move your input
		// files into a folder, update this String with the path:
		//                                       e.g., "my_folder/single_triangle.json"
		//
		ComponentNode node = JSONParserTest.runFigureParseTest("Lib/fully_connected_irregular_polygon.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		node.unparse(sb, 0);
		System.out.println(sb.toString());
	}
}
