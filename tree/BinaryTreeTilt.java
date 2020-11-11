package leetcode.tree;

/* https://leetcode.com/problems/binary-tree-tilt/ */
/* Runtime: 0 ms, faster than 100.00% */
public class BinaryTreeTilt {

    public class TreeNode {
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

    int tiltSum = 0;
    public int findTilt(TreeNode root) {
        constructTiltTree(root);

        return tiltSum;
    }

    public int constructTiltTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = constructTiltTree(root.left);
        int rightSum = constructTiltTree(root.right);

        int currentVal = root.val;
        root.val = Math.abs(leftSum - rightSum);
        tiltSum += root.val;
        return leftSum + rightSum + currentVal;
    }

    static BinaryTreeTilt btt = new BinaryTreeTilt();

    public static void main(String[] args) {
        TreeNode node4 = btt.new TreeNode(4);
        TreeNode node2 = btt.new TreeNode(2);
        TreeNode node9 = btt.new TreeNode(9);
        TreeNode node3 = btt.new TreeNode(3);
        TreeNode node5 = btt.new TreeNode(5);
        TreeNode node7 = btt.new TreeNode(7);

        node2.left = node3;
        node2.right = node5;

        node9.right = node7;

        node4.left = node2;
        node4.right = node9;

        System.out.println(btt.findTilt(node4));
    }
}
