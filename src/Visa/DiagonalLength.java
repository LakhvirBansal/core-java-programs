package Visa;

public class DiagonalLength {

    static int[][] directions = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1} // All diagonal directions
    };

    public static int solution(int[][] matrix) {
        int maxLength = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Iterate over all elements in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start from cells containing '1'
                if (matrix[i][j] == 1) {
                    // Explore all four diagonal directions
                    for (int[] dir : directions) {
                        maxLength = Math.max(maxLength, explore(matrix, i, j, dir[0], dir[1]));
                    }
                }
            }
        }
        return maxLength;
    }

    private static int explore(int[][] matrix, int x, int y, int dx, int dy) {
        int rows = matrix.length, cols = matrix[0].length;
        int length = 1; // Start from the current '1'
        int[] pattern = {1, 2, 0}; // Repeating pattern
        int patternIndex = 1; // Start with '2' after '1'

        // Traverse diagonally
        while (true) {
            x += dx;
            y += dy;

            // Check bounds
            if (x < 0 || x >= rows || y < 0 || y >= cols) {
                break; // Stop at matrix border
            }

            // Check pattern match
            if (matrix[x][y] != pattern[patternIndex]) {
                break; // Pattern broken
            }

            length++;
            patternIndex = (patternIndex + 1) % 3; // Cycle through [1, 2, 0]
        }

        // Ensure the sequence ends at the border
        if (x == -1 || x == rows || y == -1 || y == cols) {
            return length;
        }

        return 0; // Invalid if not reaching border
    }



    public static void main(String[] args) {
        int[][] matrix1 = {
                {0, 0, 1, 2},
                {0, 2, 2, 2},
                {2, 1, 0, 1}
        };
        System.out.println(solution(matrix1)); // Expected Output: 3

        int[][] matrix2 = {
                {2, 1, 2, 2, 0},
                {0, 2, 0, 2, 2},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 2, 2},
                {2, 2, 0, 2, 1},
                {0, 2, 0, 0, 2}
        };
        System.out.println(solution(matrix2)); // Expected Output: 3
    }
}
