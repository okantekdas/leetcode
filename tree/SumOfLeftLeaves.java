package leetcode.tree;

/* https://leetcode.com/problems/sum-of-left-leaves/ */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = sumOfLeftLeaves(root.left, true);
        int rightSum = sumOfLeftLeaves(root.right, false);

        return leftSum + rightSum;

    }
}