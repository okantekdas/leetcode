package leetcode.greedy;

import java.util.Arrays;

/* https://leetcode.com/problems/determine-if-two-strings-are-close/ */
/* Runtime: 14 ms, faster than 77.30% */
public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        boolean[] charExists1 = new boolean[26];
        boolean[] charExists2 = new boolean[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
            charExists1[c - 'a'] = true;
        }

        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
            charExists2[c - 'a'] = true;
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2) && Arrays.equals(charExists1, charExists2);
    }
}
