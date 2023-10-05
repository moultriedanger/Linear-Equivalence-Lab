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
        return new SegmentNodeDatabase();
    }
    
    public void addSegmentToDatabase(SegmentNodeDatabase segments, PointNode from, PointNode to)
    {
    	if (segments != null) segments.addUndirectedEdge(from, to);
    }
    
    public SegmentNode buildSegmentNode(PointNode pt1, PointNode pt2)
    {
        return new SegmentNode(pt1,pt2);
    }
    
    public PointNodeDatabase buildPointDatabaseNode(List<PointNode> points)
    {
    	PointNodeDatabase pnd = new PointNodeDatabase();
    	
    	for(PointNode p: points) {
    		pnd.put(p);
    	}
    	return pnd;
    }
    
    public PointNode buildPointNode(String name, double x, double y)
    {
        return new PointNode(name, x,y);
    }
}
