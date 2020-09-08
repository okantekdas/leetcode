package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/ */
public class SumOfRootToLeafBinaryNumbers {

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

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {

        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int cumulative) {

        if (root == null) {
            return;
        }
        cumulative = (cumulative << 1) | root.val;

        if (root.left == null && root.right == null) {
            sum += cumulative;
            return;
        }
        dfs(root.left, cumulative);
        dfs(root.right, cumulative);
    }
}
