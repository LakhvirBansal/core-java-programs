package Visa;

public class BigBoxRotationProblem {

    public static char[][] solution(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Step 1: Rotate the matrix clockwise
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }

        // Step 2: Simulate gravity column by column in rotated box
        for (int col = 0; col < m; col++) {
            int bottom = n - 1;

            for (int row = n - 1; row >= 0; row--) {
                if (rotated[row][col] == '*') {
                    bottom = row - 1; // obstacle found, move bottom up
                } else if (rotated[row][col] == '#') {
                    if (bottom != row) {
                        rotated[bottom][col] = '#';
                        rotated[row][col] = '.';
                    }
                    bottom--; // next position for another falling box
                }
            }
        }

        return rotated;
    }

    // Helper to print the matrix (for testing)
    public static void printBox(char[][] box) {
        for (char[] row : box) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

    // Example usage
    public static void main(String[] args) {
        char[][] box = {
                {'#', '.', '#', '.', '.', '.', '.'},
                {'#', '#', '*', '.', '.', '.', '.'},
                {'#', '.', '#', '*', '.', '#', '.'}
        };

        char[][] result = solution(box);
        printBox(result);
    }
}
