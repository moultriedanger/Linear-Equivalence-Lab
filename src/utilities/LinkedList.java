package utilities;

public class LinkedList<T> {
	
	private class Node{
		private T _data;
		private Node _next;
		
		public Node(T data, Node next){
			this._data = data;
			next = null; 
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
		
		this._size = 0;
	}
	
	///Methods
	public boolean isEmpty() {
		return _head._next == _tail;
	}
	
	public void clear() {
		this._head._next =_tail;
		this._size = 0;
	}

	public int size() {
		return this._size;
	}
	
	public void addToFront(T element) {
		//Create node
		Node n = new Node(element, _head._next);
		
		_head._next = n;
		
		_size ++;
	}
	
	public boolean contains(T target) {
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n._data == target) {
				return true;
			}
		}
		return false;
	}
	
//	private Node previous(Node target){
//		
//		Node prev = _head;
//		
//		for(Node n = _head._next; n!= _tail; n = n._next) {
//			
//			if(n.equals(target)) {
//				return prev;
//			}
//			//Increase previous
//			prev = prev._next;
//		}
//		return null;
//	}
	
	public void remove(Node target) {
		for(Node n = _head._next; n!= _tail; n = n._next) {
			if(n.equals(target)) {
				previous(target)._next = target._next;
				_size --;
			}
		}
	}
	
	//Work
	public String toString() {
		String somestring = "";
		for (Node n = _head._next; n == _tail; n = n._next) {
			somestring += n._data.toString();
		}
		return somestring;
		
	}

	
}
