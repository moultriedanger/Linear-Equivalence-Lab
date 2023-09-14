
public class Node<T> {
	public T data;
	public Node<T> next;

	Node(T data, Node<T> next){
		this.data = data;
		next = null; 
	}
	
	//getsData from node
	public T getData(){
		return data;
	}
	
	//sets a nodes value
	public void setData(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	//SetNext method
	public void setNext(Node<T> element){
		this.next = element;
	}
}
