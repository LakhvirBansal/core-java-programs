package CapitalOne;

import java.util.*;
public class Order {
    public static int[] solution(int[] heights) {
        List<Integer> arr = new ArrayList<>(heights.length);
        for (int h : heights) arr.add(h);

        List<Integer> order = new ArrayList<>();

        while (true) {
            List<Integer> highlightsIdx = new ArrayList<>();

            // find all highlight indices in the current array
            for (int i = 0; i < arr.size(); i++) {
                int val = arr.get(i);
                boolean leftOk = (i == 0) || (val > arr.get(i - 1));
                boolean rightOk = (i == arr.size() - 1) || (val > arr.get(i + 1));
                if (leftOk && rightOk) highlightsIdx.add(i);
            }

            if (highlightsIdx.isEmpty()) break;

            // pick the highlight with the smallest value (unique heights guaranteed)
            int minIdx = highlightsIdx.get(0);
            for (int idx : highlightsIdx) {
                if (arr.get(idx) < arr.get(minIdx)) minIdx = idx;
            }

            // remove it and append to result
            order.add(arr.remove(minIdx));
        }

        // convert to int[]
        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) res[i] = order.get(i);
        return res;
    }

    // quick test
    public static void main(String[] args) {
        int[] h = {2, 7, 8, 5, 1, 6, 3, 9, 4};
        System.out.println(Arrays.toString(solution(h))); // [6, 8, 7, 5, 2, 9, 4, 3, 1]
    }
}
