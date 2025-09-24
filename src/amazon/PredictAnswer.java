package amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Result1 {
    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        int n = stockData.size();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        Stack<Integer> stack = new Stack<>();

        // Nearest smaller to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stockData.get(stack.peek()) >= stockData.get(i)) {
                stack.pop();
            }
            if (!stack.isEmpty()) left[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Nearest smaller to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stockData.get(stack.peek()) >= stockData.get(i)) {
                stack.pop();
            }
            if (!stack.isEmpty()) right[i] = stack.peek();
            stack.push(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int query : queries) {
            int i = query - 1;
            int leftDay = left[i], rightDay = right[i];

            if (leftDay == -1 && rightDay == -1) {
                result.add(-1);
            } else if (leftDay == -1) {
                result.add(rightDay + 1);
            } else if (rightDay == -1) {
                result.add(leftDay + 1);
            } else {
                int distLeft = Math.abs(i - leftDay);
                int distRight = Math.abs(i - rightDay);
                if (distLeft <= distRight) {
                    result.add(leftDay + 1);
                } else {
                    result.add(rightDay + 1);
                }
            }
        }

        return result;
    }
}

public class PredictAnswer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<Integer> stockData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stockData.add(Integer.parseInt(br.readLine().trim()));
        }

        int q = Integer.parseInt(br.readLine().trim());
        List<Integer> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            queries.add(Integer.parseInt(br.readLine().trim()));
        }

        List<Integer> result = Result1.predictAnswer(stockData, queries);
        for (int val : result) {
            System.out.println(val);
        }
    }
}
