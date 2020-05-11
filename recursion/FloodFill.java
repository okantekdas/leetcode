package leetcode.recursion;

import java.util.Arrays;

/* https://leetcode.com/problems/flood-fill */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        calculateFloodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void calculateFloodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor
                || image[sr][sc] == newColor) {
            return;
        }

        image[sr][sc] = newColor;

        // up
        calculateFloodFill(image, sr - 1, sc, newColor, oldColor);
        // down
        calculateFloodFill(image, sr + 1, sc, newColor, oldColor);
        // left
        calculateFloodFill(image, sr, sc + 1, newColor, oldColor);
        // right
        calculateFloodFill(image, sr, sc - 1, newColor, oldColor);

    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 0, 1 } };
        int sr = 3;
        int sc = 2;
        int newColor = 2;

        image = new FloodFill().floodFill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(image));
    }

}