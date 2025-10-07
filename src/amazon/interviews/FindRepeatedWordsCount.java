package amazon.interviews;

import java.util.*;
import java.util.stream.*;
public class FindRepeatedWordsCount {
    public static void main(String[] args) {
        String input = "hello java world hello hello java";

        // Step 1: Split sentence to words
        Map<String, Long> wordCounts = Arrays.stream(
                input.split("\\s+"))
                .collect(Collectors.groupingBy(
                        word -> word, Collectors.counting()));

        // Step 2: Filter only repeated words (count > 1)
        Map<String, Long> repeatedWords = wordCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue));

        System.out.println(repeatedWords); // Output: {hello=3, java=2}
    }
}
