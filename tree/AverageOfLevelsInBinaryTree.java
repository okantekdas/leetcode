package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Runtime: 1 ms, faster than 100.00% Memory Usage: 40.5 MB, less than 97.32% */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        ArrayList<Double> averages = new ArrayList<>();
        while (!queue.isEmpty()) {

            int size = queue.size();

            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            averages.add(sum / size);
        }
        return averages;
    }
}
