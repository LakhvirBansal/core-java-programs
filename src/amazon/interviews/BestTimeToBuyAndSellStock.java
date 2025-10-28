package amazon.interviews;

public class BestTimeToBuyAndSellStock {

    public static int[] maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return new int[]{0, 0};

        int minPrice = prices[0];
        int minIndex = 0, maxProfit = 0;
        int buy = 0, sell = 0;

        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
                buy = minIndex;
                sell = i;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minIndex = i;
            }
        }
        return new int[]{buy, sell};
    }

    public static void main(String[] args) {
        int[] prices1 = {3,6,5,4,7};
        int[] result1 = maxProfit(prices1);
        System.out.println("Buy/Sell: [" + result1[0] + "," + result1[1] + "] " +
                "(profit=" + (prices1[result1[1]] - prices1[result1[0]]) + ")");

        int[] prices2 = {5,1,4,0,2};
        int[] result2 = maxProfit(prices2);
        System.out.println("Buy/Sell: [" + result2[0] + "," + result2[1] + "]" +
                " (profit=" + (prices2[result2[1]] - prices2[result2[0]]) + ")");

        int[] prices3 = {7,6,4,3,1};
        int[] result3 = maxProfit(prices3);
        System.out.println("Buy/Sell: [" + result3[0] + "," + result3[1] + "] " +
                "(profit=" + (prices3[result3[1]] - prices3[result3[0]]) + ")");
    }
}
