package leetcode.recursion;

/* https://leetcode.com/problems/longest-common-subsequence */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text2.length() + 1][text1.length() + 1];

        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[0].length; x++) {
                if (text2.charAt(y - 1) == text1.charAt(x - 1)) {
                    dp[y][x] = dp[y - 1][x - 1] + 1;
                } else {
                    dp[y][x] = Math.max(dp[y - 1][x], dp[y][x - 1]);
                }
            }
        }

        return dp[text2.length()][text1.length()];

    }
    // Runtime: 1305 ms, faster than 5.05% Memory Usage: 186.3 MB, less than 100.00%
    // public class Memo {
    // int index1;
    // int index2;

    // public Memo(int index1, int index2) {
    // this.index1 = index1;
    // this.index2 = index2;
    // }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + getEnclosingInstance().hashCode();
    // result = prime * result + index1;
    // result = prime * result + index2;
    // return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Memo other = (Memo) obj;
    // if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
    // return false;
    // if (index1 != other.index1)
    // return false;
    // if (index2 != other.index2)
    // return false;
    // return true;
    // }

    // private LongestCommonSubsequence getEnclosingInstance() {
    // return LongestCommonSubsequence.this;
    // }

    // }

    // HashMap<Memo, Integer> textToLcs = new HashMap<>();

    // public int longestCommonSubsequence(String text1, String text2) {

    // return lcs(text1, text2, 0, 0);
    // }

    // public int lcs(String text1, String text2, int index1, int index2) {
    // if (textToLcs.containsKey(new Memo(index1, index2))) {
    // return textToLcs.get(new Memo(index1, index2));
    // }
    // if (index1 >= text1.length() || index2 >= text2.length()) {
    // return 0;
    // }

    // int maxLcs = 0;
    // if (text1.charAt(index1) == text2.charAt(index2)) {
    // int lcs = lcs(text1, text2, index1 + 1, index2 + 1) + 1;
    // maxLcs = Math.max(maxLcs, lcs);
    // } else {
    // int lcs1 = lcs(text1, text2, index1 + 1, index2);
    // maxLcs = Math.max(maxLcs, lcs1);
    // int lcs2 = lcs(text1, text2, index1, index2 + 1);
    // maxLcs = Math.max(maxLcs, lcs2);
    // }

    // textToLcs.put(new Memo(index1, index2), maxLcs);

    // return maxLcs;
    // }

    // public class Memo {
    // String text1;
    // String text2;

    // public Memo(String text1, String text2) {
    // this.text1 = text1;
    // this.text2 = text2;
    // }

    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + getEnclosingInstance().hashCode();
    // result = prime * result + ((text1 == null) ? 0 : text1.hashCode());
    // result = prime * result + ((text2 == null) ? 0 : text2.hashCode());
    // return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    // if (this == obj)
    // return true;
    // if (obj == null)
    // return false;
    // if (getClass() != obj.getClass())
    // return false;
    // Memo other = (Memo) obj;
    // if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
    // return false;
    // if (text1 == null) {
    // if (other.text1 != null)
    // return false;
    // } else if (!text1.equals(other.text1))
    // return false;
    // if (text2 == null) {
    // if (other.text2 != null)
    // return false;
    // } else if (!text2.equals(other.text2))
    // return false;
    // return true;
    // }

    // private LongestCommonSubsequence getEnclosingInstance() {
    // return LongestCommonSubsequence.this;
    // }

    // }

    // HashMap<Memo, Integer> textToLcs = new HashMap<>();

    // public int longestCommonSubsequence(String text1, String text2) {

    // if (textToLcs.containsKey(new Memo(text1, text2))) {
    // return textToLcs.get(new Memo(text1, text2));
    // }
    // if (text1.isEmpty() || text2.isEmpty()) {
    // return 0;
    // }

    // int maxLcs = 0;
    // for (int i = 0; i < text1.length(); i++) {

    // for (int j = 0; j < text2.length(); j++) {

    // if (text1.charAt(i) == text2.charAt(j)) {
    // int lcs = longestCommonSubsequence(text1.substring(i + 1), text2.substring(j
    // + 1)) + 1;
    // maxLcs = Math.max(maxLcs, lcs);
    // }

    // }
    // }

    // textToLcs.put(new Memo(text1, text2), maxLcs);

    // return maxLcs;
    // }

    public static void main(String[] args) {
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";
        // String text1 = "abcdef";
        // String text2 = "efgh";

        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(text1, text2));
    }

}