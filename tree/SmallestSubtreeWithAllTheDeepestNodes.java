package leetcode.tree;

/* https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 37 MB, less than 78.45% */
public class SmallestSubtreeWithAllTheDeepestNodes {
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

    TreeNode deepestNode = null;
    int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        subtreeWithAllDeepestHelper(root, 0);
        return deepestNode;
    }

    public int subtreeWithAllDeepestHelper(TreeNode root, int level) {

        if (root == null) {
            return level - 1;
        }

        int leftMax = subtreeWithAllDeepestHelper(root.left, level + 1);
        int rightMax = subtreeWithAllDeepestHelper(root.right, level + 1);

        if (level > maxDepth) {
            maxDepth = level;
            deepestNode = root;
        } else if (leftMax == rightMax && leftMax == maxDepth) {
            deepestNode = root;
        }

        return Math.max(leftMax, rightMax);
    }

}
