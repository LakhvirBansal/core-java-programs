package GoldmanSach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AverageGrade {

    public static int bestAverageGrade(String[][] scores) {
        if (scores == null || scores.length == 0) {
            return 0; // Return 0 for empty input
        }

        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Step 1: Populate HashMap with scores
        for (String[] entry : scores) {
            String student = entry[0];
            int score = Integer.parseInt(entry[1]);

            studentScores.putIfAbsent(student, new ArrayList<>());
            studentScores.get(student).add(score);
        }

        int maxAverage = Integer.MIN_VALUE;

        // Step 2: Calculate averages and track max average
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            List<Integer> scoresList = entry.getValue();
            int sum = 0;
            for (int score : scoresList) {
                sum += score;
            }
            int average = (int) Math.floor(sum / scoresList.size()); // Flooring average
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    public static void main(String[] args) {
        String[][] test1 = {{"Bobby", "87"}, {"Charles", "100"}, {"Eric", "64"}, {"Charles", "22"}};
        System.out.println(bestAverageGrade(test1)); // Expected Output: 87

        String[][] test2 = {{"Alice", "85"}, {"Alice", "90"}, {"Bob", "90"}, {"Bob", "80"}};
        System.out.println(bestAverageGrade(test2)); // Expected Output: 87 (Alice: 87, Bob: 85)

        String[][] test3 = {};
        System.out.println(bestAverageGrade(test3)); // Expected Output: 0 (Empty input)

        String[][] test4 = {{"John", "70"}, {"John", "71"}, {"John", "72"}};
        System.out.println(bestAverageGrade(test4));
    }
}
