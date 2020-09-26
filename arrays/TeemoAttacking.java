package leetcode.arrays;

/* https://leetcode.com/problems/teemo-attacking */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int end = 0;
        int total = 0;

        for (int time : timeSeries) {

            if (end == 0 || end < time) {
                end = time + duration - 1;
                total += duration;
            } else {

                int temp = end;
                end = time + duration - 1;
                total = total + end - temp;
            }

        }

        return total;
    }

    public static void main(String[] args) {
        int[] timeSeries = { 1, 2, 3, 4, 5 };
        int duration = 3;
        System.out.println(new TeemoAttacking().findPoisonedDuration(timeSeries, duration));
    }
}
