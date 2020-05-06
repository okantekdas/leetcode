package leetcode.other;

import java.util.HashMap;

/* https://leetcode.com/problems/majority-element */
public class MajorityElement {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> numToCount = new HashMap<>();

        for (int num : nums) {
            Integer count = numToCount.get(num);
            if (count == null) {
                count = 0;
            }
            numToCount.put(num, ++count);
        }

        int maxNum = 0;
        int maxCount = 0;
        for (int num : numToCount.keySet()) {
            if (maxCount < numToCount.get(num)) {
                maxCount = numToCount.get(num);
                maxNum = num;
            }
        }

        return maxNum;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        System.out.println(new MajorityElement().majorityElement(nums));
    }

}