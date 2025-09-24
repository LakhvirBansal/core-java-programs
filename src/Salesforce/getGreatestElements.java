package Salesforce;
import java.util.*;
public class getGreatestElements {

    public static List<Integer> getGreatestElements(List<Integer> arr, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.size(); i++) {
            minHeap.offer(arr.get(i));

            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }

            if (i >= k - 1) {
                result.add(minHeap.peek()); // k-th largest is min of heap
            }
        }

        return result;
    }

    // ✅ Main method for testing
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 4, 5, 2);
        int k = 2;

        List<Integer> result = getGreatestElements(input, k);
        for (int num : result) {
            System.out.println(num);
        }
        // Expected: 1, 3, 4, 4
    }
}
