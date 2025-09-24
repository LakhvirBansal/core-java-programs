package amazon;

import java.io.*;
import java.util.*;

public class getMaximumBalancedShipments {
    /*
     * Complete the 'getMaximumBalancedShipments' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY weight as parameter.
     */
    public static int getMaximumBalancedShipments(List<Integer> weight) {
        int n = weight.size();
        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = weight.get(i);
        }

        // 1) Compute lastGreater[j] = index of the nearest previous k<j with w[k] > w[j], or -1
        int[] lastGreater = new int[n];
        Deque<Integer> stk = new ArrayDeque<>();
        for (int j = 0; j < n; j++) {
            while (!stk.isEmpty() && w[stk.peek()] <= w[j]) {
                stk.pop();
            }
            lastGreater[j] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(j);
        }

        // 2) dp[i] = max shipments covering w[0..i-1], or a large negative if impossible
        //    prefix[i] = max(dp[0..i])
        final int NEG = Integer.MIN_VALUE / 2;
        int[] dp = new int[n + 1], prefix = new int[n + 1];
        dp[0] = 0;
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = NEG;
            // we'll set prefix[i] after possibly updating dp[i]
            prefix[i] = prefix[i-1];
        }

        // 3) Fill dp via: for each j>=1, if lastGreater[j]>=0 then
        //      dp[j+1] = max(dp[j+1], prefix[lastGreater[j]] + 1)
        //    because any segment ending at j with start p ≤ lastGreater[j] is balanced,
        //    and prefix[..] gives the best dp[p].
        for (int j = 1; j < n; j++) {
            int lg = lastGreater[j];
            if (lg >= 0) {
                // segment [p..j] balanced for any p≤lg, so best is prefix[lg]
                dp[j+1] = Math.max(dp[j+1], prefix[lg] + 1);
            }
            // update running max
            prefix[j+1] = Math.max(prefix[j], dp[j+1]);
        }

        // 4) dp[n] is best if we can cover entire array; else <= 0
        return dp[n] > 0 ? dp[n] : 0;
    }

    public static void main(String[] args) {
        int n = 6;
        List<Integer> weight = Arrays.asList(1,2,3,2,6,3);
        int ans = getMaximumBalancedShipments(weight);
        System.out.println(ans);
    }
}
