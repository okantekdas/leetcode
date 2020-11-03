package leetcode.string;

/* https://leetcode.com/problems/consecutive-characters */
/* Runtime: 1 ms, faster than 100.00% */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int left = 0;
        int right = 1;
        int max = 1;
        while (right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                max = Math.max(max, right - left);
                left++;
            } else {
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}
