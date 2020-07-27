package leetcode.tree;

/*https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/*/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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

        int position = 0;
        while (inorder[position] != element) {
            position++;
        }

        TreeNode node = new TreeNode(element);

        node.left = buildTree(preorder, inorder, start, position - 1);
        node.right = buildTree(preorder, inorder, position + 1, end);

        return node;

    }
}
