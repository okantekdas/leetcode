package leetcode.math;

/* https://leetcode.com/problems/poor-pigs/ */
/* Runtime: 0 ms, faster than 100.00% */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return buckets == 0 ? 0 : (int) Math.ceil(logN(buckets, minutesToTest / minutesToDie + 1));
    }

    public double logN(int num, int logBase) {
        return Math.log(num) / Math.log(logBase);
    }

}
