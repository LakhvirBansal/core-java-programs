package CapitalOne;

public class AlienCodeProblem {

    public static int solution(String alienCode) {
        int count = 0;
        int n = alienCode.length();

        // Consider all substrings starting at i
        for (int i = 0; i < n; i++) {
            int sum = 0; // Maintain rolling sum

            for (int j = i; j < n; j++) {
                char currentChar = alienCode.charAt(j);
                sum += (currentChar - '0'); // Convert char to integer

                // If it's "0" as a single character, count it
                if (i == j && currentChar == '0') {
                    count++;
                }
                // Otherwise, check divisibility by 3 (ignoring leading zeros)
                else if (alienCode.charAt(i) != '0' && sum % 3 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("456"));  // Output: 3
        System.out.println(solution("6666")); // Output: 10
        System.out.println(solution("303"));  // Output: 5 (includes '0')
        System.out.println(solution("102"));  // Output: 3 (includes '0')
        System.out.println(solution("0"));    // Output: 1 (single '0' is counted)
        System.out.println(solution("00"));   // Output: 2 (each '0' separately)
    }
}
