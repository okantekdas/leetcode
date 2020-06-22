package leetcode.search;

import java.util.HashSet;

/* https://leetcode.com/problems/longest-duplicate-substring */
public class LongestDuplicateSubstring {

    public String longestDupSubstring(String S) {

        int left = 1;
        int right = S.length() - 1;
        String solution = "";

        while (left <= right) {
            int middle = left + (right - left) / 2;

            String subsolution = searchUsingRabinKarp(S, middle);

            if (subsolution != null) {
                solution = subsolution;
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }

        return solution;

    }

    public String searchUsingRabinKarp(String s, int length) {

        if (length <= 0) {
            return null;
        }

        long hash = hash(s.substring(0, length));

        HashSet<Long> set = new HashSet<>();
        set.add(hash);

        long pow = 1;
        for (int i = 1; i < length; i++)
            pow = (pow * 31);

        for (int i = length; i < s.length(); i++) {
            hash = nextHash(length, pow, hash, s.charAt(i - length), s.charAt(i));

            if (set.contains(hash)) {
                return s.substring(i - length + 1, i + 1);
            }

            set.add(hash);

        }

        return null;
    }

    private long hash(String s) {
        long h = 0;
        long a = 1;

        int n = s.length();
        for (int k = n; k >= 1; k--) {
            char ch = s.charAt(k - 1);
            h += (ch - 'a' + 1) * a;
            a = (a * 31);
        }

        return h;
    }

    private long nextHash(int k, long pow, long hash, char left, char right) {
        return (hash - (left - 'a' + 1) * pow) * 31 + (right - 'a' + 1);
    }

    public static void main(String[] args) {
        String S = "banana";

        System.out.println(new LongestDuplicateSubstring().longestDupSubstring(S));
    }

}