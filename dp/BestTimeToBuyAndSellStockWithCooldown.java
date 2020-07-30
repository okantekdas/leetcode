package leetcode.dp;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] s0 = new int[prices.length + 1];
        int[] s1 = new int[prices.length + 1];
        int[] s2 = new int[prices.length + 1];

        s1[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
    }

    public static void main(String[] args) {

        int[] prices = { 1, 2, 3, 2, 4 };
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));

    }
}