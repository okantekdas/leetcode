package leetcode.other;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        int left = 0;
        int right = 0;
        int total = 0;
        int maxDiff = 0;
        int localMin = 0;
        int localMax = 0;

        while (right < grumpy.length) {

            if (right - left == X) {
                maxDiff = Math.max(maxDiff, localMax - localMin);
                if (grumpy[left] == 0) {
                    localMin -= customers[left];
                }
                localMax -= customers[left];

                left++;
            }
            if (grumpy[right] == 0) {
                localMin += customers[right];
                total += customers[right];
            }
            localMax += customers[right];

            right++;

        }

        if (right - left == X) {
            maxDiff = Math.max(maxDiff, localMax - localMin);
            if (grumpy[left] == 0) {
                localMin -= customers[left];
            }
            localMax -= customers[left];
        }
        return total + maxDiff;
    }

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int X = 3;

        System.out.println(new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, X));
    }

}