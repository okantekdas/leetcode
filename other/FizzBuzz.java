package leetcode.other;

import java.util.Arrays;
import java.util.List;

/* https://leetcode.com/problems/fizz-buzz/ */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String[] s = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                s[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                s[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                s[i - 1] = "Buzz";
            } else {
                s[i - 1] = String.valueOf(i);
            }
        }
        return Arrays.asList(s);
    }
}