package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums, List<Integer> oldSolution) {
        if (oldSolution == null) {
            oldSolution = new ArrayList<>();
        }

        if (oldSolution.size() == nums.length) {
            result.add(oldSolution);
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (oldSolution.contains(nums[i])) {
                    continue;

                } else {
                    List<Integer> solution  = new ArrayList<>(oldSolution); 
                    solution.add(nums[i]);
                    permute(nums, solution);
                }

            }

        }

        return result;

    }

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        System.out.println(Arrays.deepToString(permute(arr, null).toArray()));

    }
}