package leetcode.other;

public class MinimumNumberOfFrogsCroaking {

    public int minNumberOfFrogs(String croakOfFrogs) {

        int[] count = new int[5];
        int frogCount = 0;

        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                count[0]++;
            } else if (c == 'r') {
                if (count[0] == 0) {
                    return -1;
                }
                count[0]--;
                count[1]++;

            } else if (c == 'o') {
                if (count[1] == 0) {
                    return -1;
                }
                count[1]--;
                count[2]++;

            } else if (c == 'a') {
                if (count[2] == 0) {
                    return -1;
                }
                count[2]--;
                count[3]++;

            } else if (c == 'k') {
                if (count[3] == 0) {
                    return -1;
                }
                count[3]--;
                count[4]++;
            }
            frogCount = Math.max(frogCount, count[0] + count[1] + count[2] + count[3] + count[4]);

            count[4] = 0;

        }
        if (count[0] != 0 || count[1] != 0 || count[2] != 0 || count[3] != 0 || count[3] != 0) {
            return -1;
        }

        return frogCount;
    }

    public static void main(String[] args) {

        String croakOfFrogs = "crocakcroraoakk";
        System.out.println(new MinimumNumberOfFrogsCroaking().minNumberOfFrogs(croakOfFrogs));
    }

}