package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/ */
/* Runtime: 5 ms, faster than 46.44% */
public class BestTimeToBuyAndSellStockIV {

    boolean bought = false;
    int[][] buyArr = null;
    int[][] sellArr = null;

    public int maxProfit(int k, int[] prices) {

        if (2 * k > prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        buyArr = new int[prices.length][k + 1];
        sellArr = new int[prices.length][k + 1];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(buyArr[i], -1);
            Arrays.fill(sellArr[i], -1);
        }
        return maxProfitHelper(k, prices, 0);
    }

    public int maxProfitHelper(int k, int[] prices, int day) {

        if (k == 0 || day == prices.length) {
            return 0;

        }

        int profit = 0;
        // buy
        if (!bought) {

            if (buyArr[day][k] != -1) {
                return buyArr[day][k];
            }
            bought = true;

            int buy = maxProfitHelper(k, prices, day + 1);
            profit = Math.max(profit, -prices[day] + buy);
            bought = false;
        }

        // sell
        if (bought) {

            if (sellArr[day][k] != -1) {
                return sellArr[day][k];
            }
            bought = false;
            int sell = maxProfitHelper(k - 1, prices, day + 1);
            profit = Math.max(profit, prices[day] + sell);
            bought = true;
        }
        // wait
        int wait = maxProfitHelper(k, prices, day + 1);
        profit = Math.max(profit, wait);

        if (bought) {
            sellArr[day][k] = profit;
        } else {
            buyArr[day][k] = profit;
        }

        return profit;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = { 3, 2, 6, 5, 0, 3 };

        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(k, prices));
    }
}
