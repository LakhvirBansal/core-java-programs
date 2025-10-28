package amazon;

import java.util.*;
public class getMinimumTime {

    public static void main(String[] args) {

        List<Integer> humanTime = Arrays.asList(9, 4, 9, 1, 6, 3, 8);
        List<Integer> robotTime = Arrays.asList(5, 4, 1, 9, 1, 1, 6);

        int result = getMinimumTime(humanTime, robotTime);
        System.out.println(result);
    }


    public static int getMinimumTime(List<Integer> humanTime, List<Integer> robotTime) {
        int n = humanTime.size();
        long maxRobot = 0;
        long sumHuman = 0;

        for (int i = 0; i < n; i++) {
            maxRobot = Math.max(maxRobot, robotTime.get(i));
            sumHuman += humanTime.get(i);
        }

        long low = 0, high = Math.max(maxRobot, sumHuman);

        while (low < high) {
            long mid = low + (high - low) / 2;
            long forcedHuman = 0;

            for (int i = 0; i < n; i++) {
                if (robotTime.get(i) > mid) {
                    forcedHuman += humanTime.get(i);
                    if (forcedHuman > mid) break;
                }
            }

            if (forcedHuman <= mid) high = mid;
            else low = mid + 1;
        }

        return (int) low;
    }
}
