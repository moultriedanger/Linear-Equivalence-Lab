package utilities;

public class LinkedList<T> {
	
	private class Node{
		private T data;
		private Node next;
		
		public Node(T data, Node next){
			this.data = data;
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
		return _head.next == _tail;
	}
	
	public void clear() {
		this._head.next =_tail;
		this._size = 0;
	}

	public int size() {
		return this._size;
	}
	
	public void addToFront(Node element) {
		//Get the heads next
		Node temp = this._head.next;
		
		this._head.next = element;
		
		//Set new elements next to heads next next 
		element.next = temp;
		this._size ++;
	}
	
	public boolean contains(Node target) {
		
		for(Node n = _head.next; n!= _tail; n = n.next) {
			if(n.equals(target)) return true;
		}
		return false;
	}
	
	private Node previous(Node target){
		
		Node prev = _head;
		
		for(Node n = _head.next; n!= _tail; n = n.next) {
			
			if(n.equals(target)) {
				return prev;
			}
			//Increase previous
			prev = prev.next;
		}
		return null;
	}
	
	public void remove(Node target) {
		for(Node n = _head.next; n!= _tail; n = n.next) {
			if(n.equals(target)) {
				
			}
		}
		
	}
	
	

	
	
}
