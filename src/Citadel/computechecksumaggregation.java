package Citadel;

public class computechecksumaggregation {

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Checksum for n = " + n + " is: " + computechecksumaggregation(n)); // Should print 24
    }

    private static final long MOD = 1000000007;

    public static long sum_up_to(long k) {
        // Calculate (k * (k+1) / 2) % MOD
        long term1 = k;
        long term2 = k + 1;

        if (term1 % 2 == 0) {
            term1 /= 2;
        } else {
            term2 /= 2;
        }

        return (term1 % MOD * (term2 % MOD)) % MOD;
    }

    public static int computechecksumaggregation(int n) {
        long totalSum = 0;

        for (int j = 1; j <= n; j++) {
            long q = (long) n / j;
            long r = (long) n % j;

            // Sum of i % j for i=1 to n
            // Formula: q * (j * (j-1) / 2) + r * (r+1) / 2

            // First part: q * (sum_up_to(j-1))
            long sum_j_1 = sum_up_to(j - 1);
            long term1 = (q % MOD * sum_j_1) % MOD;

            // Second part: sum_up_to(r)
            long term2 = sum_up_to(r);

            long sum_for_j = (term1 + term2) % MOD;

            totalSum = (totalSum + sum_for_j) % MOD;
        }

        // Final result is 2 * totalSum
        return (int) ((2 * totalSum) % MOD);
    }
}
