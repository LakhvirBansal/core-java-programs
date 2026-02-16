package Uber;

import java.util.*;
public class GetMinDifference {

    private static long ceilDiv(long a, long b) {
        return (a + b - 1) / b;
    }

    // Compute total stairs time if we take lift to floor i, then stairs to n.
    // Valid only if for every stair step energy_before >= e2.
    private static long stairsTime(int n, int i, int e1, int e2, int c) {
        int steps = n - i;
        if (steps <= 0) return 0L;

        long energy = (long) i * e1;

        // Must be able to pay e2 for each of the 'steps' stair moves:
        // energy before last step must be >= e2  => initialEnergy >= steps * e2
        if (energy < (long) steps * e2) return Long.MAX_VALUE; // impossible

        long time = 0L;
        for (int s = 0; s < steps; s++) {
            // energy is guaranteed >= e2 here, hence > 0
            time += ceilDiv((long) c, energy);
            energy -= e2; // after step, energy stays >= 0
        }
        return time;
    }

    public static long getMinDifference(int n, int e1, int t1, int e2, int c) {

        // Smallest i such that i*e1 >= (n-i)*e2  => i*(e1+e2) >= n*e2
        int loFeasible = (int) Math.min(n, ceilDiv((long) n * e2, (long) e1 + e2));
        int lo = loFeasible, hi = n;

        // Cache stairsTime for probed i to avoid recomputation
        Map<Integer, Long> cache = new HashMap<>();

        // f(i) = liftTime - stairsTime, we want minimize |f(i)|
        // Find first i where f(i) >= 0 (crossing point)
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            long st = cache.computeIfAbsent(mid, k -> stairsTime(n, k, e1, e2, c));
            long lt = (long) mid * t1;

            // If stairs impossible (shouldn't happen for mid>=loFeasible), treat as need more lift
            if (st == Long.MAX_VALUE) {
                lo = mid + 1;
                continue;
            }

            long f = lt - st;
            if (f >= 0) hi = mid;
            else lo = mid + 1;
        }

        // Check around the boundary (lo and neighbors) to get minimum absolute difference
        long ans = Long.MAX_VALUE;
        for (int i = Math.max(loFeasible, lo - 3); i <= Math.min(n, lo + 3); i++) {
            long st = cache.computeIfAbsent(i, k -> stairsTime(n, k, e1, e2, c));
            if (st == Long.MAX_VALUE) continue; // impossible
            long lt = (long) i * t1;
            ans = Math.min(ans, Math.abs(lt - st));
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;
        int e1 = 2;
        int t1 = 3;
        int e2 = 4;
        int c = 5;

        System.out.println(GetMinDifference.getMinDifference(n, e1, t1, e2, c));
    }
}
