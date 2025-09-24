package caspex;

import java.util.*;
public class BiggestRectangle {

    public static int maxArea(List<Integer> B) {
        if (B == null || B.isEmpty()) return 0;

        int n = B.size();
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;

        // iterate through all bars plus one sentinel bar (i == n)
        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 : B.get(i);

            // Maintain monotonic increasing stack
            while (!stack.isEmpty() && curHeight < B.get(stack.peek())) {
                int height = B.get(stack.pop());
                // if stack empty, width stretches to 0..(i-1)
                int width  = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    // Simple test harness
    public static void main(String[] args) {
        System.out.println(maxArea(Arrays.asList(7,3,6,5,6,0,7))); // 15
        System.out.println(maxArea(Arrays.asList(9,1,1,9)));       // 9
    }
}
