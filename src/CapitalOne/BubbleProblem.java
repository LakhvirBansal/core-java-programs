package CapitalOne;
import java.util.*;
public class BubbleProblem {
    private static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}}; // up,down,left,right

    public static int[][] solution(int[][] bubbles) {
        int R = bubbles.length;
        int C = bubbles[0].length;

        /* ---------- 1. mark “eligible” cells ---------------------------------------- */
        boolean[][] eligible = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int same = 0;
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
                            bubbles[nr][nc] == bubbles[r][c]) {
                        same++;
                    }
                }
                if (same >= 2) eligible[r][c] = true;
            }
        }

        /* ---------- 2. flood-fill each colour component once ----------------------- */
        boolean[][] visited  = new boolean[R][C];
        boolean[][] explode  = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) continue;

                int colour = bubbles[r][c];
                Queue<int[]> q = new ArrayDeque<>();
                List<int[]> component = new ArrayList<>();
                boolean componentWillExplode = false;

                visited[r][c] = true;
                q.offer(new int[]{r,c});

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    component.add(cur);
                    if (eligible[x][y]) componentWillExplode = true;

                    for (int[] d : DIRS) {
                        int nx = x + d[0], ny = y + d[1];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C &&
                                !visited[nx][ny] && bubbles[nx][ny] == colour) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }

                /* mark whole component for explosion if needed */
                if (componentWillExplode) {
                    for (int[] cell : component) explode[cell[0]][cell[1]] = true;
                }
            }
        }

        /* ---------- 3. perform the explosion (set to 0) ----------------------------- */
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (explode[r][c]) bubbles[r][c] = 0;
            }
        }

        /* ---------- 4. gravity – compact each column downwards --------------------- */
        for (int c = 0; c < C; c++) {
            int write = R - 1;                       // last free row from the bottom
            for (int r = R - 1; r >= 0; r--) {
                if (bubbles[r][c] != 0) {
                    bubbles[write][c] = bubbles[r][c];
                    if (write != r) bubbles[r][c] = 0;
                    write--;
                }
            }
        }
        return bubbles;
    }

    /* ------------------------- quick manual test harness -------------------------- */
    public static void main(String[] args) {
        int[][] board = {
                {3, 1, 2, 1},
                {1, 1, 1, 4},
                {3, 1, 2, 2},
                {3, 3, 3, 4}
        };
        int[][] after = solution(board);

        for (int[] row : after)
            System.out.println(Arrays.toString(row));
        /*  expected output:
            [0, 0, 0, 1]
            [0, 0, 0, 4]
            [0, 0, 2, 2]
            [3, 0, 2, 4]
        */
    }
}
