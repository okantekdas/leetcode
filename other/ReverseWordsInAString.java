package leetcode.other;

public class ReverseWordsInAString {

    public String reverseWords(String s) {

        StringBuilder strBuilder = new StringBuilder();

        int left = 0;
        int right = 0;

        char[] charArr = s.toCharArray();
        while (right < s.length()) {
            if (charArr[right] == ' ' && charArr[left] != ' ') {
                if (strBuilder.length() != 0) {
                    strBuilder.insert(0, " ");
                }
                char[] temp = new char[right - left];
                System.arraycopy(charArr, left, temp, 0, right - left);
                strBuilder.insert(0, String.valueOf(temp));
                left = right;
            } else if (charArr[left] == ' ') {
                left++;
            }

            right++;
        }
        while (left < right) {
            if (charArr[left] == ' ') {
                left++;
            } else {
                if (strBuilder.length() != 0) {
                    strBuilder.insert(0, " ");
                }
                char[] temp = new char[right - left];
                System.arraycopy(charArr, left, temp, 0, right - left);
                strBuilder.insert(0, String.valueOf(temp));
                left = right;
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {

        String s = "                 ba               ";

        System.out.println(new ReverseWordsInAString().reverseWords(s));
    }

}