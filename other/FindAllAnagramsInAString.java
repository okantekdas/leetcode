package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/find-all-anagrams-in-a-string */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> solution = new ArrayList<>();

        HashMap<Character, Integer> charToCount = new HashMap<>();

        for (char c : p.toCharArray()) {
            Integer count = charToCount.getOrDefault(c, 0);
            charToCount.put(c, ++count);
        }

        HashMap<Character, Integer> charToCountSoFar = new HashMap<>();

        int startIndex = -1;
        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (charToCount.containsKey(currentChar)) {

                if (charToCountSoFar.isEmpty()) {
                    startIndex = i;
                }
                Integer charCountSoFar = charToCountSoFar.getOrDefault(currentChar, 0);
                if (charToCount.get(currentChar) == charCountSoFar) {
                    if (s.charAt(startIndex) == currentChar) {
                        startIndex++;
                    } else {
                        charToCountSoFar = new HashMap<>();
                        charToCountSoFar.put(currentChar, 1);
                        startIndex = i;
                    }

                } else {
                    charToCountSoFar.put(currentChar, ++charCountSoFar);

                    if (i - startIndex + 1 == p.length()) {
                        solution.add(startIndex);
                        int startCharCount = charToCountSoFar.get(s.charAt(startIndex));
                        charToCountSoFar.put(s.charAt(startIndex), --startCharCount);
                        startIndex++;
                    }
                }

            } else {
                // release all sofar
                charToCountSoFar = new HashMap<>();
                startIndex = -1;
            }
        }

        return solution;
    }

    public static void main(String[] args) {

        // String s = "abaacbabc";
        // String p = "abc";
        // String s = "cbaebabacd";
        // String p = "abc";
        String s = "abab";
        String p = "ab";

        List<Integer> solution = new FindAllAnagramsInAString().findAnagrams(s, p);
        System.out.println(Arrays.toString(solution.toArray()));
    }
}