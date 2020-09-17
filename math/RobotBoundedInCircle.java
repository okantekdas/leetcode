package leetcode.math;

/* https://leetcode.com/problems/robot-bounded-in-circle/ */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {

        int netDirection = 0;
        char direction = 'N';
        int x = 0;
        int y = 0;

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (direction == 'N') {
                    y++;
                } else if (direction == 'S') {
                    y--;
                } else if (direction == 'W') {
                    x--;
                } else if (direction == 'E') {
                    x++;
                }
            }

            else if (c == 'L') {
                netDirection++;
                if (direction == 'N') {
                    direction = 'W';
                } else if (direction == 'S') {
                    direction = 'E';
                } else if (direction == 'W') {
                    direction = 'S';
                } else if (direction == 'E') {
                    direction = 'N';
                }
            } else if (c == 'R') {
                netDirection--;
                if (direction == 'N') {
                    direction = 'E';
                } else if (direction == 'S') {
                    direction = 'W';
                } else if (direction == 'W') {
                    direction = 'N';
                } else if (direction == 'E') {
                    direction = 'S';
                }
            }

        }

        if ((x == 0 && y == 0) || (direction != 'N')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RobotBoundedInCircle().isRobotBounded("GGLLGG"));
    }
}
