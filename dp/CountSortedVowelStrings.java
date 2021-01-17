package leetcode.dp;

/* https://leetcode.com/problems/count-sorted-vowel-strings/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 35.7 MB, less than 61.62%  */
public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {

        return countVowelStrings(n, 5, new int[51][6]);
    }

    public int countVowelStrings(int n, int index, int dp[][]) {

        if (n == 0) {
            return 1;
        }

        if (dp[n][index] > 0) {
            return dp[n][index];
        }
        int sum = 0;

        for (int i = index; i > 0; i--) {
            sum += countVowelStrings(n - 1, i, dp);
        }

        dp[n][index] = sum;

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(1));
    }
}
