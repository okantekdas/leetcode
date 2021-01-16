package leetcode.twopointers;

import java.util.Arrays;

/* https://leetcode.com/problems/merge-sorted-array/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 38.9 MB, less than 90.49%  */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }

        int[] temp = new int[nums1.length];
        int i = 0;
        int nums1Index = 0;
        int nums2Index = 0;
        while (nums1Index < m && nums2Index < n) {
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                temp[i++] = nums1[nums1Index++];
            } else {
                temp[i++] = nums2[nums2Index++];
            }
        }

        int[] arr = null;
        int index = 0;
        int limit = 0;
        if (nums1Index != m) {
            arr = nums1;
            index = nums1Index;
            limit = m;
        } else {
            arr = nums2;
            index = nums2Index;
            limit = n;
        }

        for (int j = index; j < limit; j++) {
            temp[i++] = arr[j];
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 0 };
        int m = 4;
        int[] nums2 = { 0 };
        int n = 1;

        new MergeSortedArray().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
