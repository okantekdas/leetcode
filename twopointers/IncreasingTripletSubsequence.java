package leetcode.twopointers;

/* https://leetcode.com/problems/increasing-triplet-subsequence/ */
/* Runtime: 0 ms, faster than 100.00% */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

}
