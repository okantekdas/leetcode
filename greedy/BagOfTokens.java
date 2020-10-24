package leetcode.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/bag-of-tokens/ */
/* Runtime: 2 ms, faster than 99.75% */
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int max = 0;
        int score = 0;
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                score++;
                left++;
            } else {
                if (score > 0) {
                    P += tokens[right];
                    score--;
                    right--;
                } else {
                    break;
                }
            }
            max = Math.max(max, score);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] tokens = { 100, 200, 300, 400 };
        int P = 150;

        System.out.println(new BagOfTokens().bagOfTokensScore(tokens, P));
    }
}
