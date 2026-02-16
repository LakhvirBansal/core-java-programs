package Uber;

import java.util.*;

public class FinalPrice {

    public static void finalPrice(List<Integer> prices) {
        int n = prices.size();

        int[] finalPrice = new int[n];
        for (int i = 0; i < n; i++) {
            finalPrice[i] = prices.get(i);
        }

        Stack<Integer> stack = new Stack<>();

        // Find discount using monotonic stack
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices.get(i) <= prices.get(stack.peek())) {
                int idx = stack.pop();
                finalPrice[idx] = prices.get(idx) - prices.get(i);
            }
            stack.push(i);
        }

        long total = 0;
        for (int val : finalPrice) {
            total += val;
        }

        // First line: total price
        System.out.println(total);

        // Remaining indices in stack = full price items
        List<Integer> fullPriceIndices = new ArrayList<>(stack);
        Collections.sort(fullPriceIndices);

        for (int i = 0; i < fullPriceIndices.size(); i++) {
            System.out.print(fullPriceIndices.get(i));
            if (i != fullPriceIndices.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args)  {

        List<Integer> prices = Arrays.asList(5,1,3,4,6,2);
        FinalPrice.finalPrice(prices);
    }

}
