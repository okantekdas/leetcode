package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/subsets/ */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        return subsets(nums, 0);

    }

    public List<List<Integer>> subsets(int[] nums, int index) {

        List<List<Integer>> subsets = new ArrayList<>();

        if (index == nums.length) {
            List<Integer> subset = new ArrayList<>();
            subsets.add(subset);
            return subsets;
        }

        List<List<Integer>> subSubsets = subsets(nums, index + 1);
        List<List<Integer>> cartesianProduct = cartesianProduct(nums[index], subSubsets);
        subsets.addAll(cartesianProduct);
        subsets.addAll(subSubsets);

        return subsets;

    }

    private List<List<Integer>> cartesianProduct(int number, List<List<Integer>> subSubsets) {

        List<List<Integer>> cartesianProduct = new ArrayList<>();

        for (List<Integer> subset : subSubsets) {
            List<Integer> cartesianSubset = new ArrayList<>(subset);
            cartesianSubset.add(number);
            cartesianProduct.add(cartesianSubset);
        }
        return cartesianProduct;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> subsets = new Subsets().subsets(nums);
        System.out.println(subsets.toString());
    }

}