package input.components;

import utilities.io.StringUtilities;


/**
 * A basic figure consists of points, segments, and an optional description
 * 
 * Each figure has distinct points and segments (thus unique database objects).
 * 
 */
public class FigureNode implements ComponentNode
{
	protected String              _description;
	protected PointNodeDatabase   _points;
	protected SegmentNodeDatabase _segments;

	public String              getDescription()    { return _description; }
	public PointNodeDatabase   getPointsDatabase() { return _points; }
	public SegmentNodeDatabase getSegments()       { return _segments; }
	
	public FigureNode(String description, PointNodeDatabase points, SegmentNodeDatabase segments)
	{
		_description = description;
		_points = points;
		_segments = segments;
	}
	/*
	 * Builds a string to describe a figure, uses the pointnode class, the pointnodedatabase class, and the segmentnodedatabase class.
	 *@param stingbuilder is the string that gets built
	 *@param level is amount of indentations
	*/
	@Override
	public void unparse(StringBuilder sb, int level)
	{ 
		sb.append("Figure\n{\n");
		sb.append(StringUtilities.indent(level+1));
		sb.append("Description : " + getDescription() + "\n");
		sb.append(StringUtilities.indent(level+1));
		sb.append("Points:\n" + StringUtilities.indent(level+1) + "{\n");
		_points.unparse(sb, level+1);
		_segments.unparse(sb, level+1);
		sb.append("\n" + StringUtilities.indent(level+1) + "}\n}");
	}
	
}