package leetcode.tree;

/* https://leetcode.com/problems/increasing-order-search-tree/ */
/* Runtime: 0 ms, faster than 100.00% Memory Usage: 36.4 MB, less than 67.02% */
public class IncreasingOrderSearchTree {
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

    TreeNode leftMost = new TreeNode();;

    public TreeNode increasingBST(TreeNode root) {

        TreeNode smallest = leftMost;
        increasingBSTHelper(root);

        return smallest.right;
    }

    public void increasingBSTHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        increasingBSTHelper(root.left);

        root.left = null;
        leftMost.right = root;
        leftMost = root;

        increasingBSTHelper(root.right);

    }

    static IncreasingOrderSearchTree iost = new IncreasingOrderSearchTree();

    public static void main(String[] args) {

        TreeNode node1 = iost.new TreeNode(1);
        TreeNode node2 = iost.new TreeNode(2);
        TreeNode node3 = iost.new TreeNode(3);
        TreeNode node4 = iost.new TreeNode(4);
        TreeNode node5 = iost.new TreeNode(5);
        TreeNode node6 = iost.new TreeNode(6);
        TreeNode node7 = iost.new TreeNode(7);
        TreeNode node8 = iost.new TreeNode(8);
        TreeNode node9 = iost.new TreeNode(9);

        node2.left = node1;
        node3.left = node2;
        node3.right = node4;
        node5.left = node3;
        node5.right = node6;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;

        TreeNode treeNode = iost.increasingBST(node5);

        System.out.println(treeNode);
    }

}
