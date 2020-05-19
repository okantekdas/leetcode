package leetcode.tree;

/* https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/ */
public class RecoverATreeFromPreorderTraversal {

    class TreeNode {
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

    public TreeNode recoverFromPreorder(String S) {

        return traversePreorder(new StringBuilder(S), 0);

    }

    public TreeNode traversePreorder(StringBuilder strBuilder, int level) {
        if (strBuilder.length() == 0) {
            return null;
        }

        int currentVal = getValue(strBuilder);

        TreeNode node = new TreeNode(currentVal);

        int nextLevel = getNextLevel(strBuilder);

        if (nextLevel <= level) {
            return node;
        }

        strBuilder.delete(0, nextLevel);

        node.left = traversePreorder(strBuilder, level + 1);

        nextLevel = getNextLevel(strBuilder);

        if (nextLevel <= level) {
            return node;
        }

        strBuilder.delete(0, nextLevel);

        node.right = traversePreorder(strBuilder, level + 1);

        return node;

    }

    public int getValue(StringBuilder strBuilder) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) != '-') {
                temp.append(strBuilder.charAt(i));
            } else {
                strBuilder.delete(0, i);
                break;
            }
        }

        return Integer.valueOf(temp.toString());

    }

    public int getNextLevel(StringBuilder strBuilder) {
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) != '-') {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        new RecoverATreeFromPreorderTraversal().recoverFromPreorder("1-2--3--4-5--6--7");
    }

}