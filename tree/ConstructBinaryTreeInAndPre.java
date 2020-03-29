package leetcode.tree;

/**
 * ConstructBinaryTree
 */
public class ConstructBinaryTreeInAndPre {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        int element = preorder[preOrderIndex++];

        int position = getElementPosition(inorder, element);

        TreeNode node = new TreeNode(element);

        node.left = buildTree(preorder, inorder, start, position - 1);
        node.right = buildTree(preorder, inorder, position + 1, end);

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
        int[] preorder = new int[] { 3, 9, 20, 15, 7 };
        int[] inorder = new int[] { 9, 3, 15, 20, 7 };

        TreeNode node = new ConstructBinaryTreeInAndPre().buildTree(preorder, inorder);

        int a = 5;

        // preorder = [3,9,20,15,7]
        // inorder = [9,3,15,20,7]
        // postorder =[9,15,7,20,3]

    }
}