package LRUCache;

import java.util.HashMap;

public class LRUCache {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public void remove(Node n) {
		if (n.pre != null) { // if any pre element is present
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) { // if any next element is present
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		n.next = head; // set head as a next element of current node
		n.pre = null; // previous node of new node is null

		if (head != null) // if any element is already present in list.
			head.pre = n; // add new element as head element

		head = n; // assign node as head element

		if (end == null)
			end = head;
	}

	public void set(int key) {
		if (map.containsKey(key)) {
			Node old = map.get(key); // get old node by key value
			remove(old); // remove old node
			setHead(old); // set old node as a head node
		} else {
			Node created = new Node(key); // created new node
			if (map.size() >= capacity) { // if cache capacity is full
				map.remove(end.key);// remove last element from cache
				remove(end);// remove last element from linked list
				setHead(created); // set new element as head of the list

			} else {
				// if capacity is not full.
				// set new element as head of the list
				setHead(created);
			}

			map.put(key, created); // put key and node inside the map
		}
	}

	public static void main(String[] args) {
		LRUCache lrucache = new LRUCache(3);
		lrucache.set(1);
		lrucache.set(2);
		lrucache.set(3);
		lrucache.set(4);
		lrucache.set(1);
		lrucache.set(2);
		lrucache.set(5);
		lrucache.set(1);
		lrucache.set(2);
		lrucache.set(3);
		lrucache.set(4);
		lrucache.set(5);

		lrucache.printCache();
	}

	private void printCache() {

		while (head != null) {
			System.out.println(head.key);
			head = head.next;
		}

	}
}
