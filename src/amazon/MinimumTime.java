package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumTime {
    // Returns minimum time after which password is irrecoverable.
    // Irrecoverable when #substrings containing '*' ≥ m.
    public static int findMinimumTime(String password, int[] attackOrder, long m) {
        int n = password.length();
        // Precompute for each position the time (1-based) it gets attacked
        int[] attackTime = new int[n];
        for (int t = 0; t < n; t++) {
            // convert 1-based attackOrder to 0-based index
            attackTime[attackOrder[t] - 1] = t + 1;
        }

        long totalSub = (long) n * (n + 1) / 2;
        // Binary search on time t in [1..n]
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            // Compute substrings without any '*' when we attack up to time mid
            long freeSub = 0;
            long run = 0;
            for (int i = 0; i < n; i++) {
                if (attackTime[i] > mid) {
                    // still a normal character
                    run++;
                } else {
                    // attacked → break run
                    freeSub += run * (run + 1) / 2;
                    run = 0;
                }
            }
            freeSub += run * (run + 1) / 2;
            long badSub = totalSub - freeSub;
            // if badSub ≥ m, irrecoverable by time mid
            if (badSub >= m) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {

        String password = "abc";
        int[] attackOrder = {1,2,3};
        long m = 1;
        int result = findMinimumTime(password, attackOrder, m);
        System.out.println(result);
    }
}
