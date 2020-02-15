package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * DeleteNodeInBST
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode current, int key) {

        if (current == null) {
            return null;
        }

        if (current.val == key) {
            TreeNode temp = null;
            if (current.left != null) {
                temp = current.left;
                TreeNode rightSmallest = findSmallest(current.right);
                if (rightSmallest != null && temp != null) {
                    rightSmallest.left = temp.right;
                    temp.right = current.right;
                }

            } else {
                temp = current.right;
            }

            return temp;
        }

        if (key < current.val) {
            TreeNode leftNode = deleteNode(current.left, key);
            current.left = leftNode;
        }

        if (current.val < key) {
            TreeNode rightNode = deleteNode(current.right, key);
            current.right = rightNode;
        }

        return current;

    }

    public TreeNode findSmallest(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }

        return findSmallest(root.left);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
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
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int key = Integer.parseInt(line);

            TreeNode ret = new DeleteNodeInBST().deleteNode(root, key);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }

}