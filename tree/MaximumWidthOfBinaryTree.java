package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * MaximumWidthOfBinaryTree
 */
public class MaximumWidthOfBinaryTree {

    class TreeNode {
        int index;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        root.index = 0;
        queue.add(root);

        int maxWidth = 0;
        int leftIndex = -1;
        int rightIndex = -1;

        while (!queue.isEmpty()) {

            int levelWidth = rightIndex - leftIndex + 1;
            if (levelWidth > maxWidth) {
                maxWidth = levelWidth;
            }

            // System.out.println("Level Width: " + levelWidth + " Max Widht: " + maxWidth);

            leftIndex = -1;
            rightIndex = -1;

            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                int currentIndex = currentNode.index * 2;

                if (currentNode.left != null) {
                    if (leftIndex < 0) {
                        leftIndex = currentIndex;
                    }
                    if (currentIndex > rightIndex) {
                        rightIndex = currentIndex;
                    }
                    currentNode.left.index = currentIndex;
                    queue.add(currentNode.left);
                }
                currentIndex++;

                if (currentNode.right != null) {
                    if (leftIndex < 0) {
                        leftIndex = currentIndex;
                    }
                    if (currentIndex > rightIndex) {
                        rightIndex = currentIndex;
                    }
                    currentNode.right.index = currentIndex;
                    queue.add(currentNode.right);
                }

            }
            if (leftIndex == -1 && rightIndex == -1) {
                break;
            }

        }

        return maxWidth;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new MaximumWidthOfBinaryTree().widthOfBinaryTree(root);

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
        TreeNode root = new MaximumWidthOfBinaryTree().new TreeNode(Integer.parseInt(item));
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
                node.left = new MaximumWidthOfBinaryTree().new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new MaximumWidthOfBinaryTree().new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}