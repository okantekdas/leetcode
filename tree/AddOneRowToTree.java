package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AddOneRowToTree
 */
public class AddOneRowToTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1) {
            TreeNode addedNode = new TreeNode(v);
            addedNode.left = root;
            return addedNode;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;
        boolean isLevelHit = false;

        while (!queue.isEmpty() && !isLevelHit) {

            level++;
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = queue.poll();

                if (level == d - 1) {
                    isLevelHit = true;

                    TreeNode node1 = new TreeNode(v);
                    TreeNode leftNode = currentNode.left;
                    currentNode.left = node1;
                    node1.left = leftNode;

                    TreeNode node2 = new TreeNode(v);
                    TreeNode rightNode = currentNode.right;
                    currentNode.right = node2;
                    node2.right = rightNode;
                } else {
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);

                    }
                }

            }

        }

        return root;

    }

    static AddOneRowToTree aortt = new AddOneRowToTree();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            int v = Integer.parseInt(line);
            line = in.readLine();
            int d = Integer.parseInt(line);

            TreeNode ret = new AddOneRowToTree().addOneRow(root, v, d);

            String out = treeNodeToString(ret);

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
        TreeNode root = aortt.new TreeNode(Integer.parseInt(item));
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
                node.left = aortt.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = aortt.new TreeNode(rightNumber);
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

}