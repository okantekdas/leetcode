package leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        return initializeTree(preorder, 0, preorder.length - 1);
    }

    int index = 0;

    public TreeNode initializeTree(int[] preorder, int left, int right) {
        if (left == right) {
            return new TreeNode(preorder[left]);
        }
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left++]);

        int i = left;
        while (i < preorder.length && root.val > preorder[i]) {
            i++;
        }

        root.left = initializeTree(preorder, left, i - 1);
        root.right = initializeTree(preorder, i, right);

        return root;

    }

    static ConstructBinarySearchTreeFromPreorderTraversal cbs = new ConstructBinarySearchTreeFromPreorderTraversal();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] preorder = stringToIntegerArray(line);

            TreeNode ret = cbs.bstFromPreorder(preorder);

            String out = treeNodeToString(ret);

            System.out.print(out);
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
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