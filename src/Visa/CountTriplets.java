package Visa;

import java.util.*;

public class CountTriplets {

    public static int[] solution(String[] queries, int diff) {
        List<Integer> numbers = new ArrayList<>();
        int[] result = new int[queries.length];

        // Use a map to store the frequency of each number
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            String operator = query.substring(0, 1);
            int value = Integer.parseInt(query.substring(1));

            if (operator.equals("+")) {
                numbers.add(value);
                freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
            } else if (operator.equals("-")) {
                // Remove all occurrences of 'value'
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) == value) {
                        numbers.remove(j);
                        j--; // Important: Adjust index after removal
                    }
                }
                freqMap.remove(value);
            }
            result[i] = countTriplets(numbers, diff, freqMap);
        }
        return result;
    }

    private static int countTriplets(List<Integer> numbers, int diff, Map<Integer, Integer> freqMap) {
        int count = 0;
        if (numbers.size() < 3) {
            return 0; // Not enough elements for a triplet
        }



        for (int y : freqMap.keySet()) {
            int x = y + diff;
            int z = y - diff;
            if (freqMap.containsKey(x) && freqMap.containsKey(z)) {
                count += (long)freqMap.get(x) * freqMap.get(y) * freqMap.get(z);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] queries = {"+4", "+5", "+6", "+4", "+3", "-4"};
        int diff = 1;

        System.out.println(Arrays.toString(solution(queries, diff))); // Expected: [0, 0, 1, 2, 4, 0]
    }

}
