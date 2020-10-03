package leetcode.arrays;

import java.util.HashSet;

/* https://leetcode.com/problems/k-diff-pairs-in-an-array/ */
/* Runtime: 5 ms, faster than 97.30% Memory Usage: 39.2 MB, less than 97.05%*/
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int counter = 0;
        if (k != 0) {
            for (int num : nums) {
                set.add(num);
            }
            for (int num : set) {
                int target = num + k;
                if (set.contains(target)) {
                    counter++;
                }
            }
        } else {
            HashSet<Integer> visitedSet = new HashSet<>();
            for (int num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                } else if (!visitedSet.contains(num) && set.contains(num)) {
                    visitedSet.add(num);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -2, -3 };
        int k = 1;

        System.out.println(new KDiffPairsInAnArray().findPairs(nums, k));
    }

}
