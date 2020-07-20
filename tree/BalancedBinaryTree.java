package leetcode.tree;

public class BalancedBinaryTree {
    public class TreeNode {
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

    boolean solution = true;

    public boolean isBalanced(TreeNode root) {
        calculateHeight(root);
        return solution;
    }

    public int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = 1 + calculateHeight(root.left);
        int rightHeight = 1 + calculateHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            solution = false;
        }
        return Math.max(leftHeight, rightHeight);

    }
}