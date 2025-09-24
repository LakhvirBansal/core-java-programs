package Chase;

import java.util.*;
public class getMinCores {

    public static int getMinCores(List<Integer> start, List<Integer> end) {
        int n = start.size();

        // Convert Lists to arrays for easier sorting
        int[] startArr = start.stream().mapToInt(i -> i).toArray();
        int[] endArr = end.stream().mapToInt(i -> i).toArray();

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int i = 0, j = 0;
        int currentCores = 0, maxCores = 0;

        while (i < n && j < n) {
            if (startArr[i] <= endArr[j]) {
                currentCores++;
                maxCores = Math.max(maxCores, currentCores);
                i++;
            } else {
                currentCores--;
                j++;
            }
        }

        return maxCores;
    }

    public static void main(String[] args) {
        // Example 1
        List<Integer> start1 = Arrays.asList(1, 3, 4);
        List<Integer> end1 = Arrays.asList(3, 5, 6);
        System.out.println(getMinCores(start1, end1)); // Output: 2

        // Example 2
        List<Integer> start2 = Arrays.asList(1, 2, 3);
        List<Integer> end2 = Arrays.asList(3, 3, 5);
        System.out.println(getMinCores(start2, end2)); // Output: 3

        // Example 3
        List<Integer> start3 = Arrays.asList(1, 4, 7);
        List<Integer> end3 = Arrays.asList(2, 4, 10);
        System.out.println(getMinCores(start3, end3)); // Output: 1
    }
}
