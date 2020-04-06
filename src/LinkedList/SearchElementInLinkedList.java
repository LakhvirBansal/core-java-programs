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
		boolean isPresent = llist.searchElement(1);

		System.out.println("Element present :" + isPresent);
	}

	private boolean searchElement(int i) {

		if (head == null) {
			return false;
		}

		while (head != null && head.data != i) {
			head = head.next;
		}

		if (head == null) {
			return false;
		}
		return true;
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
