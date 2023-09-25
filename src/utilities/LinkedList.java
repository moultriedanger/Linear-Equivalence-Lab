package utilities;

public class LinkedList<T> {
	
	//Create node class
	private class Node{
		private T _data;
		private Node _next;
		
		public Node(T data, Node next){
			_data = data;
			_next = next; 
		}
	}

	//Define instance variables
	protected Node _head;
	protected Node _tail;
	protected int _size;
	
	LinkedList(){
		//Create head and tail
		_tail = new Node(null, null);
		_head = new Node(null, _tail);
		
		_size = 0;
	}
	
	public boolean isEmpty() {
		return _head._next.equals(_tail);
	}
	
	public void clear() {
		this._head._next =_tail;
		this._size = 0;
	}

	public int size() {
		return this._size;
	}
	
	public void addToFront(T element) {
		Node n = new Node(element, _head._next);
		
		//Make the head point to new node
		_head._next = n;
		_size ++;
	}
	
	public boolean contains(T target) {
		if (isEmpty()|| target == null) return false;
		
		//Find node in linked list equal to target
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n._data.equals(target)) return true;
		}
		return false;
	}
	
	public Node previous(T target){
		
		//Check if empty and if the list contains target
		if (isEmpty() || !this.contains(target)) return null;
		
		//Store the previous
		Node prev = _head;
		
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n._data.equals(target)) {
				return prev;
			}
			//Increase previous if not found
			prev = prev._next;
		}
		return null;
	}
	
	public boolean remove(T target) {
	
		if (!contains(target)) return false;
		
		Node n = previous(target);
		//Set n to targets next. Garbage collect
		n._next = n._next._next;
		
		_size --;
		return true;
	}

	//Returns last node in list
	private Node last() {
		if (isEmpty()) return null;
		
		Node current = _head;
		
		while(current._next != _tail) {
			
			current = current._next;
		}
		return current;
	}
	
	public void addToBack(T element) {
		Node n = new Node(element, _tail);
		
		//Make the last point to new node
		last()._next = n;
		
		//Added node point to tail
		n._next = _tail;
		_size ++;
	}
	
	public String toString() {
		if (isEmpty()) return "";
		
		String result = "";
		Node current = _head._next;
		
		while(current != _tail) {
			//Build string
			result += current._data + " ";
			
			current = current._next;
		}
		return result.substring(0, result.length()-1);
	}
	
	public void reverse() {
		reverse(_head._next, last(), 0);
	}
		
	public void reverse(Node first, Node last, int i) {
		if(!(i ==_size/2)) {
			T val1 = last._data;
			T val2 = first._data;
			
			last._data = val2;
			first._data = val1;
			
			reverse(first._next, previous(last._data), ++i);
		}
	}
}
