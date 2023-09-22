package utilities;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EquivalenceClasses<T> {
	private Comparator<T> _comparator;
	private List<LinkedEquivalenceClass<T>> _classes;
	
	public EquivalenceClasses(Comparator<T> comparator){
		_comparator = comparator;
		_classes = new ArrayList<LinkedEquivalenceClass<T>>();
	}
	
	public boolean add(LinkedEquivalenceClass<T> element){
		
		if (element == null) {
			return false;
		}
		_classes.add(element);
		
		return true;
	}
	
	//W.M
	public boolean contains(T target) {
		for(LinkedEquivalenceClass<T> equivalenceClass :_classes) {
			if(equivalenceClass.contains(target)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return _classes.size();
	}
	
	private int indexOfClass(T element) {
		
		for(int i = 0; i < _classes.size(); i ++) {
			if (_classes.get(i).belongs(element)) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString(){
		String result = "";
		
		for(LinkedEquivalenceClass l : _classes) {
			result += l.toString() + ", ";
		}
		return result;
	}
}
