package leetcode.string;

/* https://leetcode.com/problems/remove-duplicate-letters/ */
/* Runtime: 20 ms, faster than 11.82% */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        int current = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(current)) {
                current = i;
            }
            if (--charCount[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        return s.length() == 0 ? ""
                : s.charAt(current) + removeDuplicateLetters(
                        s.substring(current + 1).replaceAll(""+s.charAt(current), ""));
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }
}
