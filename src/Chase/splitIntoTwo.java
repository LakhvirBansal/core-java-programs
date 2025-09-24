package Chase;

import java.util.*;
public class splitIntoTwo {

    public static int splitIntoTwo(List<Integer> arr) {
        int n = arr.size();

        // Step 1: compute total sum of the array
        long total = arr.stream().mapToLong(i -> i).sum();

        long leftSum = 0;
        int count = 0;

        // Step 2: iterate and count valid splits
        for (int i = 0; i < n - 1; i++) {
            leftSum += arr.get(i);
            long rightSum = total - leftSum;
            if (leftSum > rightSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> arr1 = Arrays.asList(10, 4, -8, 7);
        System.out.println(splitIntoTwo(arr1)); // Output: 2

        // Example 2
        List<Integer> arr2 = Arrays.asList(10, -5, 6);
        System.out.println(splitIntoTwo(arr2)); // Output: 1

        // Example 3
        List<Integer> arr3 = Arrays.asList(-3, -2, 10, 20, -30);
        System.out.println(splitIntoTwo(arr3)); // Output: 2
    }
}
