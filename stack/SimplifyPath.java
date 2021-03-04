package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/* https://leetcode.com/problems/simplify-path/ */
/* Runtime: 2 ms, faster than 99.51% */
public class SimplifyPath {
    public String simplifyPath(String path) {

        Deque<String> deque = new LinkedList<>();

        int left = -1;
        int right = 0;

        while (right < path.length()) {
            if (path.charAt(right) == '/' || right == path.length() - 1) {
                if (left < 0) {
                    left = right;
                } else {

                    if (path.charAt(right) == '/' && left + 1 == right) {
                        left = right;
                        right++;
                        continue;
                    }

                    int curRight = path.charAt(right) == '/' ? right : right + 1;
                    String subDirectory = path.substring(left, curRight);
                    left = right;
                    if (subDirectory.equals("/.")) {
                        right++;
                        continue;

                    } else if (subDirectory.equals("/..")) {
                        // go upper directory
                        if (!deque.isEmpty()) {
                            deque.pop();
                        }

                    } else {
                        deque.push(subDirectory);
                    }

                }
            }

            right++;
        }

        StringBuilder strBuilder = new StringBuilder();

        while (!deque.isEmpty()) {
            strBuilder.append(deque.pollLast());
        }
        String result = strBuilder.toString();

        return result.isBlank() ? "/" : result;
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/.././c"));
    }
}
