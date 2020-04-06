package LinkedList;


public class CountParticularElementINLinkedList {

	Node head;

	public static void main(String[] args) {

		CountParticularElementINLinkedList llist = new CountParticularElementINLinkedList();
		llist.push(14);
		llist.push(30);
		llist.push(10);
		llist.push(1);
		llist.push(2);

		// 2- 1 - 10 - 30 - 14 - null
		llist.printList();
		int val = llist.getMiddelElement();

		if (val == -1)
			System.out.println("linked list is empty");
		else
			System.out.println("middle element is :" + val);
	}


	/**
	 * Initialize mid element as head and initialize a counter as 0. Traverse the list from head, while traversing
	 * increment the counter and change mid to mid->next whenever the counter is odd. So the mid will move only half of
	 * the total length of the list.
	 * 
	 * @return middle Element
	 */
	private int getMiddelElement() {
		if (head == null) {
			return -1;
		}

		Node mid = head;  //2

		int count = 0;

		while (head != null) {

			// if counter is odd we move to next element
			if (count % 2 == 1) {
				mid = mid.next;
			}
			count++;
			head = head.next;
		}

		return mid.data;
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
