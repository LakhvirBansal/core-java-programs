package amazon;

import java.io.*;
import java.util.*;
public class calculateRepetiveness {

    public static long calculateRepetitiveness(String purchaseHistory, int minRepetitions) {
        int n = purchaseHistory.length();
        // Total substrings:
        long totalSub = (long) n * (n + 1) / 2;
        // Count of substrings where no character reaches minRepetitions:
        long invalidCount = 0;

        int[] freq = new int[26];
        int violations = 0;       // number of characters whose count >= minRepetitions
        int left = 0;

        for (int right = 0; right < n; right++) {
            int c = purchaseHistory.charAt(right) - 'a';
            freq[c]++;
            if (freq[c] == minRepetitions) {
                violations++;
            }

            // Shrink window until we have no violations
            while (violations > 0) {
                int d = purchaseHistory.charAt(left) - 'a';
                if (freq[d] == minRepetitions) {
                    violations--;
                }
                freq[d]--;
                left++;
            }

            // Now all substrings ending at right and starting anywhere in [left..right]
            // are invalid (no char reaches minRepetitions).
            invalidCount += (right - left + 1);
        }

        // Valid substrings = totalSub – invalidCount
        return totalSub - invalidCount;
    }

    public static void main(String[] args) throws IOException {
        String purchaseHistory = "acaab";
        int minRepetitions = 3;
        long result = calculateRepetitiveness(purchaseHistory, minRepetitions);
        System.out.println(result);
    }
}
