package Visa;

public class RemoveVowelsAndReverseString {

    public static String solution(String inputString) {
        // Set of vowels to remove (both lowercase and uppercase)
        String vowels = "aeiouAEIOU";

        StringBuilder filtered = new StringBuilder();

        // Step 1: Filter out vowels
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (vowels.indexOf(ch) == -1) { // Not a vowel
                filtered.append(ch);
            }
        }

        // Step 2: Reverse the filtered string
        filtered.reverse();
        return filtered.toString();
    }

    // Optional: main method for quick test
    public static void main(String[] args) {
        System.out.println(solution("Hello world!")); // Output: "!dlrw llH"
        System.out.println(solution("The quick brown FOX jumps over the lazy DOG 1234."));
        // Output: ".4321 GD yzl ht rv spmj XF nwrb kcq hT"
    }
}
