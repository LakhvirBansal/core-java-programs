package LinkedList;


public class InsertNewNode {

	Node head;

	public static void main(String[] args) {

		InsertNewNode llist = new InsertNewNode();

		llist.push(4);
		llist.push(1);
		llist.append(5);
		llist.append(6);
		llist.insertAfter(llist.head, 2);
		llist.printList();

	}

	// this method is used to add the elements in start
	// Time complexity of push() is O(1) as it does constant amount of work
	private void push(int i) {

		Node node = new Node(i);
		if (head == null) {
			head = node;
			return;
		}

		node.next = head;
		head = node;
	}

	// this method is used to insert the node in the middle
	// Time complexity of insertAfter() is O(1) as it does constant amount of work.
	private void insertAfter(Node node, int i) {
		Node new_node = new Node(i);

		new_node.next = node.next;

		node.next = new_node;

	}

	// this method is used to append the element in the last
	// Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
	// to end, the function does O(n) work.
	// This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list
	private void append(int i) {

		Node node = new Node(i);

		if (head == null) {
			head = node;
			return;
		}

		Node last = head;

		while (last.next != null) {
			last = last.next;
		}

		last.next = node;
	}

	// print the linked list
	private void printList() {

		Node node = head;

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}

	}
}
