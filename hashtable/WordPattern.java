package leetcode.hashtable;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        if (pattern.length() == 1 && !str.contains(" ")) {
            return true;
        }

        char[] patternCharArr = pattern.toCharArray();
        String[] strSplitted = str.split(" ");

        if (patternCharArr.length != strSplitted.length) {
            return false;
        }

        HashMap<Character, String> charToStr = new HashMap<>();

        for (int i = 0; i < patternCharArr.length; i++) {

            char currentChar = patternCharArr[i];
            String currentStr = charToStr.get(currentChar);

            if (currentStr == null) {

                if (charToStr.values().contains(strSplitted[i])) {
                    return false;
                }
                charToStr.put(currentChar, strSplitted[i]);
            } else if (!currentStr.equals(strSplitted[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dog dog dog dog";

        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
