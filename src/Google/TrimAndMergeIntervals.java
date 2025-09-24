package Google;

import java.util.*;
public class TrimAndMergeIntervals {

    public static List<int[]> trimAndMergeMeetings(List<int[]> meetings, int[] dns) {
        List<int[]> trimmed = new ArrayList<>();
        int dnsStart = dns[0], dnsEnd = dns[1];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Case 1: No overlap
            if (end <= dnsStart || start >= dnsEnd) {
                trimmed.add(new int[]{start, end});
            }
            // Case 2: Completely inside DNS
            else if (start >= dnsStart && end <= dnsEnd) {
                continue;
            }
            // Case 3: Spans across DNS - split
            else if (start < dnsStart && end > dnsEnd) {
                trimmed.add(new int[]{start, dnsStart});
                trimmed.add(new int[]{dnsEnd, end});
            }
            // Case 4: Overlaps from left
            else if (start < dnsStart && end > dnsStart && end <= dnsEnd) {
                trimmed.add(new int[]{start, dnsStart});
            }
            // Case 5: Overlaps from right
            else if (start >= dnsStart && start < dnsEnd && end > dnsEnd) {
                trimmed.add(new int[]{dnsEnd, end});
            }
        }

        // Sort intervals by start time
        trimmed.sort(Comparator.comparingInt(a -> a[0]));

        // Merge overlapping or adjacent intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : trimmed) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Merge with last
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<int[]> meetings = Arrays.asList(
                new int[]{1, 7},
                new int[]{5, 10},
                new int[]{12, 30},
                new int[]{22, 30},
                new int[]{40, 50},
                new int[]{60, 70}
        );

        int[] dns = {18, 25};

        List<int[]> result = trimAndMergeMeetings(meetings, dns);

        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }
}
