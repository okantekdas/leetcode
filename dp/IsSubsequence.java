package leetcode.dp;

/* https://leetcode.com/problems/is-subsequence */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        char firstChar = s.charAt(0);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == firstChar) {
                return isSubsequence(s.substring(1), t.substring(i + 1));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

}