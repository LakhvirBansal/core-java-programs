package LinkedList;


public class InsertNewNode {

	Node head;

	class Node {

		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public static void main(String[] args) {

		InsertNewNode llist = new InsertNewNode();

		llist.append(5);
	}

	// this method is used to append the element in the last
	private void append(int i) {

		Node node = new Node(i);

		if (head == null) {
			head = node;
			return;
		}

		Node last = head;

		while (last.next != null) {
			last = last.next;
		}

		last.next = node;
	}
}
