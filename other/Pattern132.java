package leetcode.other;

import java.util.Stack;

/* https://leetcode.com/problems/132-pattern/ */
/* Runtime: 3 ms, faster than 94.55% */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, -4, -3 };
        System.out.println(new Pattern132().find132pattern(nums));
    }
}
