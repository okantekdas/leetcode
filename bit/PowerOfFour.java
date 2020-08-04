package leetcode.bit;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }

        boolean hasOneBit = false;
        for (int i = 0; i < 32; i++) {
            if (i % 2 == 0 && ((num >> i & 1) == 1)) {
                if (hasOneBit) {
                    return false;
                } else {
                    hasOneBit = true;
                }
            } else if (((num >> i & 1) == 1)) {
                return false;
            }

        }
        return true;
    }

    // 2^0, 2^2, 2^4, 2^6, 2^8

    public static void main(String[] args) {

        System.out.println(new PowerOfFour().isPowerOfFour(2));

    }

}