package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CousinsInBinaryTree
 */
public class CousinsInBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while (!queue.isEmpty()) {

            boolean isXAdded = false;
            boolean isYAdded = false;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                boolean isSameParent = false;
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                    if (currentNode.left.val == x) {
                        isXAdded = true;
                        isSameParent = true;
                    }
                    if (currentNode.left.val == y) {
                        isYAdded = true;
                        isSameParent = true;
                    }

                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                    if (currentNode.right.val == x && !isSameParent) {
                        isXAdded = true;
                        isSameParent = true;
                    }
                    if (currentNode.right.val == y && !isSameParent) {
                        isYAdded = true;
                        isSameParent = true;
                    }
                }

            }

            if (isXAdded ^ isYAdded) {
                return false;
            }
            if (isXAdded && isYAdded) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int x = Integer.parseInt(line);
            line = in.readLine();
            int y = Integer.parseInt(line);

            boolean ret = new CousinsInBinaryTree().isCousins(root, x, y);

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
        TreeNode root = new CousinsInBinaryTree().new TreeNode(Integer.parseInt(item));
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
                node.left = new CousinsInBinaryTree().new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new CousinsInBinaryTree().new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

}