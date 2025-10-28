package Expedia;

import java.util.*;

public class MakeAlphabeticallySmallestPalindrome {

    public static void main(String[] args) throws Exception {
        System.out.println(makeAlphabeticallySmallestPalindrome("fhaigh"));
    }

    public static String makeAlphabeticallySmallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) odds.add(i);
        }
        int i = 0, j = odds.size() - 1;
        while (j - i + 1 > 1) {
            int small = odds.get(i);
            int large = odds.get(j);
            freq[small]++;
            freq[large]--;
            i++;
            j--;
        }
        StringBuilder first = new StringBuilder();
        char center = 0;
        for (int c = 0; c < 26; c++) {
            if ((freq[c] & 1) == 1) center = (char) (c + 'a');
            int pairs = freq[c] / 2;
            for (int k = 0; k < pairs; k++) first.append((char) (c + 'a'));
        }
        StringBuilder res = new StringBuilder();
        res.append(first);
        if (center != 0) res.append(center);
        res.append(first.reverse());
        return res.toString();
    }
}
