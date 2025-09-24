package amazon.interviews;
import java.util.*;
/**
 * <img src="images/acquireLock.png" alt="Logo">
 */


/**
 * You are implementing a range-based locking system (RangeLock) to acquire exclusive locks over numeric intervals.
 *
 * A lock is defined over a range [start, end].
 *
 * A new lock request can only be granted if it does not overlap with any existing locked ranges.
 *
 * The function acquireLock(int start, int end) should:
 *
 * Return true if the range can be locked (and adds it to lockedRanges).
 *
 * Return false if the range conflicts with any existing lock.
 *
 * The method releaseLock(int start, int end) is already implemented — it removes exact matching ranges.
 *
 * Clarification on overlapping:
 *
 * Is [5, 10] overlapping with [10, 15]? (Assuming inclusive ranges, then yes.)
 *
 * Should [start, end] be inclusive or exclusive?
 *
 * Are ranges always valid?
 *
 * i.e., is start <= end guaranteed?
 */
public class RangeLock {
    private List<Range> lockedRanges = new ArrayList<>();

    private static class Range {
        int start, end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean acquireLock(int start, int end) {
        if (start >= end) return false; // Invalid range

        for (Range range : lockedRanges) {
            // Check overlap using [start, end) rule
            if (start < range.end && end > range.start) {
                return false;
            }
        }

        lockedRanges.add(new Range(start, end));
        return true;
    }

    public void releaseLock(int start, int end) {
        lockedRanges.removeIf(range -> range.start == start && range.end == end);
    }

    public static void main(String[] args) {
        RangeLock lock = new RangeLock();

        System.out.println(lock.acquireLock(0, 10));   // true
        System.out.println(lock.acquireLock(5, 15));   // false (overlap)
        System.out.println(lock.acquireLock(10, 20));  // true (no overlap)
    }
}
/*

 */
