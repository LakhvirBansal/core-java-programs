package LinkedList;

import java.util.Stack;

public class LinkedListPalindrome {

	static Node head;

	public static void main(String[] args) {

		LinkedListPalindrome llist = new LinkedListPalindrome();
		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(2);
		llist.push(4);
		// head 1 - 2 - 3 - 2- 1 - null

		boolean isPalindrome = llist.checkPalindrome();
		System.out.println(" Palindrome is :" + isPalindrome);
	}


	private boolean checkPalindrome() {

		if (head == null)
			return false;

		Stack<Integer> valueStack = new Stack<Integer>();
		Node initialHead = head;
		while (head != null) {
			valueStack.push(head.data);
			head = head.next;

		}

		while (initialHead != null) {
			int val = initialHead.data;
			int stackPopVal = valueStack.pop();
			if (val != stackPopVal) {
				return false;
			}
			initialHead = initialHead.next;
		}
		return true;
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
