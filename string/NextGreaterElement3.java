package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/next-greater-element-iii/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 35.4 MB, less than 95.69% */
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {

        if (n == Integer.MAX_VALUE) {
            return -1;
        }

        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            digits.add(digit);
        }

        boolean isPossible = false;
        for (int i = 0; i < digits.size() - 1; i++) {

            if (digits.get(i) > digits.get(i + 1)) {

                for (int j = 0; j <= i; j++) {
                    if (digits.get(j) > digits.get(i + 1)) {
                        int temp = digits.get(i + 1);
                        digits.set(i + 1, digits.get(j));
                        digits.set(j, temp);

                        int mid = i / 2;
                        for (int k = 0; k <= mid; k++) {
                            // reverse till now
                            temp = digits.get(k);
                            digits.set(k, digits.get(i - k));
                            digits.set(i - k, temp);
                        }
                        isPossible = true;
                        break;
                    }
                }
                if (isPossible) {
                    break;
                }

            }
        }
        if (!isPossible) {
            return -1;
        }

        long result = 0;
        for (int i = digits.size() - 1; i >= 0; i--) {
            result *= 10;
            result += digits.get(i);
        }

        return result < Integer.MAX_VALUE ? (int) result : -1;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElement3().nextGreaterElement(230241));
    }
}
