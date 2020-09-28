package leetcode.twopointers;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] indexes = new int[96];
        Arrays.fill(indexes, -1);
        char[] sCharArr = s.toCharArray();

        int left = 0;
        int right = 1;
        int max = 1;
        indexes[(int) sCharArr[left] - 32] = left;
        while (right < sCharArr.length) {

            if (indexes[(int) sCharArr[right] - 32] == -1) {
                indexes[(int) sCharArr[right] - 32] = right;
            } else {
                max = Math.max(max, right - left);
                left = indexes[(int) sCharArr[right] - 32] + 1;
                for (int i = 0; i < indexes.length; i++) {
                    if (indexes[i] < left) {
                        indexes[i] = -1;
                    }
                }
                indexes[(int) sCharArr[right] - 32] = right;
            }
            right++;
        }
        max = Math.max(max, right - left);
        return max;

    }

    public static void main(String[] args) {

        String s = " b &";
        // String s = "abba";
        // String s = "bbbbbb";
        // String s = "abcabcbb";
        // String s = "pwwkew";

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }

}