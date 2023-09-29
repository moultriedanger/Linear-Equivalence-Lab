package input.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import input.components.*;
import input.components.point.PointNode;
import input.components.point.PointNodeDatabase;
import input.components.segment.SegmentNodeDatabase;
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

	}
        // TODO: Build the whole AST, check for return class object, and return the root

	public PointNodeDatabase getPND(JSONObject fig) {
		JSONArray jArray = fig.getJSONArray("Points");
		PointNodeDatabase pnd = new PointNodeDatabase();
		for(Object item: jArray)
		{
			JSONObject jObj = (JSONObject) item;
			String name = jObj.getString("name");
			Double x=jObj.getDouble("x");
			Double y=jObj.getDouble("y");
			PointNode pt= new PointNode(name, x, y);
			pnd.put(pt);
		}
		return pnd;
		
		
		
	}
}