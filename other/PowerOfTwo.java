package leetcode.other;

import java.util.HashSet;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    HashSet<Integer> powersOfTwo = new HashSet<>();
    boolean isCalculated = false;

    public void calculatePowersOfTwo() {
        int[] arr = new int[32];

        arr[0] = 1;
        powersOfTwo.add(arr[0]);
        for (int i = 1; i < 32; i++) {
            arr[i] = 2 * arr[i - 1];
            powersOfTwo.add(arr[i]);
        }
        isCalculated = true;
    }

    // 4 ms
    public boolean isPowerOfTwoAlternate(int n) {
        if (n < 1) {
            return false;
        }
        if (!isCalculated) {
            calculatePowersOfTwo();
        }

        return powersOfTwo.contains(n);
    }

}