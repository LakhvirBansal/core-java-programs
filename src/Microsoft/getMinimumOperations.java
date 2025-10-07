package Microsoft;

import java.io.*;
import java.util.*;

public class getMinimumOperations {

    public static long getMinimumOperations(List<Long> source, List<Long> target) {
        int n = source.size();
        long[] need = new long[n];
        for (int i = 0; i < n; ++i) {
            need[i] = target.get(i) - source.get(i);
            if (need[i] < 0) return -1L;
        }
        if (n == 1) return need[0];
        long sumL = 0L;
        for (int i = 0; i < n - 1; ++i) {
            long delta = need[i + 1] - need[i];
            if (delta < 0) sumL += -delta;
        }
        if (sumL > need[0]) return -1L;
        return sumL + need[n - 1];
    }
    
    
    public static void main(String[] args) throws Exception {
        int n = 3;
        List<Long> source = Arrays.asList(1L,2L,2L);
        List<Long> target = Arrays.asList(2L,2L,3L);
        long ans = getMinimumOperations(source, target);
        System.out.println(ans);
    }
}
