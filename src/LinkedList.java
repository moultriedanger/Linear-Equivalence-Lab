
public class LinkedList<T> {
	
	//Define instance variables
	protected Node<T> _head;
	protected Node<T> _tail;
	protected int _size;
	
	LinkedList(){
		//Create head and tail
		_head = new Node<T>(null, null);
		_tail = new Node<T>(null, null);
		
		this._head.next = _tail;
		this._tail.next = null;
		
		this._size = 0;
	}
	
	public boolean isEmpty() {
		return _head.getNext().equals(_tail);
	}
	
	public void clear() {
		this._head.setNext(_tail);
		this._size = 0;
	}

	public int size() {
		return this._size;
	}
	
	public void addToFront(Node<T> element) {
		//Get the heads next
		Node<T> temp = this._head.getNext();
		
		this._head.setNext(element);
		
		//Set new elements next to heads next next 
		element.setNext(temp);
		this._size ++;
	}
	
	public boolean contains(Node<T> target) {
		
		for(Node<T> n = _head.next; n!= _tail; n = n.next) {
			if(n.equals(target)) return true;
		}
		return false;
	}
	
	private Node<T> previous(Node<T> target){
		
		Node<T> prev = _head;
		
		for(Node<T> n = _head.next; n!= _tail; n = n.next) {
			
			if(n.equals(target)) {
				return prev;
			}
			//Increase previous
			prev = prev.getNext();
		}
		return null;
	}
	
	public void remove(Node<T> target) {
		for(Node<T> n = _head.next; n!= _tail; n = n.next) {
			if(n.equals(target)) {
				
			}
		}
		
	}
	
	

	
	
}
