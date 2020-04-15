package leetcode.other;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if (s == null || s.length() == 0) {
            return "";
        }
        if (t == null || t.length() == 0) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            Integer count = charToCount.get(c);
            if (count == null) {
                charToCount.put(c, 1);
            } else {
                charToCount.put(c, ++count);
            }
        }

        int left = 0;
        int right = 0;
        char[] sToChar = s.toCharArray();

        int leftOptimal = -1;
        int rightOptimal = -1;
        int optimalDistance = -1;
        int uniqueCharCount = 0;
        HashMap<Character, Integer> windowCharToCount = new HashMap<>();
        boolean isRightIncreased = true;
        while (left <= right && right < sToChar.length) {

            char rightChar = sToChar[right];
            System.out.println("Left:" + (left >= 0 ? sToChar[left] : " ") + " Right:" + rightChar);

            if (isRightIncreased) {
                if (charToCount.containsKey(rightChar)) {
                    Integer count = windowCharToCount.get(rightChar);
                    if (count == null) {
                        windowCharToCount.put(rightChar, 1);
                    } else {
                        windowCharToCount.put(rightChar, ++count);
                    }

                }

                if (charToCount.containsKey(rightChar)
                        && windowCharToCount.get(rightChar).intValue() == charToCount.get(rightChar).intValue()) {
                    uniqueCharCount++;
                }
            }

            if (uniqueCharCount == charToCount.size()) {
                if (optimalDistance < 0 || right - left + 1 < optimalDistance) {
                    leftOptimal = left;
                    rightOptimal = right;
                    optimalDistance = right - left + 1;
                }
                char leftChar = sToChar[left];
                if (windowCharToCount.containsKey(leftChar)) {
                    Integer count = windowCharToCount.get(leftChar);
                    windowCharToCount.put(leftChar, --count);
                    if (windowCharToCount.get(leftChar).intValue() < charToCount.get(leftChar).intValue()) {
                        uniqueCharCount--;
                        right++;
                        isRightIncreased = true;
                    } else {
                        isRightIncreased = false;
                    }

                } else {
                    isRightIncreased = false;
                }
                left++;
            } else {
                isRightIncreased = true;
                right++;
            }

        }

        return leftOptimal < 0 ? "" : s.substring(leftOptimal, rightOptimal + 1);

    }

    public static void main(String[] args) {
        // String s = "ADOBECODEBANC";
        // String t = "ABC";
        // String s = "aaaaaaaaaaaabbbbbcdd";
        // String t = "abcdd";
        // String s = "a";
        // String t = "a";
        // String s = "baaaabab";
        // String t = "abb";
        // String s = "aaabbaaba";
        // String t = "abbb";
        // String s = "a";
        // String t = "b";
        String s = "cabefgecdaecf";
        String t = "cae";

        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

}