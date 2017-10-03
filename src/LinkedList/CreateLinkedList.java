package LinkedList;

public class CreateLinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int val) {
			data = val;
			next = null;
		}
	}

	public static void main(String[] args) {
		CreateLinkedList linkedList = new CreateLinkedList();
		Node node = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		linkedList.head = node;
		linkedList.head.next = second;
		second.next = third;

		printList();
	}

	private static void printList() {

		Node n = head;
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
	}

}
