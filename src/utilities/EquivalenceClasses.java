package utilities;

import java.util.Comparator;
import java.util.List;

public class EquivalenceClasses<T> {
	private Comparator<T> _comparator;
    private List<LinkedEquivalenceClass<T>> _classes;
	//private Comparator<T> = _comparator; 
	//private List<LinkedEquivalenceClass<T>> _classes;

	public EquivalenceClasses(Comparator<T> comparator) {
		_comparator = comparator;
		_classes = new LinkedList<T>();	
	}
	 
	public boolean add(T element) {
		
	}
	
	public boolean contains (T target) {
		
	}
	
	public int size() {
		
	}
	
	public int numClasses() {
		
	}
	
	// public int indexOfClass(T element){
	
	//}	
	
	public String toString() {
		
	}
}
