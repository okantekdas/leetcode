package leetcode.dp;

import java.util.Arrays;

/* https://leetcode.com/problems/edit-distance */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] perDp : dp) {
            Arrays.fill(perDp, -1);
        }
        return minDistance(word1, word2, dp);
    }

    public int minDistance(String word1, String word2, int[][] dp) {
        if (dp[word1.length()][word2.length()] != -1) {
            return dp[word1.length()][word2.length()];
        }

        if (word1.isEmpty()) {
            return word2.length();
        }

        if (word2.isEmpty()) {
            return word1.length();
        }

        if (word1.equals(word2)) {
            return 0;
        }

        int min = Math.max(word1.length(), word2.length());
        // delete
        min = Math.min(min, 1 + minDistance(word1.substring(1), word2, dp));

        // replace
        if (word1.charAt(0) != word2.charAt(0)) {
            min = Math.min(min, 1 + minDistance(word1.substring(1), word2.substring(1), dp));
        } else {
            // same character
            min = Math.min(min, minDistance(word1.substring(1), word2.substring(1), dp));
        }

        // insert
        min = Math.min(min, 1 + minDistance(word1, word2.substring(1), dp));

        dp[word1.length()][word2.length()] = min;

        return min;
    }

    public static void main(String[] args) {
        // String word1 = "intention";
        // String word2 = "execution";
        String word1 = "abcdxabcde";
        String word2 = "abcdeabcdx";
        // String word1 = "cansu";
        // String word2 = "okan";
        // String word1 = "horse";
        // String word2 = "ros";

        System.out.println(new EditDistance().minDistance(word1, word2));
    }

}