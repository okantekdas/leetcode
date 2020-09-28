package leetcode.twopointers;

public class ReverseString {

    public void reverseString(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int right = s.length - 1;
        int left = 0;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        new ReverseString().reverseString(s);

        System.out.println(s);
    }

}