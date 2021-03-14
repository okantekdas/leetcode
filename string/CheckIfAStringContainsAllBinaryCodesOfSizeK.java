package leetcode.string;

import java.util.HashSet;

/* https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/ */
/* Runtime: 7 ms, faster than 98.84% Memory Usage: 40.2 MB, less than 97.68% */
/* Runtime: 90 ms, faster than 60.23% */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

    /* Runtime: 7 ms, faster than 98.84% Memory Usage: 40.2 MB, less than 97.68% */
    public boolean hasAllCodes(String s, int k) {
        int variation = 1 << k;
        boolean[] variations = new boolean[variation];
        int ones = variation - 1;
        int value = 0;

        for (int i = 0; i < s.length(); i++) {

            value = ((value << 1) & ones) | (s.charAt(i) - '0');

            if (i >= k - 1 && !variations[value]) {
                variations[value] = true;
                variation--;
                if (variation == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Runtime: 90 ms, faster than 60.23% */
    public boolean hasAllCodesAlternate(String s, int k) {

        HashSet<String> set = new HashSet<>();
        int left = 0;
        int right = k;
        int variation = 1 << k;

        while (right <= s.length()) {
            String subString = s.substring(left++, right++);
            set.add(subString);
            if (set.size() == variation) {
                return true;
            }

        }
        return false;
    }
}
