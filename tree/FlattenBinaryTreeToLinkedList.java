package leetcode;

/**
 * FlattenBinaryTreeToLinkedList
 */

public class FlattenBinaryTreeToLinkedList {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
        }

    }

    public static TreeNode flatten(TreeNode root) {

        if (root == null) {
            return null;
        } else {
            TreeNode resultLeft = flatten(root.left);

            TreeNode resultRight = flatten(root.right);

            root.left = null;

            if (resultLeft != null) {
                root.right = resultLeft;
                if (resultRight != null) {
                    TreeNode prev = null;
                    while (resultLeft != null) {
                        prev = resultLeft;
                        resultLeft = resultLeft.right;
                    }
                    prev.right = resultRight;
                }

            } else if (resultRight != null) {
                root.right = resultRight;
            }

            return root;

        }

    }

    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList fbtll = new FlattenBinaryTreeToLinkedList();

        TreeNode node1 = fbtll.new TreeNode(1);
        TreeNode node2 = fbtll.new TreeNode(2);
        TreeNode node3 = fbtll.new TreeNode(3);
        TreeNode node4 = fbtll.new TreeNode(4);
        TreeNode node5 = fbtll.new TreeNode(5);
        TreeNode node6 = fbtll.new TreeNode(6);

        node1.left = node2;
        node1.right = node5;

        node2.left = node3;
        node2.right = node4;

        node5.right = node6;

        TreeNode treeNode = flatten(node1);

        System.out.println(treeNode);

    }
}