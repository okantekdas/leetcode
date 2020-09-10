package leetcode.hashtable;

/* https://leetcode.com/problems/bulls-and-cows/ */
public class BullsAndCows {
    public String getHint(String secret, String guess) {

        int cow = 0;
        int bull = 0;

        int[] charToCount = new int[128];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                charToCount[secret.charAt(i)]++;
            } else {
                bull++;
            }

        }

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g) {

                if (charToCount[g] > 0) {
                    cow++;
                    charToCount[g]--;
                }

            }
        }
        StringBuilder solution = new StringBuilder().append(bull).append("A").append(cow).append("B");

        return solution.toString();
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(new BullsAndCows().getHint(secret, guess));
    }
}
