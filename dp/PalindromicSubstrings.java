package leetcode.dp;

/* https://leetcode.com/problems/palindromic-substrings/ */
/* Runtime: 9 ms, faster than 45.97% */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int length = 1; length <= s.length(); length++) {

            for (int start = 0; start < s.length(); start++) {
                int end = start + length - 1;
                if (end >= s.length()) {
                    break;
                }
                int midStart = start + 1;
                int midEnd = end - 1;

                boolean isPalindrome = true;
                if (midEnd >= midStart) {
                    isPalindrome = dp[midStart][midEnd];
                }

                if (isPalindrome && s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aabaa"));
    }
}
