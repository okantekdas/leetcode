package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MinimumDepthOfBinaryTree
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int minDepth = 0;

        while (!queue.isEmpty()) {

            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode == null || (currentNode.left == null && currentNode.right == null)) {
                    return minDepth;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);

                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);

                }

            }

        }

        return minDepth;
    }

    static MinimumDepthOfBinaryTree mdobt = new MinimumDepthOfBinaryTree();

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new MinimumDepthOfBinaryTree().minDepth(root);

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
        TreeNode root = mdobt.new TreeNode(Integer.parseInt(item));
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
                node.left = mdobt.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = mdobt.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}