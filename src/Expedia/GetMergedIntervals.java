package Expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GetMergedIntervals {

    public static List<List<Integer>> getMergedIntervals(List<List<Integer>> intervals) {
        List<List<Integer>> merged = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) return merged;
        intervals.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        int curStart = intervals.get(0).get(0);
        int curEnd = intervals.get(0).get(1);
        for (int i = 1; i < intervals.size(); i++) {
            int s = intervals.get(i).get(0);
            int e = intervals.get(i).get(1);
            if (s <= curEnd) {
                if (e > curEnd) curEnd = e;
            } else {
                merged.add(Arrays.asList(curStart, curEnd));
                curStart = s;
                curEnd = e;
            }
        }
        merged.add(Arrays.asList(curStart, curEnd));
        return merged;
    }

    public static void main(String[] args) throws Exception {

        List<List<Integer>> intervals = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(7,7);
        List<Integer> l2 = Arrays.asList(2,3);
        List<Integer> l3 = Arrays.asList(6,11);
        List<Integer> l4 = Arrays.asList(1,2);
        intervals.add(l1);
        intervals.add(l2);
        intervals.add(l3);
        intervals.add(l4);

        List<List<Integer>> merged = getMergedIntervals(intervals);
        for (List<Integer> iv : merged) {
            System.out.println(iv.get(0) + " " + iv.get(1));
        }

    }
}
