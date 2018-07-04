package LinkedList;



public class TwoNodesIntersectionInLinkedList {

	Node head;

	public static void main(String[] args) {

		TwoNodesIntersectionInLinkedList llist = new TwoNodesIntersectionInLinkedList();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		llist.printList();

		TwoNodesIntersectionInLinkedList llist2 = new TwoNodesIntersectionInLinkedList();
		llist2.push(3);
		llist2.push(2);
		llist2.push(1);
		llist2.printList();
		// head -1->2->3->4->5- null

		/*
		 * llist.moveLastElementToFirst(); System.out.println("After move last element to first :"); llist.printList();
		 */
		// head -> 5 -1- 2- 3 -4 - null
	}



	private void moveLastElementToFirst() {

		Node temp = head;
		Node lastNode = temp;
		Node prevNode = null;
		while (temp.next != null) {
			lastNode = temp.next;
			prevNode = temp;
			temp = temp.next;
		}

		prevNode.next = null;
		lastNode.next = head;
		head = lastNode;

	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
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
