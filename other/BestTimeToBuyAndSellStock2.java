package leetcode.other;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {

        int max = 0;
        int profit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                profit += max - prices[i];
                max = prices[i];
            }
        }

        return profit;
    }

    public int maxProfitAlternate(int[] prices) {

        int globalMaxima = 0;
        for (int i = 0; i < prices.length; i++) {
            int localMaxima = 0;
            int buyPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (buyPrice < prices[j]) {
                    localMaxima += prices[j] - buyPrice;
                    buyPrice = prices[j];
                } else {
                    buyPrice = prices[j];
                }

            }
            if (globalMaxima < localMaxima) {
                globalMaxima = localMaxima;
            }
        }

        return globalMaxima;
    }

    public static void main(String[] args) {

        int[] prices = { 7, 6, 4, 3, 1 };

        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit(prices));

    }
}