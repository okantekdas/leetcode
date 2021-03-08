package leetcode.string;

/* https://leetcode.com/problems/remove-palindromic-subsequences/ */
/* Runtime: 0 ms, faster than 100.00% */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        return isPalindrome(s) ? 1 : 2;
    }

    boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
