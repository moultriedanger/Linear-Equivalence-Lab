package utilities;

import java.util.Comparator;

public class LinkedEquivalenceClass<T>{
	
	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;
	
	public LinkedEquivalenceClass(Comparator<T> comparator) {
		_canonical = null;
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
	
	public boolean add(T element) {
		
		if(this.isEmpty()) {
			_canonical = element;
			return true;
		}
		else if(_comparator.compare(_canonical, element)==0) {
			_rest.addToFront(element);
			return true;
		}
		return false;
	}
	

}
