package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/summary-ranges/ */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                solution.add(String.valueOf(nums[i]));
            } else if (nums[i] != nums[i - 1] + 1) {
                String last = solution.get(solution.size() - 1);
                if (!last.equals(String.valueOf(nums[i - 1]))) {
                    last += "->";
                    last += String.valueOf(nums[i - 1]);
                    solution.remove(solution.size() - 1);
                    solution.add(last);
                }

                solution.add(String.valueOf(nums[i]));
            } else if (nums[i] == nums[i - 1] + 1 && i == nums.length - 1) {
                String last = solution.get(solution.size() - 1);
                last += "->";
                last += String.valueOf(nums[i]);
                solution.remove(solution.size() - 1);
                solution.add(last);
            }

        }

        return solution;
    }

}