package leetcode.twopointers;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int product = 1;
        int count = 0;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            count += right - left + 1;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = { 10, 5, 2, 6 };
        int k = 100;

        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));

    }

}
