package LinkedList;


public class PairwiseSwapNodesInLinkedList {

	static Node head;

	public static void main(String[] args) {

		PairwiseSwapNodesInLinkedList llist = new PairwiseSwapNodesInLinkedList();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		llist.printList();
		// head -1->2->3->4->5- null

		llist.pairWiseSwap();
		System.out.println("After pairwise swap :");
		llist.printList();
		// head -> 2-1- 4- 3- 5 - null
	}

	private void pairWiseSwap() {

		Node temp = head;

		while (temp != null && temp.next != null) {
			int val = temp.data;
			temp.data = temp.next.data;
			temp.next.data = val;
			temp = temp.next.next;
		}

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
