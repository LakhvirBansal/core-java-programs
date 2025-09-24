package IBM;

public class GetFirstUniqueCharacter {
    public static int getUniqueCharacter(String s) {
        int[] freq = new int[26]; // Frequency array for characters 'a' to 'z'

        // Step 1: Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i + 1; // 1-based index
            }
        }

        return -1; // No unique character found
    }

    // Main method to test the function
    public static void main(String[] args) {


        // Read input string
        String input = "statistics";

        // Compute and print result
        int result = getUniqueCharacter(input);
        System.out.println(result);
    }
}
