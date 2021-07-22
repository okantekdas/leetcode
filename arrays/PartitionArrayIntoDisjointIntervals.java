package leetcode.arrays;

/* Runtime: 2 ms, faster than 66.35% Memory Usage: 43.6 MB, less than 62.35% */
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] nums) {

        int length = nums.length;
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];

        int max = nums[0];
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        int min = nums[length - 1];
        for (int i = length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        for (int i = 1; i < length; i++) {
            if (maxArr[i - 1] <= minArr[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 0, 3, 8, 6 };
        System.out.println(new PartitionArrayIntoDisjointIntervals().partitionDisjoint(nums));
    }
}
