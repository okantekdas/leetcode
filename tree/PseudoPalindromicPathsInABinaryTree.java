package leetcode.tree;

/* https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree */
/* Runtime: 2 ms, faster than 100.00% Memory Usage: 56.7 MB, less than 91.41%  */
public class PseudoPalindromicPathsInABinaryTree {

    int count = 0;

    public int pseudoPalindromicPaths(TreeNode root) {

        if (root == null) {
            return 0;
        }

        count = count ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            int result = (count & (count - 1)) == 0 ? 1 : 0;
            count = count ^ (1 << root.val);
            return result;
        }

        int leftCount = pseudoPalindromicPaths(root.left);
        int rightCount = pseudoPalindromicPaths(root.right);

        count = count ^ (1 << root.val);
        return leftCount + rightCount;
    }

}
