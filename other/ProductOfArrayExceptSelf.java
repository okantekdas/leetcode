package leetcode.other;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;
        int[] output = new int[length];

        output[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            output[i] = nums[i + 1] * output[i + 1];
        }

        int product = 1;
        int temp = 0;
        for (int i = 1; i <= length; i++) {
            temp = nums[i - 1];
            nums[i - 1] = product;
            product *= temp;
        }

        for (int i = 0; i < length; i++) {
            output[i] = output[i] * nums[i];
        }

        return output;

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));

    }

}