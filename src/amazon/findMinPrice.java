package amazon;

import java.io.*;
import java.util.*;

public class findMinPrice {
    public static long findMinPrice(List<Integer> cost, int pairCost, int k) {
        int n = cost.size();

        // 1) Build prefix sums: p[i] = cost[0] + … + cost[i-1]
        long[] p = new long[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + cost.get(i);
        }
        long totalSum = p[n];

        // 2) Build transformed array: table[i] = 2*p[i] - pairCost*i
        //    This lets us compute, for any segment [i…j-1] of even length,
        //    savings*2 = table[j] - table[i].
        long[] table = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            table[i] = 2L * p[i] - (long) pairCost * i;
        }

        // 3) Two monotonic deques (one for even i, one for odd i)
        @SuppressWarnings("unchecked")
        Deque<Integer>[] deq = new ArrayDeque[2];
        deq[0] = new ArrayDeque<>();
        deq[1] = new ArrayDeque<>();

        long maxDoubleSavings = 0;    // this will store 2 * best savings

        // Slide j from 0…n
        for (int j = 0; j <= n; j++) {
            // Remove any i < j - 2*k, since you can't pair more than k times
            int lower = j - 2*k;
            if (lower > 0) {
                for (int parity = 0; parity < 2; parity++) {
                    Deque<Integer> dq = deq[parity];
                    while (!dq.isEmpty() && dq.peekFirst() < lower) {
                        dq.removeFirst();
                    }
                }
            }

            int parity = j & 1;
            Deque<Integer> dq = deq[parity];
            long vj = table[j];

            // Maintain dq in increasing order of table[*]
            while (!dq.isEmpty() && table[dq.peekLast()] >= vj) {
                dq.removeLast();
            }
            dq.addLast(j);

            // Best i for this j is at dq.peekFirst()
            long best = table[dq.peekFirst()];
            long cur  = vj - best;         // = 2 * (actual savings)
            if (cur > maxDoubleSavings) {
                maxDoubleSavings = cur;
            }
        }

        long maxSavings = maxDoubleSavings / 2;
        return totalSum - maxSavings;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1) read n
        int n = Integer.parseInt(st.nextToken());

        // 2) read cost[], either all on one line or one-per-line
        List<Integer> cost = new ArrayList<>(n);
        while (cost.size() < n) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
                continue;
            }
            cost.add(Integer.parseInt(st.nextToken()));
        }

        // 3) read pairCost
        st = new StringTokenizer(br.readLine());
        int pairCost = Integer.parseInt(st.nextToken());

        // 4) read k
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        // 5) compute and print
        System.out.println(findMinPrice(cost, pairCost, k));
    }
}