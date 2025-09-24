package CapitalOne;

import java.util.*;
public class LCP {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    public static int solution(int[] firstArray, int[] secondArray) {
        TrieNode root = new TrieNode();

        // Step 1: Insert all firstArray numbers into Trie
        for (int num : firstArray) {
            String s = Integer.toString(num);
            TrieNode curr = root;
            for (char ch : s.toCharArray()) {
                curr = curr.children.computeIfAbsent(ch, k -> new TrieNode());
            }
        }

        // Step 2: For each number in secondArray, check LCP with Trie
        int maxLCP = 0;

        for (int num : secondArray) {
            String s = Integer.toString(num);
            TrieNode curr = root;
            int len = 0;
            for (char ch : s.toCharArray()) {
                if (curr.children.containsKey(ch)) {
                    curr = curr.children.get(ch);
                    len++;
                    maxLCP = Math.max(maxLCP, len);
                } else {
                    break;
                }
            }
        }

        return maxLCP;
    }

    // Test the code
    public static void main(String[] args) {
        int[] firstArray1 = {25, 288, 2655, 54546, 54, 555};
        int[] secondArray1 = {2, 255, 266, 244, 26, 5, 54547};
        System.out.println(solution(firstArray1, secondArray1)); // Output: 4

        int[] firstArray2 = {25, 288, 2655, 544, 54, 555};
        int[] secondArray2 = {2, 255, 266, 244, 26, 5, 5444444};
        System.out.println(solution(firstArray2, secondArray2)); // Output: 3

        int[] firstArray3 = {817, 99};
        int[] secondArray3 = {1999, 1909};
        System.out.println(solution(firstArray3, secondArray3)); // Output: 0
    }
}
