package caspex;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * This class implements a Node for the Doubly Linked List used in the LRU Cache.
 * Each node stores a key-value pair.
 */
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/*
 * This class implements the LRU Cache logic.
 * It uses a HashMap for O(1) lookups and a Doubly Linked List for tracking usage order.
 */
class LRUCache {
    private Map<Integer, Node> cache; // Stores key -> Node mapping for O(1) access
    private LinkedList<Node> dll;     // Doubly Linked List to maintain usage order
    private int capacity;             // Maximum capacity of the cache

    /*
     * Constructor to initialize the LRU Cache with a given capacity.
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.dll = new LinkedList<>();
    }

    /*
     * Returns the value of the key if it exists in the cache.
     * If the key exists, it is marked as recently used by moving it to the front of the DLL.
     * Returns -1 if the key does not exist.
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }

        Node node = cache.get(key);
        // Move the accessed node to the front (most recently used)
        moveToFront(node);
        return node.value;
    }

    /*
     * Updates the value of the key if it exists.
     * If the key does not exist, adds the key-value pair to the cache.
     * If adding a new key exceeds the capacity, the least recently used key is evicted.
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Key already exists, update its value and move to front
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // New key
            if (cache.size() >= capacity) {
                // Cache is full, evict the least recently used item (tail of DLL)
                removeLeastRecentlyUsed();
            }
            // Add new node to the front of the DLL and to the cache map
            Node newNode = new Node(key, value);
            addNodeToFront(newNode);
            cache.put(key, newNode);
        }
    }

    /*
     * Helper method to move a node to the front of the Doubly Linked List,
     * signifying it as the most recently used.
     */
    private void moveToFront(Node node) {
        // First, remove the node from its current position
        dll.remove(node);
        // Then, add it to the front
        dll.addFirst(node);
    }

    /*
     * Helper method to add a new node to the front of the Doubly Linked List.
     */
    private void addNodeToFront(Node node) {
        dll.addFirst(node);
    }

    /*
     * Helper method to remove the least recently used node from the cache.
     * This is the node at the tail of the Doubly Linked List.
     */
    private void removeLeastRecentlyUsed() {
        if (!dll.isEmpty()) {
            Node lastNode = dll.removeLast(); // Get and remove the tail node
            cache.remove(lastNode.key);     // Remove from the HashMap
        }
    }
}

/*
 * Main class for processing input and generating output for the LRU Cache operations.
 */
class Outcome {
    /**
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters:
     * 1. capacity (int): capacity of the cache.
     * 2. ar (List<String>): list of operations (GET/PUT commands).
     *
     * Returns a List<Integer> representing the results of GET operations.
     */
    public static List<Integer> solve(int capacity, List<String> ar) {
        // Initialize the LRU Cache with the given capacity
        LRUCache lruCache = new LRUCache(capacity);
        List<Integer> result = new LinkedList<>(); // To store results of GET operations

        // Process each operation in the input list
        for (String operation : ar) {
            String[] parts = operation.split(","); // Split the operation string by comma
            String command = parts[0].trim();      // Get the command (GET or PUT)

            if (command.equals("GET")) {
                int key = Integer.parseInt(parts[1].trim()); // Parse the key
                result.add(lruCache.get(key));               // Perform GET and add result
            } else if (command.equals("PUT")) {
                int key = Integer.parseInt(parts[1].trim());     // Parse the key
                int value = Integer.parseInt(parts[2].trim());   // Parse the value
                lruCache.put(key, value);                        // Perform PUT operation
            }
        }
        return result; // Return the list of GET operation results
    }

    public static void main(String[] args) throws IOException {
        // Standard input reading for capacity and operations
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> operations = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            operations.add(bufferedReader.readLine().trim());
        }

        // Call the solve method to get the results
        List<Integer> result = solve(capacity, operations);

        // Print the results to standard output
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(); // New line at the end
        bufferedReader.close();
    }
}

