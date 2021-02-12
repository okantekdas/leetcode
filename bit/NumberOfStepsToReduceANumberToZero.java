package leetcode.bit;

/* https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 35.5 MB, less than 94.72%  */
public class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {

        int counter = 0;
        while (num > 0) {

            if ((num & 1) == 0) {
                // even number
                num >>= 1;
            } else {
                // odd number
                num -= 1;
            }
            counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfStepsToReduceANumberToZero().numberOfSteps(123));
    }
}
