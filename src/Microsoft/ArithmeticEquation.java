package Microsoft;

import java.io.*;
import java.util.*;

public class ArithmeticEquation {

    public static void main(String[] args) {
        int N = 1;
        System.out.println(arithmeticEquation(N));
    }

    private static final int MOD = 1_000_007;
    public static int arithmeticEquation(int N) {
        boolean[] isComposite = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                if ((long)i * i <= N) {
                    for (int j = i * i; j <= N; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
        }
        long ans = 1;
        for (int p : primes) {
            long exp = 0;
            long div = p;
            while (div <= N) {
                exp += N / div;
                div *= p;
            }
            long term = 2 * exp + 1;
            ans = (ans * (term % MOD)) % MOD;
        }
        return (int) ans;
    }

}
