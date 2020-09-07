package leetcode.hashtable;

import java.util.HashMap;

/* https://leetcode.com/problems/two-sum/ */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndexes = new HashMap<>();

        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (numToIndexes.containsKey(target - nums[i])) {
                solution[0] = numToIndexes.get(target - nums[i]);
                solution[1] = i;
                return solution;
            }
            numToIndexes.put(nums[i], i);
        }
        return solution;
    }

}