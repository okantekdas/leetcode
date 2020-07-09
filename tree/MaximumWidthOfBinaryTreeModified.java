package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MaximumWidthOfBinaryTree
 */
public class MaximumWidthOfBinaryTreeModified {

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

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        int max = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            Integer left = null;
            Integer right = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (left == null) {
                    left = node.val;
                } else {
                    right = node.val;
                }
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
            }

            if (left == null && right == null) {
                break;
            } else {
                if (left == null || right == null) {
                    max = Math.max(max, 1);
                } else {
                    max = Math.max(max, right - left + 1);
                }
            }

        }

        return max;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new MaximumWidthOfBinaryTreeModified().widthOfBinaryTree(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new MaximumWidthOfBinaryTreeModified().new TreeNode(Integer.parseInt(item));
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
                node.left = new MaximumWidthOfBinaryTreeModified().new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new MaximumWidthOfBinaryTreeModified().new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}