package amazon;

import java.util.*;

public class WordBreaker {

    /*
    Set<String> wordSet: For O(1) lookup to check if a substring exists in our input list.
    List<String> result: To store combinations like superhighway --> super, highway
    Memoization (Map<String, List<List<String>>>): To avoid recomputing splits.
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("moon", "light", "moonlight", "rockstar", "rock", "star", "rocks", "tar", "rockstars", "super", "highway", "superhighway", "high", "way");
        findCombinations(words);
    }

    public static void findCombinations(List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        for (String word : wordList) {
            List<List<String>> decompositions = breakWord(word, wordSet, new HashMap<>(), true);
            for (List<String> decomposition : decompositions) {
                if (decomposition.size() >= 2) {
                    System.out.println(word + " --> " + String.join(", ", decomposition));
                }
            }
        }
    }

    // Main DFS with memoization
    public static List<List<String>> breakWord(String word, Set<String> wordSet, Map<String, List<List<String>>> memo, boolean isOriginal) {
        if (!isOriginal && wordSet.contains(word)) {
            return List.of(List.of(word));
        }

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix)) {
                List<List<String>> suffixBreaks = breakWord(suffix, wordSet, memo, false);
                for (List<String> list : suffixBreaks) {
                    List<String> newList = new ArrayList<>();
                    newList.add(prefix);
                    newList.addAll(list);
                    result.add(newList);
                }
            }
        }

        memo.put(word, result);
        return result;
    }
}

/*
Time & Space Complexity
Let n = number of words, k = average length of word.
Time Complexity: O(n * 2^k)

For each word, we try every partition (2^k possibilities worst-case).
Lookup in HashSet is O(1).

Space Complexity: O(n * 2^k) for memoization + recursion stack.
 */

