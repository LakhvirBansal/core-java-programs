package Microsoft;

import java.util.*;
public class findMinimumLengthSubarray {

    public static int findMinimumLengthSubarray(List<Integer> arr, int k) {
        if (arr == null || arr.isEmpty() || k <= 0) return -1;
        int n = arr.size();
        if (k > n) return -1;
        Map<Integer, Integer> freq = new HashMap<>();
        int distinct = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            int rVal = arr.get(right);
            freq.put(rVal, freq.getOrDefault(rVal, 0) + 1);
            if (freq.get(rVal) == 1) distinct++;
            while (distinct >= k && left <= right) {
                minLen = Math.min(minLen, right - left + 1);
                int lVal = arr.get(left);
                freq.put(lVal, freq.get(lVal) - 1);
                if (freq.get(lVal) == 0) {
                    freq.remove(lVal);
                    distinct--;
                }
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2,2,1,1,3);
        int k = 3;
        System.out.println(findMinimumLengthSubarray(arr, k));
    }
}
