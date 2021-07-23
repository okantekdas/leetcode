package leetcode.tree;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        root.left = left;
        root.right = right;

        if (left == null && right == null) {
            if (root.val == 0) {
                return null;
            }
        }

        return root;
    }
}
