package leetcode.other;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        char[] charArr = s.toLowerCase().toCharArray();

        int left = 0;
        int right = charArr.length - 1;

        while (left <= right) {
            int rightVal = charArr[right];
            int leftVal = charArr[left];
            if (leftVal < 97 && (leftVal < 48 || leftVal > 57) || leftVal > 122 || leftVal == 32) {
                left++;
                continue;
            }
            if (rightVal < 97 && (rightVal < 48 || rightVal > 57) || rightVal > 122 || rightVal == 32) {
                right--;
                continue;
            }

            if (charArr[left++] != charArr[right--]) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "0P";

        System.out.println(new ValidPalindrome().isPalindrome(s));
    }
}