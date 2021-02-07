package leetcode.string;

import java.util.Arrays;

/* https://leetcode.com/problems/shortest-distance-to-a-character/ */
public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {

        int left = -1;
        int right = -1;
        int current = 0;

        int[] solution = new int[s.length()];
        while (current < s.length()) {

            if (s.charAt(current) == c) {
                left = current;
                right = current;
                solution[current] = 0;
            } else {
                // compare with left
                // compare with right
                // get closest

                if (right < current) {
                    right = right < 0 ? 0 : right + 1;
                    while (right < s.length() && s.charAt(right) != c) {
                        right++;
                    }
                    right = right >= s.length() ? Integer.MAX_VALUE : right;
                }
                int leftDistance = left >= 0 ? Math.abs(current - left) : Integer.MAX_VALUE;
                int rightDistance = Math.abs(right - current);
                solution[current] = Math.min(leftDistance, rightDistance);
            }
            current++;

        }

        return solution;
    }

    public static void main(String[] args) {
        int[] solution = new ShortestDistanceToACharacter().shortestToChar("ab", 'a');
        System.out.println(Arrays.toString(solution));
    }
}
