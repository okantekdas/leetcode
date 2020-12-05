package leetcode.string;

import java.util.HashSet;

/* https://leetcode.com/problems/unique-morse-code-words/ */
/* Runtime: 1 ms, faster than 100.00% Memory Usage: 36.6 MB, less than 94.16% */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {

        String[] alphabet = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        HashSet<String> solution = new HashSet<>();

        for (String word : words) {

            StringBuilder strBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                strBuilder.append(alphabet[c - 'a']);
            }
            solution.add(strBuilder.toString());
        }
        return solution.size();
    }
}
