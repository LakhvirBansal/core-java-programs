package amazon;

import java.util.*;
public class validatePasswordSequence {

    public static List<String> validatePasswordSequence(List<String> newPasswords, List<String> oldPasswords) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < newPasswords.size(); i++) {
            String newPass = newPasswords.get(i);
            String oldPass = oldPasswords.get(i);
            if (canTransformToSubsequence(newPass, oldPass)) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }

        return result;
    }

    private static boolean canTransformToSubsequence(String newPass, String oldPass) {
        int m = newPass.length();
        int n = oldPass.length();
        int j = 0;

        for (int i = 0; i < m && j < n; i++) {
            char chNew = newPass.charAt(i);
            char chNext = getNextCyclicChar(chNew);
            char chOld = oldPass.charAt(j);

            if (chOld == chNew || chOld == chNext) {
                j++;
            }
        }

        return j == n;
    }

    private static char getNextCyclicChar(char c) {
        return c == 'z' ? 'a' : (char)(c + 1);
    }

    public static void main(String[] args) {
        List<String> newPasswords = Arrays.asList("aaccbbee","aab");
        List<String> oldPasswords = Arrays.asList("bdbf","aee");

        List<String> output  = validatePasswordSequence(newPasswords, oldPasswords);
        System.out.println(output);

    }
}
