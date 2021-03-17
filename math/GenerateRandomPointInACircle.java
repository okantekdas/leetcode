package leetcode.math;

/* https://leetcode.com/problems/generate-random-point-in-a-circle/ */
/* Runtime: 195 ms, faster than 99.39% Memory Usage: 47.9 MB, less than 98.78% */
public class GenerateRandomPointInACircle {

    double r;
    double x;
    double y;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double length = Math.sqrt(Math.random()) * r;
        double degree = Math.random() * 360;
        return new double[] { x + length * Math.cos(degree), y + length * Math.sin(degree) };
    }
}
