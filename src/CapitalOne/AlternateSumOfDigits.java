package CapitalOne;

public class AlternateSumOfDigits {

    public static int solution(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            // add for even index (0,2,4...) which corresponds to first, third, ...
            if ((i & 1) == 0) sum += digit;
            else sum -= digit;
        }
        return sum;
    }

    // simple local test
    public static void main(String[] args) {
        System.out.println(solution(52134));  // 5
        System.out.println(solution(12345));  // 3
        System.out.println(solution(104956)); // -5
    }
}
