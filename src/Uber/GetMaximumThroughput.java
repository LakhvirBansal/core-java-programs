package Uber;

import java.util.*;
public class GetMaximumThroughput {

    public static int getMaximumThroughput(List<Integer> throughput,
                                           List<Integer> scalingCost,
                                           int budget) {

        long low = 0;
        long high = (long) 1e18;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canAchieve(mid, throughput, scalingCost, budget)) {
                ans = mid;
                low = mid + 1;  // try bigger throughput
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private static boolean canAchieve(long target,
                                      List<Integer> throughput,
                                      List<Integer> scalingCost,
                                      long budget) {

        long totalCost = 0;

        for (int i = 0; i < throughput.size(); i++) {

            long base = throughput.get(i);

            if (base >= target) continue;

            // number of scales needed
            long required = (target + base - 1) / base; // ceil(target/base)
            long x = required - 1;

            totalCost += x * scalingCost.get(i);

            if (totalCost > budget) return false;
        }

        return totalCost <= budget;
    }

    public static void main(String[] args) {

        List<Integer> throughput = Arrays.asList(4,2,7);
        List<Integer> scalingCost = Arrays.asList(3,5,6);

        int budget = 32;

        int result = GetMaximumThroughput.getMaximumThroughput(throughput, scalingCost, budget);
        System.out.println(result);


    }
}
