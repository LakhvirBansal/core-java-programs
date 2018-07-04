package DoubleLinkedList;

public class NodeInsertion {
	Node head;

	public static void main(String[] args) {
		/* Start with the empty list */
		NodeInsertion dll = new NodeInsertion();

		// Insert 6. So linked list becomes 6->NULL
		dll.append(6);

		// Insert 7 at the beginning. So linked list becomes 7->6->NULL
		dll.push(7);

		// Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
		dll.push(1);

		// Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
		dll.append(4);

		// Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
		dll.InsertAfter(dll.head.next, 8);

		System.out.println("Created DLL is: ");
		dll.printlist(dll.head);
	}

	private void printlist(Node head) {

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	private void InsertAfter(Node prev_node, int i) {
		Node new_node = new Node(i);

		if (prev_node != null) {
			new_node.next = prev_node.next;
			prev_node.next = new_node;
			new_node.prev = prev_node;
			if (new_node.next != null) {
				new_node.next.prev = new_node;
			}
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

	private void append(int i) {

		Node new_node = new Node(i);

		Node last_node = head;
		if (head == null) {
			head = new_node;
			return;
		}

		while (last_node.next != null) {
			last_node = last_node.next;
		}

		last_node.next = new_node;
		new_node.prev = last_node;
	}
}
