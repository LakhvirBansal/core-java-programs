package LinkedList;


public class SearchElementInLinkedList {

	Node head;

	public static void main(String[] args) {

		SearchElementInLinkedList llist = new SearchElementInLinkedList();
		llist.push(7);
		llist.push(5);
		llist.push(3);
		llist.push(1);

		llist.printList();
		int length = llist.getLength();
		System.out.println("linkedList length :" + length);
	}


	private int getLength() {

		int count = 0;
		if (head == null) {
			return count;
		}

		while (head != null) {
			count++;
			head = head.next;
		}

		return count;
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
