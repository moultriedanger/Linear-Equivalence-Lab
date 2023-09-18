package utilities;

import java.util.Comparator;

public class LinkedEquivalenceClass<T> implements Comparator<T>{
	
	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;
	
	public LinkedEquivalenceClass(Comparator<T> comparator) {
		_comparator = comparator;
		_rest = new LinkedList<T>();
	}
	
	public T canonical() {
		return _canonical;
	}
	
	
	public boolean isEmpty() {
		
		return _rest.isEmpty();
	}
	
	public void clear() {
		_rest.clear();
	}
	
	public void clearNonCanonical() {
		
		
	}
	
	public int size() {
		return _rest.size();
	}
		
	
	
	@Override
	public int compare(T o1, T o2) {
	
		return 0;
	}
	
	

}
