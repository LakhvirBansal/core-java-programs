package LinkedList;

public class LinkedListPalindromeUsingRecursion {

	static Node head;
	Node left;

	public static void main(String[] args) {

		LinkedListPalindromeUsingRecursion llist = new LinkedListPalindromeUsingRecursion();
		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		// head 1 - 2 - 3 - 2- 1 - null

		boolean isPalindrome = llist.isPalindrome(head);
		System.out.println(" Palindrome is :" + isPalindrome);
	}

	 // Initial parameters to this function are &head and head 
    boolean isPalindromeUtil(Node right) 
    { 
        left = head; 
  
        /* stop recursion when right becomes NULL */
        if (right == null) 
            return true; 
  
        /* If sub-list is not palindrome then no need to 
           check for current left and right, return false */
        boolean isp = isPalindromeUtil(right.next); 
        if (isp == false) 
            return false; 
  
        /* Check values at current left and right */
        boolean isp1 = (right.data == (left).data); 
  
        /* Move left to next node */
        left = left.next; 
  
        return isp1; 
    } 
  
    // A wrapper over isPalindromeUtil() 
    boolean isPalindrome(Node head) 
    { 
        boolean result = isPalindromeUtil(head); 
        return result; 
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
