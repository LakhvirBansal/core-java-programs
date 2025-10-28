package amazon.interviews;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteNodesGreaterThanX {

    public static Node removeNodes(Node head, int x) {
        Node dummy = new Node(0); // Dummy node for easy removal
        dummy.next = head;
        Node prev = dummy, current = head;

        while (current != null) {
            if (current.data > x) {
                prev.next = current.next; // Remove node
            } else {
                prev = current;           // Keep node, advance prev
            }
            current = current.next;       // Move current forward
        }
        return dummy.next;
    }

    // Helper to build list from array
    public static Node buildList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper to print list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: List = 100 -> 105 -> 50, x = 100
        int[] arr = {100, 105, 50};
        int x = 100;
        Node head = buildList(arr);

        System.out.print("Original list: ");
        printList(head);
        head = removeNodes(head, x);
        System.out.print("List after removing nodes greater than " + x + ": ");
        printList(head);

        // You can try with other cases
        int[] arr2 = {120, 130, 140};
        head = buildList(arr2);
        System.out.print("\nOriginal list: ");
        printList(head);
        head = removeNodes(head, 100);
        System.out.print("List after removing nodes greater than 100: ");
        printList(head);

    }
}
