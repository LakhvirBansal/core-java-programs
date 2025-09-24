package Visa;

public class AliencodeProblem {

    private static int solution(String alienCode) {
        if (alienCode == null || alienCode.isEmpty()) {
            return 0;
        }

        int count = 0;
        int n = alienCode.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = alienCode.substring(i, j + 1);

                if (isValidSubstring(sub) && isDivisibleBy3(sub)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isValidSubstring(String sub) {
        if (sub.length() > 1 && sub.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    private static boolean isDivisibleBy3(String sub) {
        if (sub.equals("0")) {
            return true;
        }

        try {
            int num = Integer.parseInt(sub);
            return num % 3 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("456")); // Expected Output: 3 (6, 45, 456)
        System.out.println(solution("303")); // Expected Output: 5 (3,0,3,30,303)
        System.out.println(solution("1203")); // Expected Output: 5 (0,3,12,120,1203)
        System.out.println(solution("000")); // Expected Output: 3 (All substrings "0", "0", "0")
    }
}
