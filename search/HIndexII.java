package leetcode.search;

public class HIndexII {

    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }

        return calcualteIndex(citations, 0, citations.length - 1);
    }

    public int calcualteIndex(int[] citations, int left, int right) {
        int middle = left + (right - left) / 2;

        if (left > right) {
            return 0;
        }
        if (left == right) {
            if (citations[left] == 0) {
                return 0;
            }

            return Math.min(citations[left], citations.length - left);
        }

        int max = 0;

        if (citations[middle] == citations.length - middle) {
            return citations.length - middle;
        }

        if (citations[middle] < citations.length - middle) {
            return calcualteIndex(citations, middle + 1, right);
        }
        if (citations[middle] > citations.length - middle) {
            max = citations.length - middle;
            int solution = calcualteIndex(citations, left, middle - 1);
            max = Math.max(solution, max);
        }

        return max;

    }

    public static void main(String[] args) {
        int[] citations = { 1, 4, 7, 9 };
        System.out.println(new HIndexII().hIndex(citations));
    }

}