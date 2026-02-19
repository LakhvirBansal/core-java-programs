package Uber;

import java.util.*;
public class FindMaximumValue {

    public static List<Integer> findMaximumValue(List<Integer> prices,
                                                 List<Integer> pos,
                                                 List<Long> amount) {

        int n = prices.size();
        long[] prefix = new long[n + 1];

        // Build prefix sum array (1-based indexing)
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + prices.get(i - 1);
        }

        List<Integer> result = new ArrayList<>();

        // Process each query
        for (int i = 0; i < pos.size(); i++) {

            int start = pos.get(i);
            long budget = amount.get(i);

            int left = start;
            int right = n;
            int ans = start - 1;

            // Binary Search
            while (left <= right) {

                int mid = left + (right - left) / 2;

                long totalCost = prefix[mid] - prefix[start - 1];

                if (totalCost <= budget) {
                    ans = mid;      // valid
                    left = mid + 1; // try more
                } else {
                    right = mid - 1;
                }
            }

            result.add(ans - start + 1);
        }

        return result;
    }

    public static void main(String[] args) {



        int n = 5;

        List<Integer> prices = Arrays.asList(3,4,5,5,7);

        int q = 3;

        List<Integer> pos =Arrays.asList(2,1,5);

        List<Long> amount = Arrays.asList(10l,24l,5l);

        List<Integer> ans = FindMaximumValue.findMaximumValue(prices, pos, amount);

        for (int val : ans) {
            System.out.println(val);
        }
    }
}
