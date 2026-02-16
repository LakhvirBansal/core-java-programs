package Uber;

import java.util.*;
public class MaxGameScore {

    public static int maxGameScore(List<Integer> cell) {
        int n = cell.size();

        // Precompute primes up to n
        boolean[] isPrime = sieve(n);

        // Collect primes ending with digit 3
        List<Integer> validPrimes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && i % 10 == 3) {
                validPrimes.add(i);
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = 0; // start at cell 0

        for (int i = 1; i < n; i++) {

            // move from i-1
            if (dp[i - 1] != Integer.MIN_VALUE) {
                dp[i] = dp[i - 1] + cell.get(i);
            }

            // move using prime jumps ending with 3
            for (int p : validPrimes) {
                if (p > i) break;

                if (dp[i - p] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - p] + cell.get(i));
                }
            }
        }

        return dp[n - 1];
    }

    // Sieve of Eratosthenes
    private static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {

        List<Integer> cell = Arrays.asList(0,-10,-20,-30,50);

        int result = MaxGameScore.maxGameScore(cell);
        System.out.println(result);
    }
}
