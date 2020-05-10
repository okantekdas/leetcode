package leetcode.recursion;

/* https://leetcode.com/problems/decode-string/ */
public class DecodeString {

    int left = 0;

    public String decodeString(String s) {

        StringBuilder strBuilder = new StringBuilder();
        while (left < s.length()) {
            char currentChar = s.charAt(left);

            if (65 > (int) currentChar) {
                int numBeginIndex = left;
                while (currentChar != '[') {
                    left++;
                    currentChar = s.charAt(left);
                }
                int num = Integer.valueOf(s.substring(numBeginIndex, left));
                left++;
                strBuilder.append(multiplyResult(decodeString(s), num));
            } else if (currentChar == ']') {
                left++;
                return strBuilder.toString();
            } else {
                strBuilder.append(currentChar);
                left++;
            }

        }

        return strBuilder.toString();
    }

    private StringBuilder multiplyResult(String decodeString, int num) {

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            strBuilder.append(decodeString);
        }
        return strBuilder;
    }

    public static void main(String[] args) {
        // String s = "3[a]2[bc]";
        // String s = "2[abc]3[cd]ef";
        // String s = "3[a2[c]]";
        String s = "a3[b]c";

        System.out.println(new DecodeString().decodeString(s));
    }

}