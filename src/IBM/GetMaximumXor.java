package IBM;

public class GetMaximumXor {

    public static String getMaximumXor(String s, String t) {
        int n = s.length();

        // Count 0s and 1s in string t
        int count0 = 0, count1 = 0;
        for (char c : t.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }

        StringBuilder result = new StringBuilder();

        // Greedy XOR maximization
        for (int i = 0; i < n; i++) {
            char sc = s.charAt(i);

            if (sc == '0') {
                if (count1 > 0) {
                    result.append('1'); // 0 ^ 1 = 1
                    count1--;
                } else {
                    result.append('0'); // 0 ^ 0 = 0
                    count0--;
                }
            } else { // sc == '1'
                if (count0 > 0) {
                    result.append('1'); // 1 ^ 0 = 1
                    count0--;
                } else {
                    result.append('0'); // 1 ^ 1 = 0
                    count1--;
                }
            }
        }

        return result.toString();
    }

    // Entry point for testing
    public static void main(String[] args) {


        // Read input strings
        String s = "1100";
        String t = "1010";

        // Compute and print result
        String result = getMaximumXor(s, t);
        System.out.println(result);
    }
}
