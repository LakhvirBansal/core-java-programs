package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromUnSortedLinkedList {

	static Node head;

	public static void main(String[] args) {

		RemoveDuplicateFromUnSortedLinkedList llist = new RemoveDuplicateFromUnSortedLinkedList();
		llist.push(10);
		llist.push(11);
		llist.push(12);
		llist.push(11);
		llist.push(11);
		llist.push(12);
		llist.push(10);
		llist.printList();
		// head -10->12->11->11->12->11->10- null

		llist.removeDuplicates();
		System.out.println("After removing duplicates");
		llist.printList();
		// head -> 10 - 12 - 11 - null
	}

	/**
	 * We traverse the link list from head to end. For every newly encountered element, we check whether it is in the
	 * hash table: if yes, we remove it; otherwise we put it in the hash table.
	 */
	private void removeDuplicates() {
		
		Node cur_node = head;
		
		Node prev = null; // to hold previous Node
		Set<Integer> numberSet = new HashSet<Integer>();
		if(head == null){
			return;
		}
		
		while (cur_node != null) {
			if (numberSet.contains(cur_node.data)) { // if values is already present
				prev.next = cur_node.next; // change the pointer
			} else {
				numberSet.add(cur_node.data);
				prev = cur_node;
			}
			cur_node = cur_node.next;
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
