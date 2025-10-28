package amazon;

import java.util.*;
public class SortStringInDecreasingByFrequencyCount {

    public static List<String> frequencySort(String s) {
        if (s == null) return null;
        Map<Character, Integer> freqMap = new TreeMap<>();
        for (char ch : s.toCharArray()) {
            // Check for non a-z or A-Z characters
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                return null; // or throw Exception
            }
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        // Sort descending by frequency
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : entryList) {
            result.add(entry.getValue() + "" + entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("baseball")); // valid input
        System.out.println(frequencySort("tree"));     // valid input
        System.out.println(frequencySort("tree!"));    // invalid, returns null
        System.out.println(frequencySort("tr33"));     // invalid, returns null
    }
}
