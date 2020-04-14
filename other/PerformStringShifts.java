package leetcode.other;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shift) {

        boolean isRightShift = false;
        int amount = 0;

        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                amount -= shift[i][1];
            } else {
                amount += shift[i][1];
            }
        }

        if (amount == 0) {
            return s;
        }
        if (amount > 0) {
            isRightShift = true;
        } else {
            amount *= -1;
        }

        amount %= s.length();

        if (isRightShift) {
            String strEnd = s.substring(s.length() - amount, s.length());
            String strStart = s.substring(0, s.length() - amount);
            return strEnd + strStart;
        } else {
            String strStart = s.substring(0, amount);
            String strEnd = s.substring(amount, s.length());

            return strEnd + strStart;
        }

    }

    public static void main(String[] args) {

        String s = "yisxjwry";
        int[][] shift = { { 1, 8 }, { 1, 4 }, { 1, 3 }, { 1, 6 }, { 0, 6 }, { 1, 4 }, { 0, 2 }, { 0, 1 } };
        System.out.println(new PerformStringShifts().stringShift(s, shift));

    }

}