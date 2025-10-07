package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class findMaximumValue {

    public static List<Integer> findMaximumValue(List<Integer> prices, List<Integer> pos, List<Long> amount) {
        int n = prices.size();
        int q = pos.size();
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + prices.get(i - 1);
        }
        List<Integer> answers = new ArrayList<>(q);
        for (int i = 0; i < q; ++i) {
            int start = pos.get(i);
            long budget = amount.get(i);
            int left = start, right = n, best = start - 1;
            long base = prefix[start - 1];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long cost = prefix[mid] - base;
                if (cost <= budget) {
                    best = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answers.add(best - (start - 1));
        }
        return answers;
    }
    public static void main(String[] args) throws Exception {

        int n = 5;
        List<Integer> prices = Arrays.asList(3,4,5,5,7);

        int q = 3;
        List<Integer> pos = Arrays.asList(2,1,5);
        List<Long> amount = Arrays.asList(10L, 24L, 5L);

        List<Integer> ans = findMaximumValue(prices, pos, amount);
        for (int v : ans) {
            System.out.println(v);
        }
    }
}
