package leetcode.other;

import java.util.Arrays;
import java.util.Stack;

/* https://leetcode.com/problems/asteroid-collision/ */
/* Runtime: 3 ms, faster than 97.16% */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                int candidate = stack.lastElement();

                while (((candidate > 0 && asteroid < 0))) {
                    if (-asteroid > candidate) {
                        stack.pop();

                    } else if (-asteroid == candidate) {
                        stack.pop();
                        break;
                    } else {
                        break;
                    }

                    if (stack.isEmpty()) {
                        break;
                    } else {
                        candidate = stack.lastElement();
                    }
                }
                if (-asteroid > candidate || candidate < 0 || (candidate > 0 && asteroid > 0)) {
                    stack.push(asteroid);
                }
            }

        }

        // return stack.stream().mapToInt(i -> i).toArray();
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] asteroids = { -2, -1, 1, 2 };

        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(asteroids)));
    }
}
