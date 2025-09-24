package CapitalOne;

import java.util.*;

public class LapsProblem {

    public static void main(String[] args) {
        String[][] laps1 = {
                {"Harold 154", "Gina 155", "Juan 160"},
                {"Juan 152", "Gina 153", "Harold 160"},
                {"Harold 148", "Gina 150", "Juan 151"}
        };

        String[][] laps2 = {
                {"Gina 155", "Eddie 160", "Joy 161", "Harold 163"},
                {"Harold 151", "Gina 153", "Joy 160", "Eddie 160"},
                {"Harold 149", "Joy 150", "Gina 152", "Eddie 154"},
                {"Harold 148", "Gina 150", "Eddie 151", "Joy 155"}
        };

        System.out.println(Arrays.toString(solution(laps1))); // Expected: ["Juan", "Harold", "Gina"]
        System.out.println(Arrays.toString(solution(laps2))); // Expected: ["Harold", "Eddie", "Joy", "Gina"]
    }

    public static String[] solution(String[][] laps) {
        Map<String, Integer> bestTimes = new HashMap<>();
        Set<String> eliminationOrder = new LinkedHashSet<>();

        // Initialize drivers' best times from the first lap
        for (String entry : laps[0]) {
            String[] parts = entry.split(" ");
            String name = parts[0];
            int time = Integer.parseInt(parts[1]);
            bestTimes.put(name, time);
        }

        // Process each lap
        for (String[] lap : laps) {
            // Update best times
            for (String entry : lap) {
                String[] parts = entry.split(" ");
                String name = parts[0];
                int time = Integer.parseInt(parts[1]);

                // Update the driver's best time (minimum lap time seen)
                int val = bestTimes.get(name) == null ? 0 :bestTimes.get(name);

                bestTimes.put(name, Math.min(val, time));
            }

            // Find the driver(s) with the slowest best time
            int worstBestTime = Collections.max(bestTimes.values());
            List<String> toEliminate = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : bestTimes.entrySet()) {
                if (entry.getValue() == worstBestTime) {
                    toEliminate.add(entry.getKey());
                }
            }

            // Sort alphabetically and add to elimination order
            Collections.sort(toEliminate);
            eliminationOrder.addAll(toEliminate);

            // Remove eliminated drivers from the competition
            for (String driver : toEliminate) {
                bestTimes.remove(driver);
            }
        }

        return eliminationOrder.toArray(new String[0]);
    }
}
