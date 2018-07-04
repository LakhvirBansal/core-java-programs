package DoubleLinkedList;

public class DeleteNode {
	Node head;

	public static void main(String[] args) {
		/* Start with the empty list */
		DeleteNode dll = new DeleteNode();

		dll.push(2);
		dll.push(4);
		dll.push(8);
		dll.push(10);
		/* 10<->8<->4<->2 */
		System.out.println("Created DLL is: ");
		dll.printlist(dll.head);

		dll.deleteNode();
		System.out.println("after DLL is: ");
		dll.printlist(dll.head);

		dll.deleteMiddleNode(4);
		System.out.println("after DLL particular: ");
		dll.printlist(dll.head);

		dll.deleteLast();
		System.out.println("after delete last element: ");
		dll.printlist(dll.head);
	}

	private void deleteLast() {
		
		Node del = head;
		if (head != null) {
			
			while (del.next != null) {
				del = del.next;
			}

			del.prev.next = null;
		}

	}

	private void deleteMiddleNode(int i) {

		Node del = head;
		while (del != null) {

			if (del.data == i) {
				if (del.next != null) {
					del.next.prev = del.prev;
					del.prev.next = del.next;
				}
			}
			del = del.next;
		}

	}

	private void deleteNode() {

		if (head != null) {
			head = head.next;
			head.prev = null;

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
