package leetcode.other;

public class NumberComplement {

    public int findComplement(int num) {

        int allBits = log2(num) + 1;
        int allBitsNum = (1 << allBits) - 1;
        return num ^ allBitsNum;
    }

    public int log2(int num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(2147483647));
    }

}