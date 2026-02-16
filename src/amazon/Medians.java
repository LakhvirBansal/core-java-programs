package amazon;

import java.util.*;
public class Medians {

    public static List<Integer> medians(List<Integer> values, int k) {
        int n = values.size();

        // Sort array
        Collections.sort(values);

        // index of median inside any subsequence of size k
        int medianIndex = (k - 1) / 2;

        // minimum median -> from k smallest elements
        int minMedian = values.get(medianIndex);

        // maximum median -> from k largest elements
        int maxMedian = values.get(n - k + medianIndex);

        List<Integer> ans = new ArrayList<>();
        ans.add(maxMedian);
        ans.add(minMedian);

        return ans;
    }

    public static void main(String[] args){

        List<Integer> values = Arrays.asList(1,2,3);
        int k = 2;

        List<Integer> res = Medians.medians(values, k);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
}
