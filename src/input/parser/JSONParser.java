package input.parser;



import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import input.components.*;
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
		if (!JSONFigure.has("Figure")) error("Figure does not exist in JSON file");
		JSONObject fig = JSONFigure.getJSONObject("Figure");
		String desc = fig.getString("Description");
		JSONArray jPoints = fig.getJSONArray("Points");
		
		PointNodeDatabase pnd = getPND(jPoints);
		SegmentNodeDatabase snd = handleSegments(pnd,fig);
		
		FigureNode f = new FigureNode(desc, pnd, snd);
		return f;
	}
    // TODO: Build the whole AST, check for return class object, and return the root

	/*
	 * Creates a pointnodedatabse using from the JSON file
	 *@param JSONArray the array of points in the JSON file
	*/
	public PointNodeDatabase getPND(JSONArray jPoints) {
		PointNodeDatabase pnd = new PointNodeDatabase();
		
		for(Object item: jPoints)
		{
			JSONObject jObj = (JSONObject) item;
			String name = jObj.getString("name");
			Double x = jObj.getDouble("x");
			Double y = jObj.getDouble("y");			
			PointNode pt = new PointNode(name, x, y);
			pnd.put(pt);
		}
		return pnd;
	}
	
	/*
	 * Finds the segments JSONObject and then iterates through it to make a segmentNodeDatabase
	 *@param points if a pointnodedatabase so we can call getPoint method
	 *@param fig is so we can have assess to the JSON File
	*/
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
				segments.addUndirectedEdge(points.getPoint(key.get(0).toString()), points.getPoint(value.get(i).toString()));
			}
		}
		return segments;
	}
}