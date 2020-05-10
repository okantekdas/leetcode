package leetcode.graph;

public class FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {

        if (trust == null || trust.length == 0) {
            return N;
        }

        boolean[] visited = new boolean[N + 1];
        int trustCount[] = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
            int[] personToTrust = trust[i];
            int person = personToTrust[0];
            int trustedPerson = personToTrust[1];
            visited[person] = true;
            trustCount[trustedPerson]++;
        }

        for (int i = 0; i < trustCount.length; i++) {
            if (trustCount[i] == N - 1 && !visited[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int N = 1;
        // int[][] trust = { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        // int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        int[][] trust = {};

        System.out.println(new FindTheTownJudge().findJudge(N, trust));
    }

}