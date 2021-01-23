package leetcode.hashtable;

import java.util.HashMap;

/* https://leetcode.com/problems/max-number-of-k-sum-pairs/ */
/* Runtime: 30 ms, faster than 64.79% */
public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {

        HashMap<Integer, Integer> numberToCount = new HashMap<>();

        int opCount = 0;
        for (int num : nums) {
            int diff = k - num;
            if (numberToCount.containsKey(diff)) {
                int count = numberToCount.get(diff);
                if (count > 0) {
                    if (count == 0) {
                        numberToCount.remove(diff);
                    } else {
                        numberToCount.put(diff, --count);
                        opCount++;
                        continue;
                    }

                }
            }
            int count = numberToCount.getOrDefault(num, 0);
            numberToCount.put(num, ++count);

        }

        return opCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int k = 5;

        System.out.println(new MaxNumberOfKSumPairs().maxOperations(nums, k));
    }
}
