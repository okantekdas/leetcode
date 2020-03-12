package leetcode.sort;

import java.util.HashMap;

/**
 * ValidAnagram
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        HashMap<Character, Integer> charToCount = new HashMap<>();

        for (char c : sCharArr) {
            Integer count = charToCount.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            charToCount.put(c, count);

        }

        for (char c : tCharArr) {
            Integer count = charToCount.get(c);
            if (count == null) {
                return false;
            } else {
                count--;
                if (count < 0) {
                    return false;
                } else {
                    charToCount.put(c, count);
                }

            }

        }

        return true;

    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagarao";

        System.out.println("Result: " + new ValidAnagram().isAnagram(s, t));
    }

}
