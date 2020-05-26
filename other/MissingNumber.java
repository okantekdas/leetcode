package leetcode.other;

/* https://leetcode.com/problems/missing-number */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int biggest = nums.length;

        int currentTotal = 0;
        for (int val : nums) {
            currentTotal += val;
        }
        int total = biggest * (biggest + 1) / 2;

        return total - currentTotal;

    }

}