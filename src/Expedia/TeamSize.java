package Expedia;
import java.util.*;

public class TeamSize {

    public static void main(String[] args) {


        List<Integer> talent = Arrays.asList(1,2,3,2,1);
        int talentsCount = 3;
        List<Integer> res = teamSize(talent, talentsCount);
        StringBuilder sb = new StringBuilder();
        for (int x : res) {
            sb.append(x).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static List<Integer> teamSize(List<Integer> talent, int talentsCount) {
        int n = talent.size();
        List<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        if (talentsCount > n) {
            return ans; // all -1
        }
        int[] counts = new int[talentsCount + 1]; // 1-based talents
        int have = 0; // number of distinct talents currently present in window
        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && have < talentsCount) {
                int val = talent.get(right);
                if (val <= talentsCount) {
                    if (counts[val] == 0) have++;
                    counts[val]++;
                } else {
                }
                right++;
            }
            if (have == talentsCount) {
                ans.set(left, right - left); // length = (right-1) - left + 1 = right-left
            } else {
                break;
            }
            int leftVal = talent.get(left);
            if (leftVal <= talentsCount) {
                counts[leftVal]--;
                if (counts[leftVal] == 0) {
                    have--;
                }
            }
        }
        return ans;
    }
}
