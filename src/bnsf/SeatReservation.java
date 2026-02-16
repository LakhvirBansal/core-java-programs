package bnsf;

import java.util.*;

public class SeatReservation {

    public int solution(int N, String S) {
        Map<Integer, Set<Character>> reserved = new HashMap<>();
        if (S != null && !S.trim().isEmpty()) {
            for (String seat : S.trim().split(" ")) {
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char col = seat.charAt(seat.length() - 1);
                reserved.computeIfAbsent(row, k -> new HashSet<>()).add(col);
            }
        }

        int totalFamilies = 0;
        for (int row = 1; row <= N; row++) {
            Set<Character> reservedSet = reserved.getOrDefault(row, Collections.emptySet());
            boolean left = !reservedSet.contains('B') && !reservedSet.contains('C') && !reservedSet.contains('D') && !reservedSet.contains('E');
            boolean right = !reservedSet.contains('F') && !reservedSet.contains('G') && !reservedSet.contains('H') && !reservedSet.contains('J');
            boolean middle = !reservedSet.contains('D') && !reservedSet.contains('E') && !reservedSet.contains('F') && !reservedSet.contains('G');
            if (left && right) {
                totalFamilies += 2;
            } else if (left || right || middle) {
                totalFamilies += 1;
            }
        }
        return totalFamilies;
    }

    public static void main(String[] args) {
        SeatReservation sol = new SeatReservation();
        // Example 1
        int N1 = 2;
        String S1 = "1A 2F 1C";
        System.out.println("Example 1 Output: " + sol.solution(N1, S1)); // Expected: 2

        // Example 2
//        int N2 = 1;
//        String S2 = "";
//        System.out.println("Example 2 Output: " + sol.solution(N2, S2)); // Expected: 2
//
//        // Example 3
//        int N3 = 22;
//        String S3 = "1A 3C 2B 2G 5A";
//        System.out.println("Example 3 Output: " + sol.solution(N3, S3)); // Expected: 41
//
//        // Custom: No reserved seats, 3 rows
//        System.out.println("All free rows: " + sol.solution(3, "")); // Expected: 6 (2 per row)
    }
}
