package leetcode.math;

/* https://leetcode.com/problems/reach-a-number/ */
/* Runtime: 1 ms, faster than 89.44% */
public class ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(25));
    }

}
