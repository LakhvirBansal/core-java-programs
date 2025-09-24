package Visa;

public class ConcatenateString {

    private static String[] solution(String[] a) {
        if (a == null || a.length == 0) {
            return new String[0];
        }

        int n = a.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            char firstChar = a[i].charAt(0);
            char lastChar;

            if (i == n - 1) {
                lastChar = a[0].charAt(a[0].length() - 1);
            } else {
                lastChar = a[i + 1].charAt(a[i + 1].length() - 1);
            }

            result[i] = String.valueOf(firstChar) + String.valueOf(lastChar);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] input = {"cat", "dog", "ferret", "scorpion"};
        String[] output = solution(input);

        for (String s : output) {
            System.out.println(s);
        }
    }
}
