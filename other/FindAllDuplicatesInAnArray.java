package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/find-all-duplicates-in-an-array/ */
public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> solution = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                solution.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }

        return solution;
    }

}