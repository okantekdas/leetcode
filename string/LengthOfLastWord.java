package leetcode.string;

/* https://leetcode.com/problems/length-of-last-word */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int left = 0;
        int right = 0;
        int lastLength = 0;
        while (right < s.length()) {
            if (s.charAt(right) == ' ') {
                if (s.charAt(left) != ' ') {
                    lastLength = right - left;
                }
                right++;
                left = right;
            } else {
                right++;
            }

        }
        if (left < right) {
            lastLength = right - left;
        }

        return lastLength;
    }

    public static void main(String[] args) {
        String s = "Hello   Mars12312312   ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
