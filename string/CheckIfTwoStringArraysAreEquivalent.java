package leetcode.string;

/* https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/ */
/* Runtime: 0 ms, faster than 100.00% */
public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder strBuilder1 = new StringBuilder();
        StringBuilder strBuilder2 = new StringBuilder();

        for (String str : word1) {
            strBuilder1.append(str);
        }

        for (String str : word2) {
            strBuilder2.append(str);
        }

        return strBuilder1.toString().equals(strBuilder2.toString());

    }

}
