package LinkedList;


public class RemoveDuplicateFromSortedLinkedList {

	static Node head;

	public static void main(String[] args) {

		RemoveDuplicateFromSortedLinkedList llist = new RemoveDuplicateFromSortedLinkedList();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);
		llist.printList();
		// head 11 - 11 - 11 - 13 - 13- 20 - null

		llist.removeDuplicates();
		System.out.println("After removing duplicates");
		llist.printList();
		// head 11 - 13- 20 - null

	}

	/**
	 * Traverse the list from the head (or start) node. While traversing, compare each node with its next node. If data
	 * of next node is same as current node then delete the next node. Before we delete a node, we need to store next
	 * pointer of the node
	 */
	private void removeDuplicates() {
		
		Node cur_node = head;
		
		Node next;
		
		if(head == null){
			return;
		}
		
		while (cur_node.next != null) { // if next node to head is not null
			if (cur_node.data == cur_node.next.data) { // if 1st and 2nd node is same
				next = cur_node.next.next; // next will we 3rd node
				cur_node.next = null; // 2nd node is null
				cur_node.next = next; // 3rd node is assigned as 2nd node
			} else {
				cur_node = cur_node.next; // if different the just move the iteration to next element
			}
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
