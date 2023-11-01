package geometry_objects.points;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a pair of coordinates; generate a unique name for it;
 * return that point object.
 *
 * Names go from A..Z..AA..ZZ..AAA...ZZZ  (a name such as ABA does not occur)
 */
public class PointNamingFactory
{
	// Prefix associated with each generated name so those names are easily distinguishable
	private static final String _PREFIX = "*_";

    // Constants reflecting our naming characters for generated names.
	private static final char START_LETTER = 'A';
	private static final char END_LETTER = 'Z';

    //
    // the number of characters in the generated names:
	// “A” and 1 -> “A”
	// “B” and 3 -> “BBB”
	//
	private char _currentLetter=START_LETTER;
	private String _currentName = _PREFIX + START_LETTER;
	private int _numLetters = 1;

	//
	// A hashed container for the database of points; this requires the Point
	// class implement equals based solely on the individual coordinates and
	// not a name. We need a get() method; HashSet doesn’t offer one.
	// Each entry is a <Key, Value> pair where Key == Value
	//
	protected Map<Point, Point> _database;

	public PointNamingFactory()
	{
		_database=new LinkedHashMap<Point, Point>();
	}

	/**
	 * Initialize the database with points; must call put() to ensure all points are named
	 *
	 * @param points -- a list of points, named or not named
	 */
	public PointNamingFactory(List<Point> points)
	{
		_database=new LinkedHashMap<Point, Point>();
		for(Point p: points) {
			put(p);
		}
	}

	/**
	 * Overloaded add / lookup mechanism for this database.
	 *
	 * @param pt -- a Point object (may or may not be named)
	 
	 * @return THE point object in the database corresponding to its coordinate pair
                    * the object in the database if it already exists or
					* a completely new point that has been added to the database
	 */
	public Point put(Point pt)
	{
		//if pt has a name it goes in the database
		if (!pt.isUnnamed()){
			_database.put(pt, pt);
			return pt;
		}
		//else a new point is created with a name
		Point newpt=new Point(getCurrentName(), pt.getX(), pt.getY());
		_database.put(newpt, newpt);
		return newpt;
	}

	/**
	 * Overloaded add / lookup mechanism for this database for an unnamed coordinate pair.
	 *
	 * @param x -- single coordinate
	 * @param y -- single coordinate

	 * @return THE point object in the database corresponding to its coordinate pair
                    * the object in the database if it already exists or
					* a completely new point that has been added to the database (with generated name)
	 */
	public Point put(double x, double y)
	{
		Point pt=new Point(getCurrentName(),x,y);
		return _database.put(pt, pt);
	}

	/**
	 * The ‘main’ overloaded add / lookup mechanism for this database.
	 * 
	 * @param name -- the name of the point 
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * 
	 * @return a point (if it already exists in the database) or a completely new point that
	 *         has been added to the database.
	 *         
	 *         If the point is in the database and the name differs from what
	 *         is given, nothing in the database will be changed; essentially
	 *         this means we use the first name given for a point.
	 *            e.g., a valid name cannot overwrite an existing valid name ;
	 *                  a generated name cannot be overwritten by another generated name
	 *         
	 *         The exception is that a valid name can overwrite an unnamed point.
	 */
	public Point put(String name, double x, double y)
	{
		Point pt=new Point(name, x, y);
		return put(pt);
	}    

	/**
	 * Strict access (read-only of the database)
	 * 
	 * @param x
	 * @param y
	 * @return stored database Object corresponding to (x, y) 
	 */
	public Point get(double x, double y)
	{
		Point pt=new Point(x,y);
		return _database.get(pt);
	}	
	public Point get(Point pt)
	{
		return _database.get(pt);
	}

	/**
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return simple containment; no updating
	 */
	public boolean contains(double x, double y) { 
		Point pt=new Point(x,y);
		return _database.containsKey(pt);
	}
	
	public boolean contains(Point p) { return _database.containsKey(p);}

	/**
	 * Constructs the next (complete with prefix) generated name.
	 * Names should be of the form PREFIX + current name
	 *
	 * This method should also invoke updating of the current name
	 * to reflect the ‘next’ name in the sequence.
     *	 
	 * @return the next complete name in the sequence including prefix.
	 */
	private String getCurrentName()
	{
		String name=_currentName;
        updateName();
        return name;
        
	}

	/**
	 * Advances the current generated name to the next letter in the alphabet:
	 * ‘A’ -> ‘B’ -> ‘C’ -> ‘Z’ --> ‘AA’ -> ‘BB’
	 */
	private void updateName()
	{
		//Dictates the amount of letters a name needs based on letter value
        if (_currentLetter==END_LETTER) _numLetters++;
        _currentLetter++; 
        //creates a string of _current letters based on the size of numLetters
        String letters=""+_currentLetter;
        if (_numLetters>1) {
        	for (int i=1;i<_numLetters;i++) {
        		letters=letters+_currentLetter;
        	}
        }
        //updates currentName
        _currentName=_PREFIX + letters;
	}

	/**
	 * @return The entire database of points.
	 */
	public  Set<Point> getAllPoints(){ return _database.keySet();}

	public void clear() { _database.clear(); }
	public int size() { return _database.size(); }

	/**
	 * @return The string representation of the entire database of points
	 */
	@Override
	public String toString()
	{
		//uses get all points to iterate over a set of all the points
		String stringBuilder = "";
		Set<Point> points = getAllPoints();
		for(Point p: points) {
			//adds the string representation for each point
			stringBuilder += p.getName() + "(" + p.getX() + ", " + p.getY() + ")" + " ";
		}
		return stringBuilder;
	}
}