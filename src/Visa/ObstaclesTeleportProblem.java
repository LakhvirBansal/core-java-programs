package Visa;

import java.util.*;
public class ObstaclesTeleportProblem {

    public static int solution(int n, int m, int[][] obstacles, int[][] teleports) {
        // Store obstacles in a set for O(1) lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        // Store teleport mappings
        Map<String, int[]> teleportMap = new HashMap<>();
        for (int[] tp : teleports) {
            teleportMap.put(tp[0] + "," + tp[1], new int[]{tp[2], tp[3]});
        }

        // Track visited teleport start cells to detect infinite loop
        Set<String> teleportVisited = new HashSet<>();

        // Start from (0,0)
        int row = 0, col = 0;
        int steps = 1; // count starting cell

        while (true) {
            // If we reached the destination
            if (row == n - 1 && col == m - 1) {
                return steps;
            }

            // Move right
            col++;

            // Out of bounds
            if (col >= m) return -1;

            String pos = row + "," + col;

            // Hit obstacle
            if (obstacleSet.contains(pos)) return -1;

            steps++; // Count this cell

            // Check teleport
            if (teleportMap.containsKey(pos)) {
                if (teleportVisited.contains(pos)) {
                    return -2; // infinite teleport loop
                }
                teleportVisited.add(pos);

                int[] end = teleportMap.get(pos);
                row = end[0];
                col = end[1];
                steps++; // count teleport destination as visited
            }
        }
    }

    // Example test cases
    public static void main(String[] args) {
        int n1 = 3, m1 = 3;
        int[][] obstacles1 = {{2,1}};
        int[][] teleports1 = {{0,1,2,0}};
        System.out.println(solution(n1, m1, obstacles1, teleports1)); // -1

        int n2 = 3, m2 = 4;
        int[][] obstacles2 = {{1,1}};
        int[][] teleports2 = {{0,2,0,1},{0,3,2,0}};
        System.out.println(solution(n2, m2, obstacles2, teleports2)); // -2

        int n3 = 3, m3 = 4;
        int[][] obstacles3 = {{2,0},{1,0}};
        int[][] teleports3 = {{0,1,1,1},{1,2,0,2},{0,3,2,1}};
        System.out.println(solution(n3, m3, obstacles3, teleports3)); // 9
    }
}
