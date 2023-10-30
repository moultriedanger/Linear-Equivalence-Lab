package input;

import static org.junit.jupiter.api.Assertions.*;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import geometry_objects.Segment;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.PointNodeDatabase;
import input.components.SegmentNodeDatabase;
import input.components.PointNode;
import input.components.SegmentNode;
import input.parser.JSONParser;

public class InputFacade
{
	/**
	 * A utility method to acquire a figure from the given JSON file:
	 *     Constructs a parser
	 *     Acquries an input file string.
	 *     Parses the file.
     *
	 * @param filepath the path/name defining the input file
	 * @return a FigureNode object corresponding to the input file.
	 */
	public static FigureNode extractFigure(String filepath)
	{

		GeometryBuilder g=new GeometryBuilder();
		 
		JSONParser parser=new JSONParser(g);
	
		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filepath);
		
		return (FigureNode) parser.parse(figureStr);
	}
	
	/**
	 * 1) Convert the PointNode and SegmentNode objects to a Point and Segment objects 
	 *    (those classes have more meaningful, geometric functionality).
	 * 2) Return the points and segments as a pair.
     *
	 * @param fig -- a populated FigureNode object corresponding to a geometry figure
	 * @return a point database and a set of segments
	 */
	public static Map.Entry<PointDatabase, Set<Segment>> toGeometryRepresentation(FigureNode fig)
	{
		PointNodeDatabase pnd=fig.getPointsDatabase();
		SegmentNodeDatabase snd=fig.getSegments();
		
		
		PointDatabase pd=getPointDatabase(pnd);
	}

    private PointDatabase getPointDatabase(PointNodeDatabase pnd){
    	LinkedHashSet<PointNode> lhs=pnd.getPoints();
    	List<Point> ptList=new ArrayList<Point>();
    	for (PointNode pndPT: lhs) {
    		Point pt=new Point(pndPT.getName(), pndPT.getX(), pndPT.getY());
    		ptList.add(pt);
    	}
    	return new PointDatabase(ptList);
    }
}
