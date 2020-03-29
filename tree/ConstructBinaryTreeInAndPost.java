package leetcode.tree;

/**
 * ConstructBinaryTreeInAndPost
 */
public class ConstructBinaryTreeInAndPost {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int postOrderIndex = 0;

    public TreeNode buildTree(int[] postorder, int[] inorder) {

        postOrderIndex = postorder.length - 1;

        return buildTree(postorder, inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int element = postorder[postOrderIndex--];

        int position = getElementPosition(inorder, element);

        TreeNode node = new TreeNode(element);

        node.right = buildTree(postorder, inorder, position + 1, end);
        node.left = buildTree(postorder, inorder, start, position - 1);

        return node;

    }

    private int getElementPosition(int[] inorder, int element) {

        int position = 0;
        while (inorder[position] != element) {
            position++;
        }

        return position;
    }

    public static void main(String[] args) {

        int[] postorder = new int[] { 9, 15, 7, 20, 3 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };

        TreeNode node = new ConstructBinaryTreeInAndPost().buildTree(postorder, inorder);

        int a = 5;

    }
}