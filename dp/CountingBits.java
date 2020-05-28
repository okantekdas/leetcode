package leetcode.dp;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int num) {
        int[] results = new int[num + 1];

        results[0] = 0;
        if (num == 0) {
            return results;
        }

        for (int i = 1; i <= num; i++) {
            int iLog = log2(i);
            results[i] = 1 + results[i - (int) Math.pow(2, iLog)];
        }

        return results;
    }

    public int log2(int N) {

        int result = (int) (Math.log(N) / Math.log(2));

        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new CountingBits().countBits(16)));
    }

}