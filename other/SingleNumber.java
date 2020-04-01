package leetcode.other;

/**
 * SingleNumber
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {

        int singleNumber = 0;

        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;

    }

    public static void main(String[] args) {

        int[] nums = { 4, 1, 2, 1, 2 };

        System.out.println("Single Number: " + new SingleNumber().singleNumber(nums));

    }
}