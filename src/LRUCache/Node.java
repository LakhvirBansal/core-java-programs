package LRUCache;

public class Node {
	int key;
	int value;
	Node pre;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public Node(int key) {
		this.key = key;
	}
}
