package amazon;

public class findMaxLuckyNumber {

    public static String findMaxLuckyNumber(int x, int y, int n) {
        // Determine smaller and larger digits
        int a = Math.min(x, y);
        int b = Math.max(x, y);

        // gcd-style reduction
        int d = gcd(a, b);
        int step = b / d;

        // Find smallest i0 in [0, step - 1] such that (n - i * a) % b == 0
        int i0 = -1;
        for (int i = 0; i < step; i++) {
            if ((n - i * a) % b == 0) {
                i0 = i;
                break;
            }
        }

        // According to the problem, solution always exists
        int k_max = (n / a - i0) / step;
        int i = i0 + k_max * step;
        int j = (n - i * a) / b;

        // Build maximal number: b's first (most significant), then a's
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < j; k++) result.append(b);
        for (int k = 0; k < i; k++) result.append(a);

        return result.toString();
    }

    // Helper to calculate GCD
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Main method to read input
    public static void main(String[] args) {
        int x = 7;
        int y = 5;
        int n = 22;

        System.out.println(findMaxLuckyNumber(x, y, n));
    }
}


/*
in python

import sys
from math import gcd

def findMaxLuckyNumber(x: int, y: int, n: int) -> str:
    # Let a = smaller digit, b = larger digit
    if x < y:
        a, b = x, y
    else:
        a, b = y, x

    # gcd-style reduction for the modular step
    d = gcd(a, b)
    step = b // d

    # find the smallest i0 in [0, step-1] such that (n - i0*a) is divisible by b
    i0 = next((i for i in range(step) if (n - i * a) % b == 0), None)

    # guaranteed to exist by problem statement
    # general solution: i = i0 + k*(b/d), with i <= n//a
    k_max = (n // a - i0) // step
    i = i0 + k_max * step
    j = (n - i * a) // b

    # build the maximal number: place all b's first (most significant), then all a's
    return str(b) * j + str(a) * i

if _name_ == "_main_":
    x = int(sys.stdin.readline())
    y = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    print(findMaxLuckyNumber(x, y, n))
 */