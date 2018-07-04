package LinkedList;


public class SearchElementInLinkedList {

	Node head;

	public static void main(String[] args) {

		SearchElementInLinkedList llist = new SearchElementInLinkedList();
		llist.push(14);
		llist.push(30);
		llist.push(10);
		llist.push(1);

		llist.printList();
		int val = llist.searchElementAtParPosition(2);

		if (val == -1)
			System.out.println("wrong Index");
		else
			System.out.println("val is :" + val);
	}

	private int searchElementAtParPosition(int i) {

		if (head == null) {
			return -1;
		}

		int count = 0;

		while (count < i && head != null) {
			count++;
			head = head.next;
		}

		if (head != null) {
			return head.data;
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
