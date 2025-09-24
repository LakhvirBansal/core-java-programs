package amazon;

import java.util.Arrays;
import java.util.List;

public class MinimumProcessDrops {

    public static int getMinimumRemovals(List<Integer> starts, List<Integer> ends) {
        int n = starts.size();
        // build and sort arrays of all starts and ends
        int[] S = new int[n], E = new int[n];
        for (int i = 0; i < n; i++) {
            S[i] = starts.get(i);
            E[i] = ends.get(i);
        }
        Arrays.sort(S);
        Arrays.sort(E);

        int best = n;  // worst‐case remove all but one
        for (int i = 0; i < n; i++) {
            int s = starts.get(i), e = ends.get(i);
            // intervals ending strictly before s:
            int leftNonOverlap = lowerBound(E, s);
            // intervals starting strictly after e:
            int rightNonOverlap = n - upperBound(S, e);
            best = Math.min(best, leftNonOverlap + rightNonOverlap);
        }
        return best;
    }

    // first index in arr[] where arr[idx] >= target
    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // first index in arr[] where arr[idx] > target
    private static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1,2,3,4);
        List<Integer> ends =  Arrays.asList(2,3,5,5);
        System.out.print(getMinimumRemovals(start, ends));
    }
}
