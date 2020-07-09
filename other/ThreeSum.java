package leetcode.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/3sum/ */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        ArrayList<List<Integer>> solution = new ArrayList<>();
        int left = 0;
        while (left < nums.length - 2) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
            } else {
                int mid = left + 1;
                int right = nums.length - 1;
                while (mid < right) {

                    if (mid > left + 1 && nums[mid] == nums[mid - 1]) {
                        mid++;
                    } else {

                        int sum = nums[left] + nums[mid] + nums[right];

                        if (sum == 0) {
                            solution.add(Arrays.asList(nums[left], nums[mid++], nums[right--]));
                        } else if (sum > 0) {
                            right--;
                        } else if (sum < 0) {
                            mid++;
                        }
                    }
                }
                left++;
            }

        }

        return solution;

    }

    public static void main(String[] args) {
        // int[] nums = { -1, 0, 1, 2, -1, -4 };
        int[] nums = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
        List<List<Integer>> solution = new ThreeSum().threeSum(nums);
        System.out.println(Arrays.deepToString(solution.toArray()));
    }
}