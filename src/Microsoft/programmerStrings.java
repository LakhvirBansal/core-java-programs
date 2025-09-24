package Microsoft;

public class programmerStrings {

    private static final String TARGET = "programmer";
    private static final int REQUIRED_TYPES = 7;
    public static int programmerStrings(String s) {
        int n = s.length();
        int[] target = new int[26];
        for (char c : TARGET.toCharArray()) target[c - 'a']++;
        int[] window = new int[26];
        int formed = 0, right = 0, leftEnd = -1;
        while (right < n) {
            char c = s.charAt(right);
            int idx = c - 'a';
            window[idx]++;
            if (window[idx] == target[idx]) {
                formed++;
            }
            if (formed == REQUIRED_TYPES) {
                leftEnd = right;
                break;
            }
            right++;
        }
        String rev = new StringBuilder(s).reverse().toString();
        int[] window2 = new int[26];
        formed = 0;
        int revRight = 0, revEnd = -1;
        while (revRight < n) {
            char c = rev.charAt(revRight);
            int idx = c - 'a';
            window2[idx]++;
            if (window2[idx] == target[idx]) {
                formed++;
            }
            if (formed == REQUIRED_TYPES) {
                revEnd = revRight;
                break;
            }
            revRight++;
        }
        int rightStart = n - 1 - revEnd;
        return rightStart - leftEnd - 1;
    }
    public static void main(String[] args) {
        String s = "progxrammerrxproxgrammer";
        System.out.println(programmerStrings(s));
    }
}
