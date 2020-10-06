package leetcode.tree;

/* https://leetcode.com/problems/insert-into-a-binary-search-tree */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 39.5 MB, less than 97.18%*/
public class InsertIntoABinarySearchTree {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);

        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);

        }

        return root;
    }
}
