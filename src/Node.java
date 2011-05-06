public class Node {
	private Node next = null;
	private Object data = null;
	public Node() {
	}
	public Node(Object o) {
		data = o;
	}
	public Object getData() {
		return data;
	}
	public void setNext(Node n) {
		next = n;
	}
	public Node getNext() {
		return next;
	}
}
