public class LinkedList {
	private Node header;
	private int length;
	public LinkedList() {
		header = new Node();
		length = 0;
	}
	public int getLength() {
		return length;
	}
	public void add (Object o) {
		if (lookup(o) == false) {
			Node temp = new Node(o);
			Node prior = header;
			while (prior.getNext() != null  && prior.getNext().getData().toString().compareToIgnoreCase(o.toString()) < 0) {
				prior = prior.getNext();
			}
			temp.setNext(prior.getNext());
			prior.setNext(temp);
			length++;
		}
	}
	public boolean lookup(Object o) {
		Node temp = header.getNext();
		while (temp != null) {
			if (temp.getData().equals(o))
				return true;
			temp = temp.getNext();
		}
		return false;
	}
}
