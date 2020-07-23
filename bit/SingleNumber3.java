package leetcode.bit;

/* https://leetcode.com/problems/single-number-iii/ */
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum ^= num;
        }

        int lowestBit = sum & (-sum);

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lowestBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] { a, b };

    }

}