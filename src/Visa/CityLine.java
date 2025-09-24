package Visa;

import java.util.Stack;

public class CityLine {

    public static long solution(int[] cityLine) {
        int n = cityLine.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate left boundaries
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && cityLine[stack.peek()] >= cityLine[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && cityLine[stack.peek()] >= cityLine[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long maxSquare = 0;

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int side = Math.min(width, cityLine[i]);
            long area = (long) side * side;
            maxSquare = Math.max(maxSquare, area);
        }

        return maxSquare;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 2, 1})); // Output: 4
        System.out.println(solution(new int[]{4, 3, 4}));       // Output: 9
    }
}
