package amazon;

import java.util.*;

public class RearrangeStringNoAdjCharDuplicate {
/*
Steps to Solve the Problem
Count Frequency
Use a HashMap to count the frequency of each character.

Use a Max Heap (PriorityQueue)
Insert all characters sorted by their frequency (higher frequency first).

Rearrange Characters
Extract the most frequent character.
Place it in the result and reduce its frequency.
Extract the second most frequent character and place it.
Push both back into the heap if they still have remaining frequency.

Check for Validity
If the max frequency is greater than (n + 1) / 2, return "" (not possible).
 */
    public static String rearrangeString(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0, n = s.length();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch)); // Track max frequency
        }

        // Step 2: Early Exit if rearrangement is impossible
        if (maxFreq > (n + 1) / 2) return "not valid input.";

        // Step 3: Add all characters to max heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        // Step 4: Build the result using heap
        StringBuilder result = new StringBuilder();
        Queue<Character> waitQueue = new LinkedList<>(); // Secondary queue to ensure proper spacing

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); // Get highest frequency character
            result.append(current);
            freqMap.put(current, freqMap.get(current) - 1); // Reduce frequency

            // Delay reinsertion to avoid adjacent repetition
            waitQueue.add(current);
            if (waitQueue.size() > 1) {
                char front = waitQueue.poll();
                if (freqMap.get(front) > 0) {
                    maxHeap.add(front); // Reinsert when it's safe
                }
            }
        }

        // Step 5: Validate and return result
        return result.length() == n ? result.toString() : "not valid input.";
    }

    public static void main(String[] args) {
        String input1 = "bcaaa";
        System.out.println("Input: " + input1);
        System.out.println("Rearranged String: " + rearrangeString(input1));

        String input2 = "aaabb"; // Valid case
        System.out.println("Input: " + input2);
        System.out.println("Rearranged String: " + rearrangeString(input2));

        String input3 = "aaaa"; // Impossible case
        System.out.println("Input: " + input3);
        System.out.println("Rearranged String: " + rearrangeString(input3));
    }
}


/*
Complexity analysis

Complexity Analysis
Step	                Operation	                Time Complexity
Frequency Count	        HashMap insertion	        O(N)
Max Heap Operations	    Insert all characters	    O(K log K) (K = distinct characters)
Construct Result	    Extract & insert into heap	O(N log K)


Total Complexity	O(N log K)	N = length of string, K = unique characters
Since K ≤ 26 (English letters), complexity is O(N log 26) → O(N).
 */