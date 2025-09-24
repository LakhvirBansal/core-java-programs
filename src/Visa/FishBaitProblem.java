package Visa;

import java.util.Arrays;

public class FishBaitProblem {

    public static int solution(int[] fish, int[] baits) {
        Arrays.sort(fish);
        Arrays.sort(baits);

        boolean[] caught = new boolean[fish.length];
        int totalCaught = 0;

        for (int i = baits.length - 1; i >= 0; i--) {
            int baitSize = baits[i];
            int used = 0;

            for (int j = fish.length - 1; j >= 0 && used < 3; j--) {
                if (!caught[j] && baitSize < fish[j]) {
                    caught[j] = true;
                    totalCaught++;
                    used++;
                }
            }
        }

        return totalCaught;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}, new int[]{2, 4, 5})); // ✅ Output: 1
    }

}
