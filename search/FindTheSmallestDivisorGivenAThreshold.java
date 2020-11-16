package leetcode.search;

/* https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/ */
/* Runtime: 28 ms, faster than 25.01% */
public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {

        float d = (float) nums[0] / (float) threshold;
        int val = (int) Math.ceil(d);

        return smallestDivisorHelper(nums, threshold, val, nums[nums.length - 1]);
    }

    public int smallestDivisorHelper(int[] nums, int threshold, int left, int right) {

        if (left == right) {
            if (isSmallerThanThreshold(nums, threshold, left)) {
                return left;
            }
            return left + 1;
        }
        int middle = left + (right - left) / 2;

        if (isSmallerThanThreshold(nums, threshold, middle)) {
            return smallestDivisorHelper(nums, threshold, left, middle);
        }
        return smallestDivisorHelper(nums, threshold, middle + 1, right);
    }

    public boolean isSmallerThanThreshold(int[] nums, int threshold, int number) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            float d = (float) nums[i] / (float) number;
            int val = (int) Math.ceil(d);
            counter += val;
            if (counter > threshold) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;
        System.out.println(new FindTheSmallestDivisorGivenAThreshold().smallestDivisor(nums, threshold));
    }

}
