package LinkedList;


public class DeleteAtParticularPosition {

	Node head;

	public static void main(String[] args) {

		DeleteAtParticularPosition llist = new DeleteAtParticularPosition();
		llist.push(7);
		llist.push(5);
		llist.push(3);
		llist.push(1);

		llist.printList();

		llist.deleteNodeIndex(2);
		llist.printList();
	}

	private void deleteNodeIndex(int i) {

		if (head == null) {
			System.out.println("linked list is empty");
		}

		if (i == 0) {
			head = head.next;
			return;
		}

		Node curNode = head.next;
		Node prev = head;
		int count = 0;
		while (curNode.next != null && count < i - 1) {
			prev = curNode;
			curNode = curNode.next;
			count++;
		}

		if (curNode.next == null) {
			return;
		}

		prev.next = curNode.next;

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
