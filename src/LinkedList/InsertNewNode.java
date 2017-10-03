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
		llist.push(4);
		llist.push(1);
		llist.append(6);
		llist.insertAfter(llist.head, 2);
		llist.printList();

	}

	// print the linked list
	private void printList() {

		Node node = head;

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

	}

	// this method is used to insert the node in the middle
	private void insertAfter(Node node, int i) {
		Node new_node = new Node(i);

		new_node.next = node.next;

		node.next = new_node;

	}

	// this method is used to add the elements in start
	private void push(int i) {

		Node node = new Node(i);
		if (head == null) {
			head = node;
			return;
		}

		Node temp = head;

		head = node;
		node.next = temp;

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
