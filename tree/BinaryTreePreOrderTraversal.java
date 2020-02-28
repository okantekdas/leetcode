package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//   Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * BinaryTreePreOrderTraversal
 */
public class BinaryTreePreOrderTraversal {

    static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return null;
        } else {
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

        }

        return list;

    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        List<Integer> result = preorderTraversal(node1);

        System.out.println(Arrays.toString(result.toArray()));

    }
}