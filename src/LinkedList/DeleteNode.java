package LinkedList;

public class DeleteNode {

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

		DeleteNode llist = new DeleteNode();
		llist.push(7);
		llist.push(5);
		llist.push(3);
		llist.push(1);

		llist.printList();

		llist.deleteNode(7);
		llist.printList();
	}

	private void deleteNode(int i) {

		if (head == null) {
			System.out.println("linked list is empty");
		}

		if (head.data == i) {
			head = head.next;
			return;
		}
		
		Node curNode = head.next;
		Node prev = head;
		while (curNode.next != null && curNode.data != i) {
				prev = curNode;
				curNode = curNode.next;
		}
		
		if (curNode.data == i) {
			prev.next = curNode.next;
		}
	}

	private void printList() {

		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

	private void push(int i) {

		Node newNode = new Node(i);

		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}
}
