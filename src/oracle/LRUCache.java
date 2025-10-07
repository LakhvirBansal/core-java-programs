package oracle;

import java.util.*;
public class LRUCache<K,V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head, tail;

    // Node of doubly linked list
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;
        Node(K key, V value) {
            this.key = key; this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node<>(null, null); // Dummy head
        tail = new Node<>(null, null); // Dummy tail
        head.next = tail; tail.prev = head;
    }

    // Thread-safe get
    public synchronized V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        moveToHead(node); // Mark as recently used
        return node.value;
    }

    // Thread-safe put
    public synchronized void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            if (map.size() > capacity) {
                Node<K, V> lru = removeTail();
                map.remove(lru.key);
            }
        }
    }

    //move a node to the front (most recently used)
    private void moveToHead(Node<K, V> node) {
        remove(node);
        addToHead(node);
    }

    // add node after dummy head
    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // remove node from list
    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // remove least recently used (before tail)
    private Node<K, V> removeTail() {
        Node<K, V> lru = tail.prev;
        remove(lru);
        return lru;
    }

    public static void main(String[] args) {
        // Create an LRU cache with capacity 2
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "A"); // Cache: 1->A
        cache.put(2, "B"); // Cache: 2->B, 1->A
        System.out.println(cache.get(1)); // Access 1 (returns "A"), Cache: 1->A, 2->B
        cache.put(3, "C"); // Evicts key 2, Cache: 3->C, 1->A
        System.out.println(cache.get(2)); // Not found (evicted), returns null
        cache.put(4, "D"); // Evicts key 1, Cache: 4->D, 3->C
        System.out.println(cache.get(1)); // Not found (evicted), returns null
        System.out.println(cache.get(3)); // Returns "C", Cache: 3->C, 4->D
        System.out.println(cache.get(4)); // Returns "D", Cache: 4->D, 3->C
    }
}
