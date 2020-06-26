package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/* https://leetcode.com/problems/binary-tree-paths/ */
public class BinaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> path = new ArrayList<>();
        if (root == null) {
            return path;
        }
        String currentVal = String.valueOf(root.val);
        List<String> leftSubtree = binaryTreePaths(root.left);
        List<String> rightSubtree = binaryTreePaths(root.right);

        for (String left : leftSubtree) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(currentVal);
            strBuilder.append("->");
            strBuilder.append(left);
            path.add(strBuilder.toString());
        }
        for (String right : rightSubtree) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append(currentVal);
            strBuilder.append("->");
            strBuilder.append(right);
            path.add(strBuilder.toString());
        }

        if (path.isEmpty()) {
            path.add(currentVal);
        }

        return path;

    }

}