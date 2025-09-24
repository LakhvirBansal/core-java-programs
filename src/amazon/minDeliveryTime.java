package amazon;

import java.util.Arrays;
import java.util.List;

public class minDeliveryTime {

    public static int minDeliveryTime(int n, List<Integer> orderCityList) {
        int m = orderCityList.size();
        int[] cnt = new int[n + 1];
        for (int city : orderCityList) cnt[city]++;
        int lo = 0, hi = 2 * m;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (feasible(cnt, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private static boolean feasible(int[] cnt, int T) {
        long need = 0;
        long free = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > T) {
                need += cnt[i] - T;
            } else {
                free += (T - cnt[i]) / 2;
            }
        }
        return free >= need;
    }

    public static void main(String[] args) throws Exception {
        int n = 3;
        List<Integer> orders = Arrays.asList(1,1,3,1,1);
        int ans = minDeliveryTime(n, orders);
        System.out.println(ans);
    }
}
