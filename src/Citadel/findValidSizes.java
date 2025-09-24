package Citadel;

import java.util.*;
public class findValidSizes {

    public static List<Integer> findValidSizes(List<Integer> memoryBlock) {
        int n = memoryBlock.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = memoryBlock.get(i);
        Arrays.sort(a);

        // Step 1: find the largest k such that all 0..k-1 can be ensured present
        int need = 0;                          // next value we must be able to make present
        for (int v : a) {
            if (v <= need) need++;             // this element can be raised to 'need'
            else break;                        // can't make 'need' present -> stop
        }

        // Step 2: candidates are 0..need
        ArrayList<Integer> ans = new ArrayList<>();
        for (int k = 0; k <= need; k++) ans.add(k);

        // Step 3: remove MEX values that can't be made "absent"
        // k = n-1 cannot be removed if any element already equals n-1
        int cntMax = 0, cntZero = 0;
        for (int v : a) {
            if (v == n - 1) cntMax++;
            if (v == 0) cntZero++;
        }
        if (cntMax > 0) {
            int idx = Collections.binarySearch(ans, n - 1);
            if (idx >= 0) ans.remove(idx);
        }
        // k = 0 impossible only when n==1 && the sole element is 0 (can't increment it)
        if (n == 1 && cntZero == 1) {
            if (!ans.isEmpty() && ans.get(0) == 0) ans.remove(0);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {

        int n = 3;
        List<Integer> arr = Arrays.asList(0,3,4);
        List<Integer> res = findValidSizes(arr);
        System.out.print(res);
    }
}
