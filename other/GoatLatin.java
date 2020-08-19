package leetcode.other;

/* https://leetcode.com/problems/goat-latin/ */
public class GoatLatin {

    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");

        StringBuilder solution = new StringBuilder();
        int counter = 1;
        for (String word : strArr) {
            if (word.isEmpty()) {
                continue;
            }
            StringBuilder strBuilder = new StringBuilder();
            if (counter > 1) {
                strBuilder.append(" ");
            }

            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o'
                    || word.charAt(0) == 'u' || word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I'
                    || word.charAt(0) == 'O' || word.charAt(0) == 'U') {
                strBuilder.append(word);
                strBuilder.append("ma");
            } else {

                strBuilder.append(word.substring(1, word.length()));
                strBuilder.append(word.charAt(0));
                strBuilder.append("ma");
            }

            for (int i = 0; i < counter; i++) {
                strBuilder.append("a");
            }

            solution.append(strBuilder.toString());

            counter++;
        }

        return solution.toString();
    }

    public static void main(String[] args) {

        String s = "I speak Goat Latin";

        System.out.println(new GoatLatin().toGoatLatin(s));
    }

}