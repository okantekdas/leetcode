package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/symmetric-tree/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 37.2 MB, less than 97.93% */
public class SymmetricTree {

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

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricRecursive(root.left, root.right);
    }

    public boolean isSymmetricRecursive(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetricRecursive(left.right, right.left)
                && isSymmetricRecursive(left.left, right.right);
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                queue.add(node.left);
                queue.add(node.right);

            }

            int left = 0;
            int right = queue.size() - 1;

            List<TreeNode> nodes = new ArrayList<>(queue);
            while (left < right) {
                if (nodes.get(left) != null && nodes.get(right) != null) {
                    if (nodes.get(left).val != nodes.get(right).val) {
                        return false;
                    }
                } else if (nodes.get(left) != null || nodes.get(right) != null) {
                    return false;
                }
                left++;
                right--;

            }
        }

        return true;
    }
}
