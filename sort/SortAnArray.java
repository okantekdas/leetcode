package leetcode.sort;

import java.util.Arrays;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivotIndex = partition(nums, start, end);

        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {

            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = { -4, 0, 7, 4, 7, -5, -1, 0, -7, -1 };

        System.out.println("Unsorted: " + Arrays.toString(nums));

        new SortAnArray().sortArray(nums);

        System.out.println("Sorted: " + Arrays.toString(nums));

    }

}