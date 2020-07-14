package leetcode.other;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {

        if (hour == 12) {
            hour = 0;
        }

        double minPercentage = (double) minutes / 60;

        double hourExtraAngle = 30 * minPercentage;
        double hourAngle = hour * 30 + hourExtraAngle;
        double minAngle = 360 * minPercentage;

        double solution = Math.abs(hourAngle - minAngle);
        return Math.min(solution, 360 - solution);
    }

    public static void main(String[] args) {
        int hour = 1;
        int minutes = 57;

        System.out.println(new AngleBetweenHandsOfAClock().angleClock(hour, minutes));
    }
}