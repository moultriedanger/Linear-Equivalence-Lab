package utilities;

public class LinkedList<T> {
	
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
		
		_head._next = n;
		
		_size ++;
	}
	
	public boolean contains(T target) {
		
		if (isEmpty() == true) {
			return false;
		}
		
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n._data.equals(target)) {
				return true;
			}
		}
		return false;
	}
	
	private Node previous(T target){
		
		if (isEmpty() == true) {
			return null;
		}
		
		Node prev = _head;
		
		for(Node n = _head._next; n!= _tail; n = n._next) {
			
			if(n._data == target) {
				return prev;
			}
			//Increase previous
			prev = prev._next;
		}
		return null;
	}
	
	public boolean remove(T target) {
		
		if (isEmpty() == true) {
			return false;
		} 
		
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n._data == target) {
				
				previous(n._data)._next = n._next;
				n._next = null;
				_size --;
				return true;
			}
		}
		return false;
	}

	private Node last() {
		Node current = _head;
		
		while(current._next != _tail) {
			
			current = current._next;
		}
		return current;
	}
	
	public void addToBack(T element) {
		Node n = new Node(element, _tail);
		
		last()._next = n;
		_size ++;
	}
	
	public String toString() {
		
		if (isEmpty() == true) {
			return "List is empty";
		}
		
		String result = "";
		Node current = _head._next;
		while(current != _tail) {
			result += current._data + " ";
			
			current = current._next;
		}
		return result;
	}
	
	public void reverse() {


		Node current = last();
		
		for(Node n = _head; n._next == _tail; n = n._next ) {
			
			n._next = current;
			
			current = previous(current._data);
		}
	}

}
