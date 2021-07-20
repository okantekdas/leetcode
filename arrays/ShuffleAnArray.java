package leetcode.arrays;

import java.util.Random;

/* Runtime: 72 ms, faster than 89.61% */
public class ShuffleAnArray {

    int[] numsOriginal = null;
    int[] numsCopy = null;
    Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        numsOriginal = nums.clone();
        numsCopy = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        numsCopy = numsOriginal;
        numsOriginal = numsOriginal.clone();
        return numsCopy;
    }

    /* Fisher-Yates Algorithm */
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        for (int i = 0; i < numsCopy.length; i++) {
            int randomIndex = random.nextInt(numsCopy.length - i) + i;
            int temp = numsCopy[randomIndex];
            numsCopy[randomIndex] = numsCopy[i];
            numsCopy[i] = temp;
        }
        return numsCopy;
    }
}
