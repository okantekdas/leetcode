package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/majority-element-ii */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        Integer var1 = null;
        Integer var2 = null;

        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (var1 != null && var1 == num) {
                count1++;
            } else if (var2 != null && var2 == num) {
                count2++;
            } else if (count1 == 0) {
                var1 = num;
                count1++;
            } else if (count2 == 0) {
                var2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }

        }
        count1 = 0;
        count2 = 0;
        List<Integer> solution = new ArrayList<>();

        for (int num : nums) {
            if (var1 != null && var1 == num) {
                count1++;
            }
            if (var2 != null && var2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            solution.add(var1);
        }
        if (count2 > nums.length / 3) {
            solution.add(var2);
        }

        return solution;

    }
}
