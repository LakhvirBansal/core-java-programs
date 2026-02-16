package Expedia;

import java.util.Arrays;
import java.util.List;
public class GetMaximumTeamSize {

    public static int getMaximumTeamSize(List<Integer> startTime, List<Integer> endTime) {
        int n = startTime.size();
        if (n == 0) return 0;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = startTime.get(i);
            ends[i] = endTime.get(i);
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int best = 1;
        for (int i = 0; i < n; i++) {
            int s = startTime.get(i);
            int e = endTime.get(i);
            int cntStartLeE = upperBound(starts, e);
            int cntEndLtS = lowerBound(ends, s);
            int overlaps = cntStartLeE - cntEndLtS;
            if (overlaps > best) best = overlaps;
        }
        return best;
    }
    private static int lowerBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    private static int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args){

        List<Integer> starts = Arrays.asList(1,6,4,3,1);
        List<Integer> ends = Arrays.asList(2,7,5,8,2);
        int ans = getMaximumTeamSize(starts, ends);
        System.out.println(ans);
    }

}
