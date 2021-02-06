package leetcode.twopointers;

import java.util.HashMap;

/* https://leetcode.com/problems/longest-harmonious-subsequence/ */
/* Runtime: 16 ms, faster than 70.40%  */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {

        HashMap<Integer, int[]> numToIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int[] indexes = numToIndexes.get(nums[i]);
            if (indexes == null) {
                indexes = new int[3];
                indexes[0] = i;
                indexes[2]++;
                numToIndexes.put(nums[i], indexes);
            } else {
                indexes[1] = i;
                indexes[2]++;
            }
        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int[] indexes = numToIndexes.get(number);
            int[] indexesBigger = numToIndexes.get(number + 1);

            if (indexesBigger != null) {
                maxLength = Math.max(maxLength, indexes[2] + indexesBigger[2]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(
                new int[] { 3, 2, 0, 0, 0, 3, 2, 2, 0, 2, 2, 1, 2, 3, 1, 0, 2, 3, 2, 3, 3, 2, 1, 0, 3, 3, 1 }));
    }
}
