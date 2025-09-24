package Visa;

public class ConsecutiveTriplets {

    public static int solution(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdaaae")); // Expected Output: 3
        System.out.println(solution("aaaaaaa"));  // Expected Output: 0
        System.out.println(solution("abcdefgh")); // Expected Output: 6
        System.out.println(solution("ababababa")); // Expected Output: 7
    }
}
