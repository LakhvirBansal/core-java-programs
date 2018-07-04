package DoubleLinkedList;

import java.util.Stack;

public class ReverseDoubleLinkedList {
	Node head;

	public static void main(String[] args) {
		/* Start with the empty list */
		ReverseDoubleLinkedList dll = new ReverseDoubleLinkedList();

		dll.push(2);
		dll.push(4);
		dll.push(8);
		dll.push(10);
		/* 10<->8<->4<->2 */
		System.out.println("Created DLL is: ");
		dll.printlist(dll.head);

		dll.reverseList(dll.head);
		dll.reverse();
		dll.printlist(dll.head);
	}

	void reverse() {
		Node temp = null;
		Node current = head;

		/*
		 * swap next and prev for all nodes of doubly linked list
		 */
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		/*
		 * Before changing head, check for the cases like empty list and list with only one node
		 */
		if (temp != null) {
			head = temp.prev;
		}
	}

	private void reverseList(Node head) {
		Stack<Integer> vals = new Stack<Integer>();

		Node temp = head;
		while (temp != null) {
			vals.push(temp.data);
			temp = temp.next;
		}

		while (vals != null && vals.size() > 0) {
			System.out.println("value is " + vals.pop());
		}

	}

	private void printlist(Node head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}


	private void push(int i) {
		Node new_node = new Node(i);

		if (head == null) {
			head = new_node;
			return;
		}

		new_node.next = head;
		head.prev = new_node;
		head = new_node;
	}

}
