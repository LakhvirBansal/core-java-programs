package LRUCache;

import java.util.HashMap;

public class LRUCache2 {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}

	}

	public void setHead(Node n) {
		n.next = head;
		n.pre = null;

		if (head != null)
			head.pre = n;

		head = n;

		if (end == null)
			end = head;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LRUCache2 lrucache = new LRUCache2(3);
		lrucache.set(1, 1);
		lrucache.set(1, 15);
		lrucache.set(15, 10);
		lrucache.set(10, 16);
		lrucache.set(12, 15);
		lrucache.set(18, 10);
		lrucache.set(13, 16);

		System.out.println(lrucache.get(12));
		System.out.println(lrucache.get(18));
		System.out.println(lrucache.get(15));

	}
}
