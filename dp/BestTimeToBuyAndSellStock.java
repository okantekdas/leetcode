package leetcode.dp;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                max = Math.max(max, prices[i] - max);
            }

        }

        return max;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
