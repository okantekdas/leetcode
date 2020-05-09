package leetcode.search;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {

        return calcualteIsPerfectSquare(num, 1, num);

    }

    public boolean calcualteIsPerfectSquare(int num, long left, long right) {

        if (left > right) {
            return false;
        }
        if (left * left > num) {
            return false;
        }
        if (right * right < num) {
            return false;
        }
        if (left == right) {
            return num == left * left;
        }

        long mid = left + (right - left) / 2;
        if (mid * mid == num) {
            return true;
        }

        return calcualteIsPerfectSquare(num, left, mid) || calcualteIsPerfectSquare(num, mid + 1, right);
    }

    public static void main(String[] args) {

        System.out.println(new ValidPerfectSquare().isPerfectSquare(2147395600));

    }
}