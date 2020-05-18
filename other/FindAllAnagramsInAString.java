package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* https://leetcode.com/problems/find-all-anagrams-in-a-string */
public class FindAllAnagramsInAString {

    // Runtime: 6 ms, faster than 85.80%
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> solution = new ArrayList<>();
        int[] charCount = new int[26];

        for (char c : p.toCharArray()) {
            charCount[c - 97]++;
        }

        int[] charCountSoFar = new int[26];
        int startIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (charCount[currentChar - 97] > 0) {
                if (startIndex < 0) {
                    startIndex = i;
                }
                if (charCountSoFar[currentChar - 97] == charCount[currentChar - 97]) {

                    char temp = s.charAt(startIndex);
                    int j = startIndex;
                    while (temp != currentChar) {
                        charCountSoFar[temp - 97]--;
                        j++;
                        temp = s.charAt(j);

                    }
                    startIndex = j + 1;

                } else {
                    charCountSoFar[currentChar - 97]++;

                    if (i - startIndex + 1 == p.length()) {
                        // found one
                        charCountSoFar[s.charAt(startIndex) - 97]--;
                        solution.add(startIndex);
                        startIndex++;
                    }
                }

            } else {
                startIndex = -1;
                charCountSoFar = new int[26];
            }

        }

        return solution;
    }

    // 14 ms
    public List<Integer> findAnagramsAlternate(String s, String p) {

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