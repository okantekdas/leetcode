package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/minimum-absolute-difference-in-bst/ */
public class MinimumAbsoluteDifferenceInBST {

    class TreeNode {
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

    int min = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        int index = list.size();
        list.add(root.val);
        dfs(root.right);
        if (index > 0) {
            min = Math.min(min, root.val - list.get(index - 1));
        }
    }

}
