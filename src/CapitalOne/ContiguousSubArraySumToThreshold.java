package CapitalOne;

public class ContiguousSubArraySumToThreshold {

    public static int solution(int[] dataSizes, int threshold) {
        int n = dataSizes.length;
        if (n == 0) return 0;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + dataSizes[i];
        }

        int maxLen = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            // Move j forward while condition holds
            while (j < n && prefix[j + 1] <= 2L * prefix[i] + threshold) {
                j++;
            }
            // now [i..j-1] is valid
            if (j > i) {
                maxLen = Math.max(maxLen, j - i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4};
        System.out.println(solution(a1, 5)); // Expected 2

        int[] a2 = {8,5,6,1,4,1,9};
        System.out.println(solution(a2, 5)); // Expected 4
    }
}
