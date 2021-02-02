package leetcode.tree;

/* https://leetcode.com/problems/trim-a-binary-search-tree/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 38.7 MB, less than 72.37%  */
public class TrimABinarySearchTree {

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

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }

        TreeNode left = null;
        TreeNode right = null;
        if (root.val >= low) {
            left = trimBST(root.left, low, high);
            root.left = left;
        }

        if (root.val <= high) {
            right = trimBST(root.right, low, high);
            root.right = right;

        }

        if (root.val < low) {
            return right;
        }

        if (root.val > high) {
            return left;
        }

        return root;
    }

}
