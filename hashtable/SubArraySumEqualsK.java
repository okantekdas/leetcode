package leetcode.hashtable;

import java.util.HashMap;

public class SubArraySumEqualsK {

    HashMap<Long, Integer> sumToCount = new HashMap<>();

    public int subarraySum(int[] nums, int k) {

        int total = 0;

        long sum = 0;
        for (int num : nums) {
            sum += num;

            if (sum == k) {
                total++;
            }

            if (sumToCount.containsKey(sum - k)) {
                total += sumToCount.get(sum - k);
            }

            Integer count = sumToCount.get(sum);
            if (count == null) {
                sumToCount.put(sum, 1);
            } else {
                sumToCount.put(sum, count + 1);
            }
        }

        return total;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1, 2, 0, 1, 1, 3 };
        int k = 2;

        System.out.println(new SubArraySumEqualsK().subarraySum(nums, k));

    }

}