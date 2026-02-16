package amazon;
import java.util.*;
public class GetNumOfSubList {

    public static long getNumOfSublist(List<Integer> price, int thresh) {
        int n = price.size();
        long totalBadSublists = 0;

        // lastBadStart keeps track of the rightmost starting index 'p'
        // of any segment [p, q] that XORs to thresh, where q <= current index.
        int lastBadStart = -1;

        // Map to store the last seen index of a prefix XOR value
        // key: prefixXor, value: index
        Map<Integer, Integer> lastSeenXor = new HashMap<>();

        int currentXor = 0;
        // Base case: prefix XOR of 0 is at index -1
        lastSeenXor.put(0, -1);

        for (int i = 0; i < n; i++) {
            currentXor ^= price.get(i);

            // We look for a previous prefix XOR such that:
            // currentXor ^ previousXor == thresh
            // Which means: previousXor = currentXor ^ thresh
            int targetXor = currentXor ^ thresh;

            if (lastSeenXor.containsKey(targetXor)) {
                // A segment [p, i] exists with XOR sum == thresh.
                // The start index p of this segment is lastSeenXor.get(targetXor) + 1
                int startOfSegment = lastSeenXor.get(targetXor) + 1;

                // Update the rightmost start index that makes a sublist "bad"
                lastBadStart = Math.max(lastBadStart, startOfSegment);
            }

            // If lastBadStart is -1, no bad segments have been found yet.
            // If lastBadStart >= 0, then all sublists starting from 0 to lastBadStart
            // and ending at i are "bad".
            if (lastBadStart != -1) {
                totalBadSublists += (lastBadStart + 1);
            }

            // Update the map with the current prefix XOR's index
            lastSeenXor.put(currentXor, i);
        }

        return totalBadSublists;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(3,1,2,5);
        System.out.println(getNumOfSublist(price, 3));

    }
}
