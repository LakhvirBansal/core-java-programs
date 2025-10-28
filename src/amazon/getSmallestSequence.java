package amazon;

import java.io.*;
import java.util.*;

public class getSmallestSequence {

    public static List<Integer> getSmallestSequence(int n, long sequence_sum) {
        long S = (long) n * (n + 1) / 2L;
        long numerator = sequence_sum + S;

        // impossible if numerator out of range or parity mismatch
        if (numerator < 0 || numerator > 2L * S || (numerator & 1L) == 1L) {
            List<Integer> zeros = new ArrayList<>(n);
            for (int i = 0; i < n; i++) zeros.add(0);
            return zeros;
        }

        long S_pos = numerator / 2L; // sum of absolute values that should be positive

        boolean[] positive = new boolean[n + 1]; // positive[i] true => +i, else -i

        if (S_pos > 0) {
            long cum = 0;
            int k = 0;
            // take smallest prefix 1..k until sum >= S_pos
            while (k < n && cum < S_pos) {
                k++;
                cum += k;
            }
            long overshoot = cum - S_pos; // overshoot in [0..k-1]
            // mark 1..k as positive
            for (int i = 1; i <= k; i++) positive[i] = true;
            // if overshoot > 0, remove that number from positives
            if (overshoot > 0) {
                int r = (int) overshoot;
                if (r <= k) positive[r] = false;
            }
        }
        // Build the final list in ascending order WITHOUT sorting:
        // ascending order places all negative numbers first (most negative -> least negative),
        // then positive numbers (smallest -> largest).
        List<Integer> result = new ArrayList<>(n);

        // Add negative values in order: -n, -(n-1), ..., -1 for those indices that are negative
        for (int i = n; i >= 1; i--) {
            if (!positive[i]) result.add(-i);
        }
        // Add positive values in order: 1, 2, ..., n
        for (int i = 1; i <= n; i++) {
            if (positive[i]) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        // Read input (two lines: n and sequence_sum)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());
        line = br.readLine();
        if (line == null) return;
        long sequence_sum = Long.parseLong(line.trim());

        List<Integer> ans = getSmallestSequence(n, sequence_sum);

        // Print each element on its own line (matches sample output)
        StringBuilder sb = new StringBuilder();
        for (int x : ans) {
            sb.append(x).append('\n');
        }
        System.out.print(sb.toString());
    }
}
