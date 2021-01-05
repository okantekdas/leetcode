package leetcode.string;

/* https://leetcode.com/problems/decoded-string-at-index/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 36.8 MB, less than 84.81% */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {

        long length = 0;

        for (int i = 0; i < S.length(); i++) {
            if (Character.isAlphabetic(S.charAt(i))) {
                length++;
            } else {
                length *= S.charAt(i) - '0';
            }
        }

        for (int i = S.length() - 1; i > -1; i--) {

            K %= length;

            if (K == 0 && Character.isAlphabetic(S.charAt(i))) {
                return Character.toString(S.charAt(i));
            }

            if (Character.isDigit(S.charAt(i))) {
                length /= S.charAt(i) - '0';
            } else {
                length--;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        String S = "ha22";
        int K = 5;

        System.out.println(new DecodedStringAtIndex().decodeAtIndex(S, K));
    }
}
