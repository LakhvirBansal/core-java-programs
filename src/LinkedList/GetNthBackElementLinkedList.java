package LinkedList;


public class GetNthBackElementLinkedList {

	Node head;

	public static void main(String[] args) {

		GetNthBackElementLinkedList llist = new GetNthBackElementLinkedList();
		llist.push(14);
		llist.push(30);
		llist.push(10);
		llist.push(1);
		// 1 - 10 - 30 - 14 - null
		llist.printList();
		int val = llist.getNthFromLast(1);

		if (val == -1)
			System.out.println("wrong Index");
		else
			System.out.println("val is :" + val);

		// Time Complexity: O(n) where n is the length of linked list.
	}

	/*
	 * Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head.
	 * First move reference pointer to n nodes from head. Now move both pointers one by one until reference pointer
	 * reaches end. Now main pointer will point to nth node from the end. Return main pointer.
	 */
	private int getNthFromLast(int i) {

		if (head == null) {
			return -1;
		}

		Node ref_node = head;
		Node main_ref = head;

		int count = 0;
		while (ref_node != null) {
			if (count < i) {
				ref_node = ref_node.next;
			} else {
				ref_node = ref_node.next;
				main_ref = main_ref.next;
			}
			count++;
		}

		if (count >= i) {
			return main_ref.data;
		}

		return -1;
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
