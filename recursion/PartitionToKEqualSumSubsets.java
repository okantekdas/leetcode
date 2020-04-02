package leetcode.recursion;

/**
 * PartitionToKEqualSumSubsets
 */
public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int average = total / k;
        if (average * k != total) {
            return false;
        }

        return searchCombination(nums, new boolean[nums.length], average, 0, k, 0);
    }

    private boolean searchCombination(int[] nums, boolean[] visited, int target, int currentSum, int k, int index) {

        if (k == 0) {
            return true;
        }

        if (currentSum == target) {
            return searchCombination(nums, visited, target, 0, k - 1, 0);
        }

        for (int i = index; i < nums.length; i++) {
            int sum = currentSum + nums[i];
            if (!visited[i] && sum <= target) {
                visited[i] = true;
                boolean solution = searchCombination(nums, visited, target, sum, k, index + 1);
                if (solution) {
                    return true;
                } else {
                    visited[i] = false;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 4, 3, 2, 3, 5, 2, 1 };

        boolean result = new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, 4);

        System.out.println(result);
    }
}