package ABSResources;

import java.util.*;
public class NextMaximum {

    public static List<Integer> solve(List<Integer> ar) {
        int n = ar.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            int current = ar.get(i);

            // Pop elements from stack that are <= current element
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            // If stack is not empty, top is the next greater element
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            // Push current element to stack
            stack.push(current);
        }

        return result;
    }

    // Sample usage
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(4, 5, 3);
        System.out.println(solve(input1)); // Output: [5, -1, -1]

        List<Integer> input2 = Arrays.asList(1, 3, 2, 4);
        System.out.println(solve(input2)); // Output: [3, 4, 4, -1]
    }
}
