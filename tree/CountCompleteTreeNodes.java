package leetcode.tree;

/**
 * CountCompleteTreeNodes
 */
public class CountCompleteTreeNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countNodes(TreeNode root) {
        int count = 0;

        if (root == null) {
            return 0;
        } else {
            count = 1 + countNodes(root.left) + countNodes(root.right);

            return count;
        }
    }

    public static void main(String[] args) {

        CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();

        TreeNode node1 = cctn.new TreeNode(1);
        TreeNode node2 = cctn.new TreeNode(2);
        TreeNode node3 = cctn.new TreeNode(3);
        TreeNode node4 = cctn.new TreeNode(4);
        TreeNode node5 = cctn.new TreeNode(5);
        TreeNode node6 = cctn.new TreeNode(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        System.out.println(countNodes(node1));

    }
}