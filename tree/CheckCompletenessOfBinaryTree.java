package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CheckCompletenessOfBinaryTree
 */
public class CheckCompletenessOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {

            boolean isSizeMatch = true;
            int currentSize = queue.size();
            int completenesSize = (int) Math.pow(2, level);
            if (currentSize != completenesSize) {
                isSizeMatch = false;
            }

            boolean isLeftEmpty = false;
            for (int i = 0; i < currentSize; i++) {

                TreeNode currentNode = queue.poll();

                if (currentNode.left == null) {
                    isLeftEmpty = true;
                } else {
                    if (!isSizeMatch || isLeftEmpty) {
                        return false;
                    }

                    queue.add(currentNode.left);
                }
                if (isLeftEmpty && currentNode.right != null) {
                    return false;
                }
                if (currentNode.right == null) {
                    isLeftEmpty = true;
                } else {
                    if (!isSizeMatch || isLeftEmpty) {
                        return false;
                    }
                    queue.add(currentNode.right);
                }

            }
            level++;
        }

        return true;
    }

    static CheckCompletenessOfBinaryTree ccobt = new CheckCompletenessOfBinaryTree();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = ccobt.isCompleteTree(root);

            String out = booleanToString(ret);

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
        TreeNode root = ccobt.new TreeNode(Integer.parseInt(item));
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
                node.left = ccobt.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = ccobt.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

}