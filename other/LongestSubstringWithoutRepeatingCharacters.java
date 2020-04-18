package leetcode.other;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    // public int lengthOfLongestSubstring(String s) {
    // s == null || s.isEmpty()) {
    // ;
    //

    // ] indexes = new int[96];
    // ys.fill(indexes, -1);
    // [] sCharArr = s.toCharArray();

    // left = 0;
    // right = 1;
    // max = 1;
    // xes[(int) sCharArr[left] - 32] = left;
    // e (right < sCharArr.length) {

    // xes[(int) sCharArr[right] - 32] == -1) {
    // ) sCharArr[right] - 32] = right;
    //
    // ax(max, right - left);
    // es[(int) sCharArr[right] - 32] + 1;
    // 0; i < indexes.length; i++) {
    // left) {
    //
    //
    //
    // ) sCharArr[right] - 32] = right;
    //
    //
    //
    // = Math.max(max, right - left);
    // rn max;

    // }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "abcade";
        // String s = " b &";
        // String s = "abba";
        // String s = "bbbbbb";
        // String s = "abcabcbb";
        // String s = "pwwkew";

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

}