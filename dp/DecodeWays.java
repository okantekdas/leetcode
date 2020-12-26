package leetcode.dp;

/* https://leetcode.com/problems/decode-ways/ */
/* Runtime: 13 ms, faster than 5.16% Memory Usage: 36.9 MB, less than 98.89% */
public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];

        return numDecodingsHelper(s, 0, dp);

    }

    public int numDecodingsHelper(String s, int index, int[] dp) {

        if (index >= s.length()) {
            return 1;
        }

        if (dp[index] > 0) {
            return dp[index];
        }

        if (s.charAt(index) - '0' == 0) {
            return 0;
        }

        int result = 0;
        result += numDecodingsHelper(s, index + 1, dp);

        if (s.length() - index > 1
                && (s.charAt(index) - '0' == 1 || (s.charAt(index) - '0' == 2 && s.charAt(index + 1) - '0' < 7))) {
            result += numDecodingsHelper(s, index + 2, dp);
        }

        dp[index] = result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("111111111111111111111111111111111111111111111"));
    }
}
