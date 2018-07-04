package LinkedList;


public class GetMiddleElementOfLinkedList {

	Node head;

	public static void main(String[] args) {

		GetMiddleElementOfLinkedList llist = new GetMiddleElementOfLinkedList();
		llist.push(1);
		llist.push(2);
		llist.push(1);
		llist.push(3);
		llist.push(1);

		// head -> 1-3-1-2-1-null
		llist.printList();
		int val = llist.countParNumber(8);

		if (val == -1)
			System.out.println("linked list is empty");
		else
			System.out.println("count in linkedlist :" + val);

		// Time Complexity: O(n)
	}

	private int countParNumber(int i) {

		if (head == null) {
			return -1;
		}

		int count = 0;
		while (head != null) {
			if (head.data == i) {
				count++;
			}
			head = head.next;
		}

		return count;
	}

	/**
	 * used to print the linked list
	 */
	private void printList() {

		Node n = head;

		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}

	/**
	 * used to insert the element at the head
	 * 
	 * @param i
	 */
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
