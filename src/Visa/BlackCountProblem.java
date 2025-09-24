package Visa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BlackCountProblem {

    public static long[] solution(int rows, int cols, int[][] black) {
        long[] result = new long[5]; // To store counts of 2x2 submatrices with 0-4 black cells
        Map<String, Integer> submatrixCount = new HashMap<>();

        // Iterate over all black cells
        for (int[] cell : black) {
            int r = cell[0], c = cell[1];

            // Each black cell contributes to up to 4 possible 2x2 submatrices
            for (int dr = 0; dr <= 1; dr++) {
                for (int dc = 0; dc <= 1; dc++) {
                    int row = r - dr, col = c - dc;
                    if (row >= 0 && row < rows - 1 && col >= 0 && col < cols - 1) {
                        String key = row + "," + col;
                        submatrixCount.put(key, submatrixCount.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }

        // Count occurrences of each black count in submatrices
        long totalSubmatrices = (long) (rows - 1) * (cols - 1);
        long countedSubmatrices = 0;

        for (int count : submatrixCount.values()) {
            if (count >= 0 && count <= 4) {
                result[count]++;
            }
            countedSubmatrices++;
        }

        // Remaining submatrices have 0 black cells
        result[0] = totalSubmatrices - countedSubmatrices;

        return result;
    }

    public static void main(String[] args) {
        int rows = 3, cols = 3;
        int[][] black = {{0, 0}, {0, 1}, {1, 0}};
        System.out.println(Arrays.toString(solution(rows, cols, black))); // Expected Output: [1, 2, 0, 1, 0]

        int rows2 = 4, cols2 = 4;
        int[][] black2 = {{1, 1}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(Arrays.toString(solution(rows2, cols2, black2))); // Expected Output: [8, 0, 4, 0, 1]
    }

}
