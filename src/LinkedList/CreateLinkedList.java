package LinkedList;

public class CreateLinkedList {

	Node head;

	public static void main(String[] args) {
		CreateLinkedList linkedList = new CreateLinkedList();
		Node node = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		
		linkedList.head = node;
		
		  /* Three nodes have been allocated  dynamically.
        We have refernces to these three blocks as first,  
        second and third

        llist.head        second              third
           |                |                  |
           |                |                  |
       +----+------+     +----+------+     +----+------+
       | 10 | null |     | 20 | null |     | 30 | null |
       +----+------+     +----+------+     +----+------+ */

		linkedList.head.next = second; // Link first node with the second node

      /*  Now next of first Node refers to second.  So they
          both are linked.

       llist.head        second              third
          |                |                  |
          |                |                  |
      +----+------+     +----+------+     +----+------+
      | 1  |  o-------->| 2  | null |     |  3 | null |
      +----+------+     +----+------+     +----+------+ */

      second.next = third; // Link second node with the third node

      /*  Now next of second Node refers to third.  So all three
          nodes are linked.

       llist.head        second              third
          |                |                  |
          |                |                  |
      +----+------+     +----+------+     +----+------+
      | 1  |  o-------->| 2  |  o-------->|  3 | null |
      +----+------+     +----+------+     +----+------+ */
		
		linkedList.printList();
	}

	private void printList() {

		Node n = head;
		
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		
	}

}
