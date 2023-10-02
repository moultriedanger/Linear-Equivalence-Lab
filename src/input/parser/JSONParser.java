package input.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import input.components.*;
import input.components.SegmentNode;
import input.components.SegmentNodeDatabase;
import input.exception.ParseException;


public class JSONParser
{
	protected ComponentNode  _astRoot;

	public JSONParser()
	{
		_astRoot = null;
	}

	private void error(String message)
	{
		throw new ParseException("Parse error: " + message);
	}

	public ComponentNode parse(String str) throws ParseException
	{
		// Parsing is accomplished via the JSONTokenizer class.
		JSONTokener tokenizer = new JSONTokener(str);
		JSONObject  JSONFigure = (JSONObject)tokenizer.nextValue();
		JSONObject fig = JSONFigure.getJSONObject("Figure");
		String desc = fig.getString("Description");
		JSONArray jArray = fig.getJSONArray("Points");
		
		PointNodeDatabase pnd = getPND(jArray);
		SegmentNodeDatabase snd = handleSegments(pnd,fig);
		
		FigureNode f = new FigureNode(desc, pnd, snd);
		
		return f;
	}
    // TODO: Build the whole AST, check for return class object, and return the root

	public PointNodeDatabase getPND(JSONArray jArray) {
		PointNodeDatabase pnd = new PointNodeDatabase();
		
		for(Object item: jArray)
		{
			JSONObject jObj = (JSONObject) item;
			
			String name = jObj.getString("name");
			Double x = jObj.getDouble("x");
			Double y = jObj.getDouble("y");
			
//			System.out.println(name);
//			System.out.println(x);
//			System.out.println(y);
			
			PointNode pt = new PointNode(name, x, y);
			pnd.put(pt);
		}
		return pnd;
	}
//	public SegmentNodeDatabase getSND(JSONObject fig) {
//		JSONArray jArray = fig.getJSONArray("Segments");
//		SegmentNodeDatabase snd = new SegmentNodeDatabase();
//
//		for(Object item: jArray) {
//			JSONObject jObj = (JSONObject) item;
//			SegmentNode sn = new SegmentNode();
//			String key = item.keys();
//			JSONArray adjList = jObj.getArray(key);
//		}		
//	}
	private SegmentNodeDatabase handleSegments(PointNodeDatabase points, JSONObject fig)
	{
		JSONArray json_adjLists = fig.getJSONArray("Segments");
		SegmentNodeDatabase segments = new SegmentNodeDatabase();
		
		for (int a = 0; a < json_adjLists.length(); a++){
			
			JSONObject dict = json_adjLists.getJSONObject(a);
	
			
			JSONArray key = dict.names();
			//System.out.print(key);
					
			JSONObject jObj = dict;
			
			JSONArray value = jObj.getJSONArray(key.get(0).toString());
			for(int i = 0; i<value.length(); i++) {
				
				System.out.print(key.get(0));
				
				//System.out.println()
				System.out.println(value.get(i));
				
				//PointNode k = getPoint(pnd);
				
				//System.out.println(value.get(i));
				
				//SegmentNode s = new SegmentNode(k,v);
				///segments.
			}
		}
		return segments;
	}
}