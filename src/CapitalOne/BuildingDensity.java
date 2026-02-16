package CapitalOne;

import  java.util.*;
public class BuildingDensity {

    public static void main(String[] args) {
        int[] queries = {2,1,3};
        int[] ans = BuildingDensity.solution(queries);

        for (int num : ans){
            System.out.println(num);
        }
    }

    static int[] solution(int[] queries) {

        int n = queries.length;
        int[] ans = new int[n];

        // map stores segment length at boundaries
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int x = queries[i];

            int left = map.getOrDefault(x - 1, 0);
            int right = map.getOrDefault(x + 1, 0);

            int newLen = left + 1 + right;

            // update max
            maxLen = Math.max(maxLen, newLen);

            ans[i] = maxLen;

            // update boundaries
            map.put(x, newLen);
            map.put(x - left, newLen);
            map.put(x + right, newLen);
        }

        return ans;
    }
}
