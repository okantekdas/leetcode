package leetcode.bit;

/* https://leetcode.com/problems/reverse-bits/ */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int reversedNumber = 0;
        for (int i = 0; i < 32; i++) {
            if (i > 0) {
                reversedNumber = reversedNumber << 1;
            }
            if (((n >> i) & 1) == 1) {
                reversedNumber++;
            }

        }

        return reversedNumber;
    }

    public static void main(String[] args) {
        int n = -3;

        System.out.println(new ReverseBits().reverseBits(n));
    }
}