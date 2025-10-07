package amazon.interviews;

import java.util.*;
public class BalancedParentheses {
    // Returns "Balanced" or "Not Balanced"
    public static String isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing, check for match
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return "Not Balanced";
                char open = stack.pop();
                if (!isMatching(open, ch)) return "Not Balanced";
            }
        }
        // If stack is empty, all open brackets closed properly
        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }

    // Used to check matching bracket pairs
    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String[] tests = {
                "((()))",      // Balanced
                "({[]})",      // Balanced
                "({[})",       // Not Balanced
                "({[)]}",      // Not Balanced
                "((())",       // Not Balanced
                "([]{})",      // Balanced
                "(",           // Not Balanced
        };
        for (String exp : tests) {
            System.out.printf("Input: %-10s Output: %s\n", exp, isBalanced(exp));
        }
    }
}
