package caspex;

import java.util.Arrays;

public class FindPrimesTillN {

    public static int solve(int N) {
        if (N <= 2) return 0; // no primes less than 2

        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true); // assume all numbers are prime
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("prime number tills 10 is :"+ solve(10));
    }
}
