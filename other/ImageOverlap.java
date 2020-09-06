package leetcode.other;

public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {

        int max = 0;
        for (int yA = -A.length; yA < A.length; yA++) {
            for (int xA = -A[0].length; xA < A[0].length; xA++) {

                int subsolution = 0;
                for (int yB = 0; yB < B.length; yB++) {
                    for (int xB = 0; xB < B[0].length; xB++) {
                        if (yB + yA >= 0 && xB + xA >= 0 && yB + yA < A.length && xB + xA < A.length && A[yB][xB] == 1
                                && B[yB + yA][xB + xA] == 1) {
                            subsolution++;
                        }
                    }
                }
                max = Math.max(max, subsolution);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] B = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };

        System.out.println(new ImageOverlap().largestOverlap(A, B));

    }
}
