package leetcode.search;

interface VersionControl {
    boolean isBadVersion(int version);
}

/* https://leetcode.com/problems/first-bad-version */
public class FirstBadVersion implements VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {

            int middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }
        return left;
    }

    /* 78 ms */
    public int firstBadVersionAlternate(int n) {
        traverseBadVersions(n, 1, n);
        return globalMin;
    }

    int globalMin = Integer.MAX_VALUE;

    public void traverseBadVersions(int n, int left, int right) {

        if (left > right) {
            return;
        }
        if (left == right && isBadVersion(left)) {

            globalMin = Math.min(globalMin, left);
            return;
        }

        int middle = left + (right - left) / 2;
        boolean isMiddleBadSolution = isBadVersion(middle);

        if (isMiddleBadSolution) {
            traverseBadVersions(n, 1, middle);
        } else {
            traverseBadVersions(n, middle + 1, right);

        }
    }

    @Override
    public boolean isBadVersion(int version) {
        // TODO Auto-generated method stub
        return false;
    }

}