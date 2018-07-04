package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopLengthInLinkedList {

	static Node head;

	public static void main(String[] args) {

		DetectLoopLengthInLinkedList llist = new DetectLoopLengthInLinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		// head - 10 - 15 - 4 - 20 - null

		head.next.next.next.next = head;


		/*boolean isPresent = llist.detectLoop();

		if (isPresent)
			System.out.println("loop present");
		else
			System.out.println(" loop not present ");*/

		boolean loopPresent = llist.detectLoopUsingFlyodCycleAlgo();
		if (loopPresent)
			System.out.println("loop present");
		else
			System.out.println(" loop not present ");
	}


	/**
	 * Floyd’s Cycle-Finding Algorithm: This is the fastest method. Traverse linked list using two pointers. Move one
	 * pointer by one and other pointer by two. If these pointers meet at some node then there is a loop. If pointers do
	 * not meet then linked list doesn’t have loop.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @return ture/false related to loop information
	 */
	private boolean detectLoopUsingFlyodCycleAlgo() {
		if (head == null) {
			return false;
		}

		Node slow_p = head, fast_p = head;

		while (slow_p != null && fast_p != null && fast_p.next != null) {

			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Hashing technique -> Traverse the list one by one and keep putting the node addresses in a Hash Table. At any
	 * point, if NULL is reached then return false and if next of current node points to any of the previously stored
	 * nodes in Hash then return true.
	 * 
	 * @return
	 */
	private boolean detectLoop() {

		if (head == null) {
			return false;
		}

		Set<Integer> values = new HashSet<Integer>();
		while (head != null) {

			if (values.contains(head.data)) {
				return true;
			}
			values.add(head.data);
			head = head.next;
		}

		return false;
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
