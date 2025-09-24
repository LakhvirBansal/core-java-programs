package Datum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2,6,8,9);
        List<Integer> B = Arrays.asList(1,4,5,6);
        System.out.println(solve(A,B));
    }

    public static int solve(List<Integer> A, List<Integer> B) {
        return Math.max(collectCoins(A, B), collectCoins(reverseList(A), reverseList(B)));
    }

    private static int collectCoins(List<Integer> A, List<Integer> B) {
        int n = A.size(), m = B.size();
        int i = 0, j = 0;
        int sumA = 0, sumB = 0, total = 0;

        while (i < n || j < m) {
            if (i < n && (j >= m || A.get(i) < B.get(j))) {
                sumA += A.get(i++);
            } else if (j < m && (i >= n || A.get(i) > B.get(j))) {
                sumB += B.get(j++);
            } else {
                // Equal values, switch point
                sumA += A.get(i++);
                sumB += B.get(j++);
                total += Math.max(sumA, sumB);
                sumA = 0;
                sumB = 0;
            }
        }
        total += Math.max(sumA, sumB);
        return total;
    }

    private static List<Integer> reverseList(List<Integer> list) {
        List<Integer> rev = new ArrayList<>(list);
        Collections.reverse(rev);
        return rev;
    }
}
