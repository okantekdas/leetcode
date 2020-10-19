package leetcode.greedy;

/* https://leetcode.com/problems/minimum-domino-rotations-for-equal-row */
/* Runtime: 3 ms, faster than 98.43% */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {

        int[] rotation = new int[4];
        // A[0] accepted as is
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[0]) {
                if (B[i] != A[0]) {
                    rotation[0] = -1;
                    break;
                } else {
                    rotation[0]++;
                }
            }
        }

        if (rotation[0] == 0) {
            return 0;
        }
        // A[0] rotated
        rotation[1]++;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != B[0]) {
                if (B[i] != B[0]) {
                    rotation[1] = -1;
                    break;
                } else {
                    rotation[1]++;
                }
            }
        }
        if (rotation[1] == 0) {
            return 0;
        }
        // B[0] accepted as is
        for (int i = 1; i < A.length; i++) {
            if (B[i] != B[0]) {
                if (A[i] != B[0]) {
                    rotation[2] = -1;
                    break;
                } else {
                    rotation[2]++;
                }
            }
        }
        if (rotation[2] == 0) {
            return 0;
        }
        // B[0] rotated
        rotation[3]++;
        for (int i = 1; i < A.length; i++) {
            if (B[i] != A[0]) {
                if (A[i] != A[0]) {
                    rotation[3] = -1;
                    break;
                } else {
                    rotation[3]++;
                }
            }
        }

        if (rotation[3] == 0) {
            return 0;
        }

        int minRotation = A.length;
        for (int i = 0; i < rotation.length; i++) {
            if (rotation[i] > -1) {
                minRotation = Math.min(minRotation, rotation[i]);
            }

        }

        return minRotation == A.length ? -1 : minRotation;

    }

    public static void main(String[] args) {
        int[] A = { 1, 1, 0, 0, 0, 1 };
        int[] B = { 0, 0, 1, 1, 0, 0 };

        System.out.println(new MinimumDominoRotationsForEqualRow().minDominoRotations(A, B));
    }
}
