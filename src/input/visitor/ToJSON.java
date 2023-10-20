package input.visitor;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import input.components.*;
import input.parser.JSON_Constants;
import utilities.io.StringUtilities;


public class ToJSON implements ComponentNodeVisitor
{

	@Override
	public Object visitFigureNode(FigureNode node, Object o) {
		JSONObject fig=new JSONObject();
		int level=0;
		JSONObject cont=new JSONObject(o);
		
		cont.put(JSON_Constants.JSON_DESCRIPTION, node.getDescription());

		cont.put(JSON_Constants.JSON_POINT_S, visitPointNodeDatabase(node.getPointsDatabase(), 0));
		cont.put(JSON_Constants.JSON_SEGMENTS, visitSegmentDatabaseNode(node.getSegments(), 0));

		fig.put(JSON_Constants.JSON_FIGURE, cont);
		
		
		return fig;
	}

	@Override
	public Object visitSegmentDatabaseNode(SegmentNodeDatabase node, Object o) {
		JSONArray uniqueList=new JSONArray();
		HashMap<PointNode, LinkedHashSet<PointNode>> adjList = node.getadjList();
		
		Set<PointNode> keySet=adjList.keySet();
		List<PointNode> keyList=new ArrayList<>(keySet);
		LinkedHashSet<String> segList=new LinkedHashSet<>();
		for (PointNode pn1: keyList) {
			JSONObject segDict=new JSONObject();
			int i=keyList.indexOf(pn1);
			segList.clear();
			for (PointNode pn2: adjList.get(pn1)) {
				if (i<keyList.indexOf(pn2)) segList.add(pn2.getName());
			}
			if (!segList.isEmpty()) {
				segDict.put(pn1.getName(), segList);
				uniqueList.put(segDict);
			}
		}
		return uniqueList;
		
	}

	@Override
	public Object visitSegmentNode(SegmentNode node, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitPointNode(PointNode node, Object o) {
		JSONObject point=new JSONObject();
		point.put(JSON_Constants.JSON_NAME, node.getName());
		point.put(JSON_Constants.JSON_X, node.getX());
		point.put(JSON_Constants.JSON_Y, node.getY());
		return point;		
	} 

	@Override
	public Object visitPointNodeDatabase(PointNodeDatabase node, Object o) {
		JSONArray pnd=new JSONArray();
		LinkedHashSet<PointNode> points=node.getPoints();
		for (PointNode p: points) {
			pnd.put(visitPointNode(p,o));
		}
		return pnd;
	}
	
}