package amazon;
/**
 * <img src="doc-files/acquireLock.png" alt="Logo">
 *
 */
import java.io.*;
import java.util.*;
public class calculateMinSeriesWindow {

    public static int calculateMinSeriesWindow(List<Integer> watch_history, int series1, int series2) {
        int n = watch_history.size();
        if (series1 == series2) return 1;

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, count1 = 0, count2 = 0, distinct = 0;
        int minScore = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            int x = watch_history.get(right);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) == 1) distinct++;
            if (x == series1) count1++;
            if (x == series2) count2++;

            // shrink while both targets are still covered
            while (count1 > 0 && count2 > 0) {
                minScore = Math.min(minScore, distinct);
                int y = watch_history.get(left);
                boolean canRemove =
                        (y != series1 && y != series2) ||
                                (y == series1 && count1 > 1) ||
                                (y == series2 && count2 > 1);
                if (!canRemove) break;

                // remove y
                int c = freq.get(y);
                if (c == 1) {
                    freq.remove(y);
                    distinct--;
                } else {
                    freq.put(y, c - 1);
                }
                if (y == series1) count1--;
                if (y == series2) count2--;
                left++;
            }
        }

        return minScore;
    }

    public static void main(String[] args) throws IOException {
        int n = 5;
        List<Integer> watch_history = Arrays.asList(1,3,2,1,4);
        int series1 = 1;
        int series2 = 2;

        int answer = calculateMinSeriesWindow(watch_history, series1, series2);
        System.out.println(answer);
    }

}
