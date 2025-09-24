package Citadel;

import java.util.*;
public class getMinProcessingCost {

    // Returns minimum total cost modulo 1e9+7
    public static int getMinProcessingCost(List<Integer> filterCost,
                                           List<Integer> startDay,
                                           List<Integer> endDay,
                                           int discountPrice) {
        final long MOD = 1_000_000_007L;
        int n = filterCost.size();
        TreeMap<Long, Long> diff = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long s = startDay.get(i);
            long ePlus = (long) endDay.get(i) + 1L;
            long c = filterCost.get(i);
            diff.put(s, diff.getOrDefault(s, 0L) + c);
            diff.put(ePlus, diff.getOrDefault(ePlus, 0L) - c);
        }
        long ans = 0, curSum = 0;
        long prev = 0;
        boolean first = true;
        for (Map.Entry<Long, Long> entry : diff.entrySet()) {
            long day = entry.getKey();
            if (!first) {
                long span = day - prev;
                long perDay = Math.min(curSum, (long) discountPrice);
                if (perDay < 0)
                    perDay = 0;
                ans = (ans + ((span % MOD) * (perDay % MOD)) % MOD) % MOD;
            }
            curSum += entry.getValue();
            prev = day;
            first = false;
        }

        return (int) (ans % MOD);
    }


    public static void main(String[] args) throws Exception {
        int n = 3;
        List<Integer> filterCost = Arrays.asList(2,3,4);
        List<Integer> startDay = Arrays.asList(1,1,2);
        List<Integer> endDay = Arrays.asList(2,3,4);
        int discountPrice = 6;
        System.out.println(getMinProcessingCost(filterCost, startDay, endDay, discountPrice));
    }
}
