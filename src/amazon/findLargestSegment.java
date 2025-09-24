package amazon;

import java.io.*;
import java.util.*;
public class findLargestSegment {

    public static int findLargestSegment(List<Integer> difficulty) {
        int n = difficulty.size();
        if (n == 0) return 0;

        // copy into primitive for speed
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = difficulty.get(i);
        }

        // prevGE[i] = index of nearest j < i with arr[j] >= arr[i], or -1 if none
        // nextGE[i] = index of nearest k > i with arr[k] >= arr[i], or n if none
        int[] prevGE = new int[n], nextGE = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // 1) build prevGE
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            prevGE[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 2) build nextGE
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            nextGE[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 3) for each i, the only valid segments in which i is the “smaller” endpoint
        //    end at prevGE[i] or at nextGE[i].  Compute those two lengths.
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            if (prevGE[i] != -1) {
                maxLen = Math.max(maxLen, i - prevGE[i] + 1);
            }
            if (nextGE[i] != n) {
                maxLen = Math.max(maxLen, nextGE[i] - i + 1);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) throws IOException {

        int n = 5;
        List<Integer> difficulty = Arrays.asList(4,2,6,8,1);
        System.out.println(findLargestSegment(difficulty));
    }
}
