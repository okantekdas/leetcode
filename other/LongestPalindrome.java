package leetcode.other;

public class LongestPalindrome {
    public int longestPalindrome(String s) {

        int[] charCount = new int[58];

        for (char c : s.toCharArray()) {
            charCount[c - 'A']++;
        }

        boolean hasOdd = false;
        int length = 0;
        for (int i = 0; i < charCount.length; i++) {
            int count = charCount[i];
            if (count == 1) {
                hasOdd = true;
            } else {
                if (count % 2 == 0) {
                    length += count;
                } else {
                    length += count - 1;
                    hasOdd = true;
                }
            }
        }

        return hasOdd == true ? length + 1 : length;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}