package input.builder;

import java.util.List;

import input.components.*;

/*
 * A Builder design pattern for constructing a geometry hierarchy.
 * 
 * The default builder facilitates JSON file parsing without constructing
 * the corresponding hierarchy.
 */
public class DefaultBuilder
{
	public DefaultBuilder() { }

    public FigureNode buildFigureNode(String description,
    		                          PointNodeDatabase points,
    		                          SegmentNodeDatabase segments)
    {
        return null;
    }
    
    public SegmentNodeDatabase buildSegmentNodeDatabase()
    {
        return null;
    }
    
    public void addSegmentToDatabase(SegmentNodeDatabase segments, PointNode from, PointNode to)
    {
    	
    }
    
    public SegmentNode buildSegmentNode(PointNode pt1, PointNode pt2)
    {
        return null;
    }
    
    public PointNodeDatabase buildPointDatabaseNode(List<PointNode> points)
    {
    	return null;
    }
    
    public PointNode buildPointNode(String name, double x, double y)
    {
        return null;
    }
}
