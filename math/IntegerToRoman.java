package leetcode.math;

/* https://leetcode.com/problems/integer-to-roman/ */
/* Runtime: 3 ms, faster than 100.00% Memory Usage: 38.4 MB, less than 84.70% */
public class IntegerToRoman {

    static int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    static String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public static String intToRoman(int num) {

        StringBuilder solution = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                solution.append(romans[i]);
                num -= nums[i];
            }
        }
        return solution.toString();
    }
}
