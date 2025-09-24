package amazon;

public class countRemovableIndices {

    public static int countRemovableIndices(String productLabel) {
        int count = 0;
        int n = productLabel.length();

        for (int i = 0; i < n; i++) {
            if (isPalindromeAfterRemoving(productLabel, i)) {
                count++;
            }
        }

        return count;
    }

    // Correctly check palindrome by skipping only the character at removeIdx
    private static boolean isPalindromeAfterRemoving(String s, int removeIdx) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip left index if it's the one to be removed
            if (left == removeIdx) {
                left++;
                continue;
            }
            // Skip right index if it's the one to be removed
            if (right == removeIdx) {
                right--;
                continue;
            }
            // Compare characters
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
