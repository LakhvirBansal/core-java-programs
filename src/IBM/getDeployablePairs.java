package IBM;
import java.util.*;
public class getDeployablePairs {

    public static long getDeployablePairs(List<Integer> performance, List<Integer> resourceCost) {
        int n = performance.size();

        // Step 1: Convert to diff array: perf[i] - cost[i]
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (long) performance.get(i) - (long) resourceCost.get(i);
        };

        // Step 2: Sort the differences
        Arrays.sort(diff);

        // Step 3: Two-pointer count pairs with sum > 0
        long count = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            if (diff[l] + diff[r] > 0) {
                count += (r - l);
                r--;
            } else {
                l++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int n = 5;
        List<Integer> performance = Arrays.asList(1,2,5);

        List<Integer> resourceCost =  Arrays.asList(1,2,5);

        // Compute result
        long result = getDeployablePairs(performance, resourceCost);
        System.out.println(result);


    }
}
