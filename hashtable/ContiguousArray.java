package leetcode.hashtable;

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> diffToIndex = new HashMap<>();

        int zeroes = 0;
        int ones = 0;
        int max = 0;
        diffToIndex.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroes++;
            } else {
                ones++;
            }

            int diff = ones - zeroes;
            if (diffToIndex.containsKey(diff)) {
                max = Math.max(max, i - diffToIndex.get(diff));
            } else {
                diffToIndex.put(diff, i);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 1, 1, 1, 0 };

        System.out.println(new ContiguousArray().findMaxLength(nums));
    }

}