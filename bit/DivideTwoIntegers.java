package leetcode.bit;

/* https://leetcode.com/problems/divide-two-integers/ */
/* Runtime: 1 ms, faster than 99.98% Memory Usage: 35.8 MB, less than 92.13%*/
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        boolean isNegative = (((dividend >> 31) & 1) ^ ((divisor >> 31) & 1)) > 0 ? true : false;

        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long result = 0;

        while (dividendLong >= divisorLong) {
            long count = 1;
            long tempDivisor = divisorLong;
            while (dividendLong >= tempDivisor) {
                tempDivisor <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            dividendLong -= tempDivisor >> 1;
        }

        return (int) (isNegative ? ~result : result);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, 3));
    }

}
