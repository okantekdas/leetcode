package leetcode.other;

import java.util.HashSet;

public class HappyNumber {

    static int[] numberToSquare = { 0, 1, 4, 9, 16, 25, 36, 49, 64, 81 };

    static HashSet<Integer> seenNumbers = new HashSet<>();

    public boolean isHappy(int n) {

        if (seenNumbers.contains(n)) {
            return n == 1 ? true : false;
        }

        seenNumbers.add(n);
        int subtotal = 0;
        while (n > 1) {

            subtotal += numberToSquare[n % 10];
            n /= 10;

        }

        subtotal += numberToSquare[n % 10];
        if (subtotal == 1) {
            return true;
        }

        return isHappy(subtotal);

    }

    public static void main(String[] args) {

        System.out.println(new HappyNumber().isHappy(16));

    }

}