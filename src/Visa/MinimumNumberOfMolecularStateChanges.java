package Visa;

public class MinimumNumberOfMolecularStateChanges {

    public static int solution(int[][] proteinMatrix) {
        if (proteinMatrix == null) return 0;
        int n = proteinMatrix.length;
        if (n == 0) return 0; // defensive
        int center = n / 2; // n is odd per problem

        // counts of values 0,1,2 for Y cells and background cells
        int[] countY = new int[3];
        int[] countBg = new int[3];
        int totalY = 0, totalBg = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isY = false;
                // diagonal arms from top corners to center
                if (i <= center && (j == i || j == (n - 1 - i))) {
                    isY = true;
                }
                // vertical arm from center downwards
                else if (i >= center && j == center) {
                    isY = true;
                }

                int val = proteinMatrix[i][j];
                if (isY) {
                    countY[val]++;
                    totalY++;
                } else {
                    countBg[val]++;
                    totalBg++;
                }
            }
        }

        int best = Integer.MAX_VALUE;
        // choose yVal and bgVal distinct
        for (int yVal = 0; yVal <= 2; yVal++) {
            for (int bgVal = 0; bgVal <= 2; bgVal++) {
                if (yVal == bgVal) continue;
                int changesForY = totalY - countY[yVal];     // cells in Y not equal yVal
                int changesForBg = totalBg - countBg[bgVal]; // background cells not equal bgVal
                int totalChanges = changesForY + changesForBg;
                if (totalChanges < best) best = totalChanges;
            }
        }

        return best;
    }

    // quick tests
    public static void main(String[] args) {
        int[][] m1 = {
                {1,0,2},
                {1,2,0},
                {0,2,0}
        }; // from example -> 2
        System.out.println(solution(m1)); // 2

        int[][] m2 = {
                {2,0,0,0,2},
                {1,2,1,2,0},
                {0,1,2,1,0},
                {0,0,2,1,1},
                {1,1,2,1,1}
        }; // example -> 8
        System.out.println(solution(m2)); // 8
    }
}
