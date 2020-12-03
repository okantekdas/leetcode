package leetcode.dp;

import java.util.HashMap;
import java.util.HashSet;

/* https://leetcode.com/problems/partition-equal-subset-sum/ */
/* Runtime: 29 ms, faster than 56.48% Memory Usage: 46.8 MB, less than 26.61% */
public class PartitionEqualSubsetSum {

    HashMap<Integer, HashSet<Integer>> indexToFound = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> indexToNotFound = new HashMap<>();

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        return findCombination(nums, sum / 2, 0);
    }

    private boolean findCombination(int[] nums, int target, int index) {

        if (indexToFound.containsKey(index) && indexToFound.get(index).contains(target)) {
            return true;
        }

        if (indexToNotFound.containsKey(index) && indexToNotFound.get(index).contains(target)) {
            return false;
        }

        if (index >= nums.length || target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (findCombination(nums, target - nums[index], index + 1) || findCombination(nums, target, index + 1)) {

            HashSet<Integer> set = indexToFound.get(index);
            if (indexToFound.get(index) == null) {
                set = new HashSet<>();
                indexToFound.put(index, set);
            }
            set.add(target);

            return true;
        }

        HashSet<Integer> set = indexToNotFound.get(index);
        if (indexToNotFound.get(index) == null) {
            set = new HashSet<>();
            indexToNotFound.put(index, set);
        }
        set.add(target);

        return false;

    }

    public static void main(String[] args) {
        int[] nums = { 26, 50, 1, 66, 5, 91, 98, 65, 31, 19, 15, 25, 87, 58, 19, 67, 64, 48, 64, 85, 25, 81, 7, 92, 87,
                6, 37, 43, 8, 49, 71, 47, 3, 7, 10, 96, 69, 78, 99, 33, 91, 41, 4, 34, 68, 44, 100, 67, 58, 57, 30, 61,
                100, 86, 59, 65, 44, 81, 82, 53, 79, 48, 31, 13, 39, 22, 56, 43, 88, 37, 66, 64, 60, 27, 40, 89, 99, 27,
                62, 50, 5, 20, 31, 71, 77, 14, 67, 7, 44, 58, 83, 96, 100, 24, 85, 52, 38, 31, 69, 47 };

        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }
}
