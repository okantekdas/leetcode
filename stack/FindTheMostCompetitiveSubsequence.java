package leetcode.stack;

import java.util.Stack;

/* https://leetcode.com/problems/find-the-most-competitive-subsequence/ */
/* Runtime: 34 ms, faster than 46.07% Memory Usage: 49.7 MB, less than 97.17% */
public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {

        int length = nums.length;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + length - i > k) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] solution = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            solution[i] = stack.pop();
        }

        return solution;
    }
}
