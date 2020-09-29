package leetcode.tree;

/* https://leetcode.com/problems/recover-binary-search-tree/ */
public class RecoverBinarySearchTree {
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

    boolean isChanged = true;

    public void recoverTree(TreeNode root) {

        while (isChanged) {
            isChanged = false;
            dfs(root, null, null);
        }

    }

    public void dfs(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) {
            return;
        }

        if ((minNode != null && root.val < minNode.val) || (maxNode != null && root.val > maxNode.val)) {

            TreeNode node = null;
            if (minNode != null && root.val < minNode.val) {
                node = minNode;
            } else {
                node = maxNode;
            }

            int rootVal = root.val;
            root.val = node.val;
            node.val = rootVal;
            isChanged = true;

            return;

        }

        dfs(root.left, minNode, root);
        dfs(root.right, root, maxNode);

    }

}
