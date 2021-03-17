package leetcode.dp;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/ */
/* Runtime: 3 ms, faster than 93.90% Memory Usage: 48.1 MB, less than 84.86% */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {

        int money = 0;
        int profit = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            money = Math.max(money, profit + prices[i] - fee);
            profit = Math.max(profit, money - prices[i]);
        }

        return money;
    }
}
