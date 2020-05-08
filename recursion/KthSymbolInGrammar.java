package leetcode.recursion;

public class KthSymbolInGrammar {

    public int kthGrammar(int N, int K) {
        return calculateKthGrammar(N, K - 1);
    }

    public int calculateKthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }
        int solution = calculateKthGrammar(N - 1, K / 2);
        solution = solution == 1 ? 10 : 01;

        return K % 2 == 1 ? solution % 10 : solution / 10;
    }

    public static void main(String[] args) {

        int N = 4;
        int K = 8;

        System.out.println(new KthSymbolInGrammar().kthGrammar(N, K));
    }

}