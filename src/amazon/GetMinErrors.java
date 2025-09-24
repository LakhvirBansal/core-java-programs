package amazon;

import java.io.*;
import java.util.*;

public class GetMinErrors {
    static final int MOD = 1_000_000_007;
    public static int getMinErrors(String s, int x, int y) {
        int n = s.length();
        // 1) Count fixed 0/1 subsequences among the known bits
        long count0 = 0, count1 = 0;
        long fixed01 = 0, fixed10 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                // each prior '1' with this '0' makes a "10"
                fixed10 += count1;
                count0++;
            } else if (c == '1') {
                // each prior '0' with this '1' makes a "01"
                fixed01 += count0;
                count1++;
            }
        }
        long fixedCost = fixed01 * x + fixed10 * y;

        // 2) Gather the !-positions; at each we will choose 0 or 1
        int k = 0;
        for (char c : s.toCharArray()) if (c == '!') k++;
        long[] f0 = new long[k], f1 = new long[k];

        // prefix counts of fixed 0/1 to compute cost of assigning each !
        long seen0 = 0, seen1 = 0;
        long total0 = count0, total1 = count1;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                seen0++;
            } else if (c == '1') {
                seen1++;
            } else { // '!'
                // if we assign '!'→0, cost vs fixed bits:
                //   each prior '1' gives a "10"→ y
                //   each later '1' gives a "01"→ x
                f0[idx] = seen1 * y + (total1 - seen1) * x;

                // if we assign '!'→1, cost vs fixed bits:
                //   each prior '0' gives a "01"→ x
                //   each later '0' gives a "10"→ y
                f1[idx] = seen0 * x + (total0 - seen0) * y;

                idx++;
            }
        }

        // 3) Now handle the interactions among the k stars.
        //    If x >= y, optimal star-string is all 1s then all 0s;
        //    otherwise all 0s then all 1s.
        long best = Long.MAX_VALUE;
        if (x >= y) {
            // prefix sums of f1, prefix sums of f0
            long[] pref1 = new long[k+1], pref0 = new long[k+1];
            for (int i = 1; i <= k; i++) {
                pref1[i] = pref1[i-1] + f1[i-1];
                pref0[i] = pref0[i-1] + f0[i-1];
            }
            long totalF0 = pref0[k];
            // try p = #ones among the k, these come first
            for (int p = 0; p <= k; p++) {
                // cost_fixed + stars_fixed + cost_among
                long costStars = pref1[p]                     // first p as 1
                        + (totalF0 - pref0[p])       // rest k-p as 0
                        + (long)y * p * (k - p);     // y * #(1–0) pairs
                best = Math.min(best, costStars);
            }
        } else {
            // x < y: optimal is zeros then ones
            long[] pref0 = new long[k+1], pref1 = new long[k+1];
            for (int i = 1; i <= k; i++) {
                pref0[i] = pref0[i-1] + f0[i-1];
                pref1[i] = pref1[i-1] + f1[i-1];
            }
            long totalF1 = pref1[k];
            // try p = #zeros among k, these come first
            for (int p = 0; p <= k; p++) {
                long costStars = pref0[p]                     // first p as 0
                        + (totalF1 - pref1[p])       // rest k-p as 1
                        + (long)x * p * (k - p);     // x * # (0–1) pairs
                best = Math.min(best, costStars);
            }
        }

        long ans = (fixedCost + best) % MOD;
        return (int)ans;
    }

    public static void main(String[] args) throws IOException {
        String s = "101!1";
        int x = 2;
        int y = 3;
        System.out.println(getMinErrors(s, x, y));

    }
}
