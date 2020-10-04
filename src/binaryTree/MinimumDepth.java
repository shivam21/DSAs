package binaryTree;

public class MinimumDepth {

    public static int minimumDepth(BinaryTreeNode<Integer> root) {
        return getMinDepth(root, 0);
    }

    private static int getMinDepth(BinaryTreeNode<Integer> root, int depth) {
        if (root == null)
            return depth;
        int left = getMinDepth(root.left, depth + 1);
        if (root.right != null) {
            int right = getMinDepth(root.right, depth + 1);
            return Math.min(left, right);
        }
        return left;
    }

}
