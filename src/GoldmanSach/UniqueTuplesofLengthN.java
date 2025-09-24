package GoldmanSach;

import java.util.HashSet;

public class UniqueTuplesofLengthN {

    public static HashSet<String> uniqueTuples(String input, int len) {
        HashSet<String> result = new HashSet<>();

        // Edge case: if len is greater than input length or invalid
        if (input == null || len <= 0 || len > input.length()) {
            return result;
        }

        // Sliding window to extract substrings of given length
        for (int i = 0; i <= input.length() - len; i++) {
            result.add(input.substring(i, i + len));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniqueTuples("abacab", 2)); // Expected Output: ["ab", "ba", "ac", "ca"]
        System.out.println(uniqueTuples("aaaa", 2));   // Expected Output: ["aa"]
        System.out.println(uniqueTuples("abcdef", 3)); // Expected Output: ["abc", "bcd", "cde", "def"]
        System.out.println(uniqueTuples("abc", 4));    // Expected Output: []
    }
}
