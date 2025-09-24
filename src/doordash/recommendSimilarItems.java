package doordash;
import java.util.*;
public class recommendSimilarItems {

    static class Pair {
        int diff;
        int value;

        Pair(int diff, int value) {
            this.diff = diff;
            this.value = value;
        }
    }

    public static List<Integer> recommendSimilarItems(List<Integer> items, int mostSimilarItems, int targetItem) {
        // Max heap: largest diff at top
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.diff != b.diff) return b.diff - a.diff;
            return b.value - a.value; // Optional tie-breaker on value
        });

        for (int val : items) {
            int diff = Math.abs(val - targetItem);
            Pair pair = new Pair(diff, val);

            if (maxHeap.size() < mostSimilarItems) {
                maxHeap.offer(pair);
            } else if (diff < maxHeap.peek().diff ||
                    (diff == maxHeap.peek().diff && val < maxHeap.peek().value)) {
                maxHeap.poll();
                maxHeap.offer(pair);
            }
        }

        // Extract result from heap
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().value);
        }

        // Optional: sort result by closeness
        // result.sort((a, b) -> {
        //     int da = Math.abs(a - targetItem), db = Math.abs(b - targetItem);
        //     return da != db ? da - db : a - b;
        // });
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
        int mostSimilarItems = 4;
        int targetItem = 3;

        List<Integer> result = recommendSimilarItems(items, mostSimilarItems, targetItem);
        System.out.println(result); // Example: [3, 2, 2, 4]
    }
}
