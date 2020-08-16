package leetcode.other;

import java.util.HashMap;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            int count = charToCount.getOrDefault(c, 0);
            charToCount.put(c, ++count);
        }

        boolean hasOdd = false;
        int length = 0;
        for (int count : charToCount.values()) {
            if (count == 1) {
                hasOdd = true;
            } else {
                if (count % 2 == 0) {
                    length += count;
                } else {
                    length += count - 1;
                    hasOdd = true;
                }
            }

        }

        return hasOdd == true ? length + 1 : length;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}