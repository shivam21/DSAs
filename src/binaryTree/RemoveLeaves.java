package binaryTree;

public class RemoveLeaves {

    public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return null;
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        return root;

    }
}
