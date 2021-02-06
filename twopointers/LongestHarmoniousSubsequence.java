package leetcode.twopointers;

import java.util.HashMap;

/* https://leetcode.com/problems/longest-harmonious-subsequence/ */
/* Runtime: 16 ms, faster than 70.40%  */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {

        HashMap<Integer, Integer> numToCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numToCount.put(nums[i], numToCount.getOrDefault(nums[i], 0) + 1);

        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int countSmaller = numToCount.get(number);
            int countBigger = numToCount.getOrDefault(number + 1, 0);
            if (countBigger > 0) {
                maxLength = Math.max(maxLength, countSmaller + countBigger);

            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(
                new int[] { 3, 2, 0, 0, 0, 3, 2, 2, 0, 2, 2, 1, 2, 3, 1, 0, 2, 3, 2, 3, 3, 2, 1, 0, 3, 3, 1 }));
    }
}
