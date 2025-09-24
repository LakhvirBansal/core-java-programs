package Visa;

public class Cross {

    public static int solution(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isNearlyRegularCross(matrix, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isNearlyRegularCross(int[][] matrix, int row, int col) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int commonValue = -1;
        boolean diffFound = false;

        // Check the row
        for (int j = 0; j < cols; j++) {
            if (j == col) continue;
            if (commonValue == -1) {
                commonValue = matrix[row][j];
            } else if (matrix[row][j] != commonValue) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < rows; i++) {
            if (i == row) continue;
            if (commonValue == -1) {
                commonValue = matrix[i][col];
            } else if (matrix[i][col] != commonValue) {
                return false;
            }
        }

        // Check if row and col are consistent, or if the intersection is different
        if (commonValue == -1) return true; // Empty cross

        boolean rowConsistent = true;
        for (int j = 0; j < cols; j++) {
            if (j == col) continue;
            if (matrix[row][j] != commonValue) {
                rowConsistent = false;
                break;
            }
        }
        boolean colConsistent = true;
        for (int i = 0; i < rows; i++) {
            if (i == row) continue;
            if (matrix[i][col] != commonValue) {
                colConsistent = false;
                break;
            }
        }

        if (rowConsistent && colConsistent) return true;

        // If row and col were not consistent, check if the intersection is different
        int intersection = matrix[row][col];

        return (rowConsistent || colConsistent) && intersection != commonValue;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 3, 1, 1},
                {1, 1, 1, 0},
                {1, 4, 1, 1}
        };
        System.out.println(solution(matrix)); // Output should be 2

        int[][] matrix1 = {
                {2, 3}
        };
        System.out.println(solution(matrix1));
    }
}
