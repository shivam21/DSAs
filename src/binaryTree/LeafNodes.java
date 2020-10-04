package binaryTree;

public class LeafNodes {

    static void printleaf(BinaryTreeNode<Integer> root, int target) {
        root = findNode(root, target);
        printLeaves(root);
    }

    private static void printLeaves(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            System.out.println(root.data);
        printLeaves(root.left);
        printLeaves(root.right);
    }

    private static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int target) {
        if (root == null)
            return null;
        if (root.data == target)
            return root;
        BinaryTreeNode<Integer> left = findNode(root.left, target);
        if (left == null)
            return findNode(root.right, target);
        return left;
    }
}
