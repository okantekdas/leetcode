package leetcode.other;

import java.util.HashMap;
import java.util.LinkedList;

/* https://leetcode.com/problems/permutation-in-string/ */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] charCount = new int[26];

        for (char c : s1.toCharArray()) {
            charCount[c - 97]++;
        }

        int[] charCountSoFar = new int[26];
        int startIndex = -1;
        for (int i = 0; i < s2.length(); i++) {
            char currentChar = s2.charAt(i);

            if (charCount[currentChar - 97] > 0) {
                if (startIndex < 0) {
                    startIndex = i;
                }
                if (charCountSoFar[currentChar - 97] == charCount[currentChar - 97]) {

                    char temp = s2.charAt(startIndex);
                    int j = startIndex;
                    while (temp != currentChar) {
                        charCountSoFar[temp - 97]--;
                        j++;
                        temp = s2.charAt(j);

                    }
                    startIndex = j + 1;

                } else {
                    charCountSoFar[currentChar - 97]++;

                    if (i - startIndex + 1 == s1.length()) {
                        // found one
                        return true;
                    }
                }

            } else {
                startIndex = -1;
                charCountSoFar = new int[26];
            }

        }

        return false;
    }

    // 8 ms
    public boolean checkInclusionAlternate(String s1, String s2) {

        int[] charCount = new int[26];

        for (char c : s1.toCharArray()) {
            charCount[c - 97]++;
        }

        HashMap<Character, LinkedList<Integer>> charToPosition = new HashMap<>();

        int startIndex = -1;
        for (int i = 0; i < s2.length(); i++) {

            char currentChar = s2.charAt(i);

            if (charCount[currentChar - 97] > 0) {
                if (charToPosition.isEmpty()) {
                    startIndex = i;
                }

                LinkedList<Integer> charPositions = charToPosition.get(currentChar);
                if (charPositions == null) {
                    charPositions = new LinkedList<>();
                    charToPosition.put(currentChar, charPositions);
                }

                if (charPositions.size() == charCount[currentChar - 97]) {
                    // count overflow, start counting from next to first char to current one
                    int indexOfFirstCurrentChar = charPositions.peek();

                    // clear until index of first currentChar
                    for (int j = startIndex; j <= indexOfFirstCurrentChar; j++) {

                        char temp = s2.charAt(j);
                        LinkedList<Integer> charPos = charToPosition.get(temp);
                        charPos.poll();
                    }

                    charPositions.add(i);
                    startIndex = indexOfFirstCurrentChar + 1;

                } else {
                    charPositions.add(i);

                    if (i - startIndex + 1 == s1.length()) {
                        // found one
                        return true;
                    }
                }

            } else {
                // start over
                charToPosition = new HashMap<>();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";

        String s2 = "eidbaooo";

        System.out.println(new PermutationInString().checkInclusion(s1, s2));
    }

}