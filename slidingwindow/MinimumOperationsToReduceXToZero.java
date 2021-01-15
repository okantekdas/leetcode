package leetcode.slidingwindow;

import java.util.HashMap;

/* https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/ */
/* Runtime: 3 ms, faster than 100.00% Memory Usage: 49.2 MB, less than 92.26%  */
public class MinimumOperationsToReduceXToZero {

    // Sliding window
    public int minOperations(int[] nums, int x) {

        int sum = -x;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum < 0) {
            return -1;

        }
        if (sum == 0) {
            return nums.length;
        }
        int left = 0;
        int currentSum = 0;
        int minOps = -1;
        for (int right = 0; right < nums.length; right++) {
            if (currentSum < sum)
                currentSum += nums[right];
            while (currentSum >= sum) {
                if (currentSum == sum)
                    minOps = Math.max(minOps, right - left + 1);
                currentSum -= nums[left++];
            }
        }

        return minOps == -1 ? -1 : nums.length - minOps;
    }

    // Prefix sum 60 ms
    public int minOperationsAlternate2(int[] nums, int x) {
        int minOps = Integer.MAX_VALUE;

        HashMap<Integer, Integer> indexToSum = new HashMap<>();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (x - leftSum < 0) {
                break;
            }
            indexToSum.put(leftSum, i + 1);
            if (leftSum == x) {
                minOps = Math.min(minOps, i + 1);
            }
        }

        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[nums.length - 1 - i];
            if (rightSum == x) {
                minOps = Math.min(minOps, i + 1);
            }
            Integer step = indexToSum.get(x - rightSum);
            if (step != null) {
                minOps = Math.min(minOps, i + step + 1);
            }
        }
        return minOps == Integer.MAX_VALUE || minOps > nums.length ? -1 : minOps;

    }

    // TLE
    public int minOperationsAlernate(int[] nums, int x) {

        return minOperationsHelper(nums, x, 0, nums.length - 1);
    }

    public int minOperationsHelper(int[] nums, int x, int left, int right) {

        if (x == 0) {
            return 0;
        }
        if (x < 0 || left > nums.length - 1 || right < 0 || left > right) {
            return -1;
        }

        int minOperation = -1;
        int leftSolution = minOperationsHelper(nums, x - nums[left], left + 1, right);

        if (leftSolution >= 0) {
            minOperation = Integer.MAX_VALUE;
            minOperation = Math.min(minOperation, leftSolution + 1);
        }
        int rightSolution = minOperationsHelper(nums, x - nums[right], left, right - 1);

        if (rightSolution >= 0) {
            if (minOperation < 0) {
                minOperation = Integer.MAX_VALUE;
            }
            minOperation = Math.min(minOperation, rightSolution + 1);
        }

        return minOperation;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 2, 3 };
        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(nums, 5));
    }
}
