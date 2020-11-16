package leetcode.tree;

/* https://leetcode.com/problems/range-sum-of-bst/ */
/* Runtime: 0 ms, faster than 100.00% */
public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTHelper(root, low, high, low, high);
    }

    public int rangeSumBSTHelper(TreeNode root, int low, int high, int min, int max) {
        if (root == null || max < min) {
            return 0;
        }

        int sum = low <= root.val && root.val <= high ? root.val : 0;

        sum += rangeSumBSTHelper(root.left, low, high, low, Math.min(root.val, max));
        sum += rangeSumBSTHelper(root.right, low, high, Math.min(root.val, max), high);

        return sum;
    }

    static RangeSumOfBST rsb = new RangeSumOfBST();

    public static void main(String[] args) {

        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node18 = new TreeNode(18);

        node10.left = node5;
        node10.right = node15;

        node5.left = node3;
        node5.right = node7;

        node15.left = node18;

        System.out.println(rsb.rangeSumBST(node10, 6, 15));
    }

}