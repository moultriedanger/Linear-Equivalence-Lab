
public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		
//		
//		Node s = new Node(10, null);
//		
//		n.setData(0);
//		n.setNext(s);
//		
//		//System.out.println(n.getData());
//		
//		System.out.println(n.getNext().getData());
		
		LinkedList<Node> linkedList = new LinkedList<>();
		
		Node n = new Node(5, null);
		
		Node n1 = new Node(10, null);
		
		linkedList.addToFront(n);
		
		linkedList.addToFront(n1);
		
		System.out.println(linkedList.size());
		
		System.out.println(linkedList.contains(n1));
		
		linkedList.clear();
		System.out.println(linkedList.size());
		
		//System.out.println(linkedList.isEmpty());
		
		//linkedList.clear();
		
		
		//System.out.println(linkedList.contains(n));
		
		
		
		
	}

}
