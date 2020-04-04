package leetcode.other;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 0, 0, 0, 3, 12 };
        System.out.println("Before: " + Arrays.toString(arr));
        new MoveZeroes().moveZeroes(arr);
        System.out.println("After: " + Arrays.toString(arr));

    }

}