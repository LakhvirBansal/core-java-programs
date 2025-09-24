package caspex;

import java.util.Arrays;
import java.util.List;

public class GrandNumberGame {

    public static int solve(List<Integer> arr) {
        int n = arr.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = arr.get(i);

        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);

        return dfs(nums, 0, 1, dp);
    }

    private static int dfs(int[] nums, int mask, int op, int[] dp) {
        if (mask == (1 << nums.length) - 1) return 0; // All used

        if (dp[mask] != -1) return dp[mask];

        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) continue; // already used
            for (int j = i + 1; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) continue;

                int newMask = mask | (1 << i) | (1 << j);
                int score = op * gcd(nums[i], nums[j]);
                int remaining = dfs(nums, newMask, op + 1, dp);
                maxScore = Math.max(maxScore, score + remaining);
            }
        }

        return dp[mask] = maxScore;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,4,9,5);
        Integer result = solve(nums);
        System.out.println("result is :"+ result);
    }
}
