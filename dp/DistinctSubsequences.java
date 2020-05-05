package leetcode.dp;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int[][] memo = new int[s.length()][t.length()];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }

        return calculatenumDistinct(s, t, memo);
    }

    public int calculatenumDistinct(String s, String t, int[][] memo) {

        if (t.isEmpty()) {
            return 1;
        }
        if (s.isEmpty()) {
            return 0;
        }

        if (memo[s.length() - 1][t.length() - 1] != -1) {
            return memo[s.length() - 1][t.length() - 1];
        }

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                counter += calculatenumDistinct(s.substring(i + 1, s.length()), t.substring(1, t.length()), memo);
            }
        }

        memo[s.length() - 1][t.length() - 1] = counter;

        return counter;
    }

    public static void main(String[] args) {
        String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";

        String t = "bcddceeeebecbc";

        // String s =
        // "xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo";
        // String t = "rwmimatmhydhbujebqehjprrwfkoebcxxqfktayaaeheys";

        System.out.println(new DistinctSubsequences().numDistinct(s, t));

    }
}