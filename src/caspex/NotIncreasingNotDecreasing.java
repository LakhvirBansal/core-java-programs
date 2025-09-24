package caspex;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class NotIncreasingNotDecreasing {


    /*
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters:
     * 1. ar (is of type List<Integer>)
     * return type "int".
     */
    public static int solve(List<Integer> ar) {
        int n = ar.size();

        // If the array has less than 3 elements, it's impossible to have 3 consecutive
        // increasing or decreasing elements. So, no removals needed.
        if (n < 3) {
            return 0;
        }

        // dp[i][0] represents the maximum length of a valid subsequence ending at index i,
        // where the last transition was increasing (ar[prev_kept] < ar[i]).
        // This means ar[i] is a peak or part of an increasing sequence.
        // We are looking for a decreasing element after this if we extend.

        // dp[i][1] represents the maximum length of a valid subsequence ending at index i,
        // where the last transition was decreasing (ar[prev_kept] > ar[i]).
        // This means ar[i] is a valley or part of a decreasing sequence.
        // We are looking for an increasing element after this if we extend.

        // Initialize all values to 1, as each element itself forms a valid subsequence of length 1.
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        int maxLength = 1; // Minimum length of a valid subsequence is 1 (any single element)

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (ar.get(i) > ar.get(j)) { // Increasing transition
                    // If ar[i] is greater than ar[j], we can potentially extend a sequence
                    // that ended with a decreasing transition at ar[j].
                    // This creates an increasing segment ending at ar[i].
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                } else if (ar.get(i) < ar.get(j)) { // Decreasing transition
                    // If ar[i] is less than ar[j], we can potentially extend a sequence
                    // that ended with an increasing transition at ar[j].
                    // This creates a decreasing segment ending at ar[i].
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                }
            }
            // Update the overall maximum length found so far
            maxLength = Math.max(maxLength, Math.max(dp[i][0], dp[i][1]));
        }

        // The minimum number of elements to remove is total elements - maximum elements kept.
        return n - maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // For testing purposes, you might want to uncomment these lines to write to a file
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = new ArrayList<>();

        String[] arTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arTempItems[i]);
            ar.add(arItem);
        }

        int result = solve(ar);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
        // If writing to a file, uncomment this
        // bufferedWriter.close();
    }
}

