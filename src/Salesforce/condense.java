package Salesforce;
import java.util.*;
public class condense {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to remove duplicate values from linked list
    public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
        if (head == null) return null;

        Set<Integer> seen = new HashSet<>();
        SinglyLinkedListNode current = head;
        seen.add(current.data);

        SinglyLinkedListNode prev = current;
        current = current.next;

        while (current != null) {
            if (seen.contains(current.data)) {
                // Skip duplicate node
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    // Helper function to print the linked list
    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Helper function to build a linked list from an array
    public static SinglyLinkedListNode buildList(int[] arr) {
        if (arr.length == 0) return null;

        SinglyLinkedListNode head = new SinglyLinkedListNode(arr[0]);
        SinglyLinkedListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new SinglyLinkedListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] input = {3, 4, 3, 2, 6, 1, 2, 6};

        SinglyLinkedListNode head = buildList(input);

        System.out.println("Original List:");
        printList(head);

        head = condense(head);

        System.out.println("List after condense:");
        printList(head);
    }
}
