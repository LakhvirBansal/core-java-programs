package IBM;
import java.util.*;
public class getMinCost {

    public static int getMinCost(List<Integer> dataPoints) {
        if (dataPoints == null || dataPoints.size() <= 1) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(dataPoints);
        long total = 0; // use long for safety while accumulating

        // keep merging the two smallest
        while (minHeap.size() > 1) {
            int a = minHeap.poll();   // smallest
            int b = minHeap.poll();   // second smallest
            int sum = a + b;          // cost of this operation and new point
            total += sum;
            minHeap.offer(sum);       // push merged point back
        }
        return (int) total;           // fits in int under given constraints
    }

    // (Optional) quick main for local testing
    public static void main(String[] args) {
        // Sample 0: [30, 10, 20] -> expected 90
        System.out.println(getMinCost(Arrays.asList(30, 10, 20))); // 90

        // Sample 1: [100, 1] -> expected 101
        System.out.println(getMinCost(Arrays.asList(100, 1)));     // 101

        // Example from prompt: [20, 30, 40] -> 140
        System.out.println(getMinCost(Arrays.asList(20, 30, 40))); // 140
    }
}
