package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* https://leetcode.com/problems/binary-tree-level-order-traversal-ii */
public class BinaryTreeLevelOrderTraversal2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> solution = new ArrayList<>();

        if (root == null) {
            return solution;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                values.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

            }
            solution.add(0, values);
        }

        return solution;

    }
}