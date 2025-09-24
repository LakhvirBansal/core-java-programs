package amazon;
import java.util.*;
public class getMaxHealth {

    public static void main(String[] args) {

        List<Integer> health = Arrays.asList(1,2,1,3);
        int result = getMaxHealth(health);
        System.out.println(result);

        health = Arrays.asList(35, 35, 35, 35);
        result = getMaxHealth(health);
        System.out.println(result);

    }

    public static int getMaxHealth(List<Integer> health) {
        // Sort the list of health values to group identical scores together.
        // This is crucial for the optimized single-pass approach.
        // Time Complexity: O(n log n) due to sorting.
        Collections.sort(health);

        int maxAchievedHealth = 0;
        int n = health.size();

        // Iterate through the sorted list to find groups of identical health scores.
        // Time Complexity: O(n)
        for (int i = 0; i < n; ) {
            int currentHealth = health.get(i);
            int count = 0;

            // Count the number of consecutive servers with the same health score.
            int j = i;
            while (j < n && health.get(j).equals(currentHealth)) {
                count++;
                j++;
            }

            // The maximum health achievable from a chain starting with this health
            // is the initial health plus the number of servers with that same health, minus one.
            // This is because to extend a chain (e.g., from health H to H+1, H+2, etc.),
            // each subsequent server chosen must have had the same initial health score H.
            int achievedHealth = currentHealth + count - 1;

            // Update the overall maximum health if the current chain is better.
            if (achievedHealth > maxAchievedHealth) {
                maxAchievedHealth = achievedHealth;
            }

            // Move the outer loop pointer past the group we just processed.
            i = j;
        }

        return maxAchievedHealth;
    }
}
