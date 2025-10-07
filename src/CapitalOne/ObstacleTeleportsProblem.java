package CapitalOne;

import java.util.*;
public class ObstacleTeleportsProblem {

    public static int solution(int n, int m, int[][] obstacles, int[][] teleports) {
        // mark obstacles
        boolean[][] isObstacle = new boolean[n][m];
        for (int[] ob : obstacles) {
            isObstacle[ob[0]][ob[1]] = true;
        }

        // map teleport start -> end
        Map<Integer,int[]> tp = new HashMap<>();
        for (int[] t : teleports) {
            int sr = t[0], sc = t[1], er = t[2], ec = t[3];
            tp.put(sr * m + sc, new int[]{er, ec});
        }

        // visited positions set to detect infinite loop
        boolean[][] visited = new boolean[n][m];

        int r = 0, c = 0;             // current position
        int count = 1;                // include starting cell
        visited[r][c] = true;

        while (true) {
            // reached exit?
            if (r == n - 1 && c == m - 1) return count;

            // try move right first
            int nr = r, nc = c + 1;

            boolean rightBlocked = (nc >= m) || isObstacle[nr][nc];
            if (rightBlocked) {
                // try move down
                nr = r + 1; nc = c;
                boolean downBlocked = (nr >= n) || isObstacle[nr][nc];
                if (downBlocked) {
                    // cannot move right or down -> stuck because of obstacle or outside
                    return -1;
                }
            }

            // move into (nr,nc)
            r = nr; c = nc;
            count++;
            if (visited[r][c]) return -2; // revisited cell -> teleport loop
            visited[r][c] = true;

            // teleport?
            int key = r * m + c;
            if (tp.containsKey(key)) {
                int[] end = tp.get(key);
                int er = end[0], ec = end[1];
                count++;
                if (visited[er][ec]) return -2; // loop
                visited[er][ec] = true;
                r = er; c = ec;
                if (r == n - 1 && c == m - 1) return count;
            }
        }
    }

    public static void main(String[] args) {
        // Example 1: obstacle blocks -> -1
        int[][] obstacles1 = {{2,1}};
        int[][] teleports1 = {{0,1,2,0}};
        System.out.println(solution(3,3,obstacles1,teleports1)); // -1

        // Example 2: infinite teleport loop -> -2
        int[][] obstacles2 = {{1,1}};
        int[][] teleports2 = {{0,2,0,1},{0,3,2,0}};
        System.out.println(solution(3,4,obstacles2,teleports2)); // -2

        // Example 3: success with teleports
        int[][] obstacles3 = {{2,0},{1,0}};
        int[][] teleports3 = {{0,1,1,1},{1,2,0,2},{0,3,2,1}};
        System.out.println(solution(3,4,obstacles3,teleports3)); // 9

        // Example 4: success without loop
        int[][] obstacles4 = {{0,2}};
        int[][] teleports4 = {{1,2,0,3}};
        System.out.println(solution(2,4,obstacles4,teleports4)); // 6
    }
}
