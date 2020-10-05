package leetcode.bit;

/* https://leetcode.com/problems/complement-of-base-10-integer/ */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        int allBits = log2(N) + 1;
        int allBitsNum = (1 << allBits) - 1;
        return N ^ allBitsNum;
    }

    public int log2(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }
}
