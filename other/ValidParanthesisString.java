package leetcode.other;

/* https://leetcode.com/problems/valid-parenthesis-string/ */
public class ValidParanthesisString {

    public boolean checkValidString(String s) {

        char[] charArr = s.toCharArray();

        int minLeftCount = 0;
        int maxLeftCount = 0;
        for (int i = 0; i < charArr.length; i++) {

            char current = charArr[i];
            if (current == '(') {
                minLeftCount++;
                maxLeftCount++;
            } else if (current == '*') {
                minLeftCount--;
                maxLeftCount++;
            } else {
                minLeftCount--;
                maxLeftCount--;
            }

            if (maxLeftCount < 0) {
                return false;
            }
            if (minLeftCount < 0) {
                minLeftCount = 0;
            }
        }

        return minLeftCount == 0;

    }

    public static void main(String[] args) {

        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(new ValidParanthesisString().checkValidString(s));
    }

}