package Citadel;

public class processScheduling {

    public static void main(String[] args) {
        int n_intervals = 2;
        int n_processes = 3;

        System.out.println(processScheduling(n_intervals, n_processes));
    }

    private static final long MOD = 1_000_000_007;

    /**
     * Calculates the number of ways to schedule n_processes in n_intervals
     * such that no process is scheduled in consecutive intervals.
     *
     * @param n_intervals The number of time intervals.
     * @param n_processes The number of available processes.
     * @return The number of ways, modulo 10^9 + 7.
     */
    public static int processScheduling(int n_intervals, int n_processes) {
        // Handle the base case where there is only one time interval.
        // Any of the n_processes can be scheduled, so there are no consecutive
        // intervals to violate the rule.
        if (n_intervals == 1) {
            return (int) (n_processes % MOD);
        }

        // Handle the case where there is only one process.
        // If there is more than one interval, it's impossible to schedule
        // without the single process being consecutive.
        if (n_processes == 1) {
            return 0;
        }

        // The number of choices for the first interval is n_processes.
        long result = n_processes;

        // For each of the remaining (n_intervals - 1) intervals,
        // we must choose a process that is different from the previous one.
        // This leaves (n_processes - 1) choices for each interval.
        long base = n_processes - 1;
        long exponent = n_intervals - 1;

        // Use modular exponentiation to efficiently calculate (n_processes - 1)^(n_intervals - 1)
        // while keeping the result within the modulus.
        long powerResult = modPow(base, exponent, MOD);

        // Multiply the number of choices for the first interval with the choices for the rest.
        // The result is taken modulo MOD at each step to prevent overflow.
        result = (result * powerResult) % MOD;

        return (int) result;
    }

    /**
     * A helper function to compute (base^exp) % mod efficiently.
     * This is an iterative implementation of the binary exponentiation algorithm.
     *
     * @param base The base of the exponentiation.
     * @param exp The exponent.
     * @param mod The modulus.
     * @return (base^exp) % mod.
     */
    private static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;

        while (exp > 0) {
            // If the exponent is odd, multiply the result by the current base.
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }

            // Square the base and halve the exponent.
            base = (base * base) % mod;
            exp /= 2;
        }

        return res;
    }
}
