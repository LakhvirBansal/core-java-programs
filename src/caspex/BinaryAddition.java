package caspex;

public class BinaryAddition {
    public static String solve(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from end to start
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = bitA + bitB + carry;
            result.append(sum % 2);  // Append the result bit
            carry = sum / 2;         // Update carry
        }

        return result.reverse().toString();  // Reverse since we built it backwards
    }

    public static void main(String[] args) {
        System.out.println(solve("11", "1"));       // Output: 100
        System.out.println(solve("1010", "1011"));  // Output: 10101
    }
}
