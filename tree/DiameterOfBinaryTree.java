package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* https://leetcode.com/problems/diameter-of-binary-tree/ */

public class DiameterOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {

        calculateDiameterOfBinaryTree(root);
        return max;
    }

    int max = 0;

    public int calculateDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }

        int farthestLeftPath = 0;
        int farthestRightPath = 0;
        if (root.left != null) {
            farthestLeftPath += calculateDiameterOfBinaryTree(root.left) + 1;
        }
        if (root.right != null) {
            farthestRightPath += calculateDiameterOfBinaryTree(root.right) + 1;
        }

        int diameter = farthestLeftPath + farthestRightPath;
        if (diameter > max) {
            max = diameter;
        }

        return farthestLeftPath > farthestRightPath ? farthestLeftPath : farthestRightPath;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new DiameterOfBinaryTree().diameterOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    static DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = dbt.new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = dbt.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = dbt.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
