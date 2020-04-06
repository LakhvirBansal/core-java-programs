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
		llist2.push(4);
		llist2.push(3);
		llist2.push(2);
		llist2.printList();
		
		TwoNodesIntersectionInLinkedList returnList = getIntersectionOfTwoLists(llist.head, llist2.head); 
		returnList.printList();
	}



	private static TwoNodesIntersectionInLinkedList getIntersectionOfTwoLists(Node head1,
			Node head2) {
		// TODO Auto-generated method stub
		TwoNodesIntersectionInLinkedList returnList  = new TwoNodesIntersectionInLinkedList();
		
		while(head1 != null && head2 != null) {
			if(head1.data == head2.data) {
				returnList.push(head1.data);
				head1 = head1.next;
				head2 = head2.next;
			} else {
				if(head1.data < head2.data) {
					head1 = head1.next;
				} else {
					head2 = head2.next;
				}
			}
		}
		return returnList;
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
