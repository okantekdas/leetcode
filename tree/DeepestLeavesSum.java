package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/deepest-leaves-sum/ */
public class DeepestLeavesSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int sum = 0;

        while (!queue.isEmpty()) {

            int length = queue.size();
            sum = 0;
            for (int i = 0; i < length; i++) {

                TreeNode current = queue.poll();
                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);

                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return sum;
    }

}
