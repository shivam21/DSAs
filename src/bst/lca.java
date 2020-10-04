package bst;

import binaryTree.BinaryTreeNode;

public class lca {

    public static int lcaBinaryTree(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null)
            return -1;
        if (root.data == a || root.data == b)
            return root.data;
        int leftSubTree = lcaBinaryTree(root.left, a, b);
        int rightSubTree = lcaBinaryTree(root.right, a, b);
        if (leftSubTree == -1 && rightSubTree == -1)
            return -1;
        if (leftSubTree == -1)
            return rightSubTree;
        if (rightSubTree == -1)
            return leftSubTree;
        return root.data;
    }

    public static int lcaInBST(BinaryTreeNode<Integer> root, int a, int b) {
        if ((a <= root.data && b >= root.data) || (a >= root.data && b <= root.data)) {
            return root.data;
        }
        if (a < root.data) {
            return lcaInBST(root.left, a, b);
        }
        return lcaInBST(root.right, a, b);

    }

    static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int data1, int data2, int data3) {
        if (root == null)
            return null;
        if (root.data == data1 || root.data == data2 || root.data == data3)
            return root;
        BinaryTreeNode<Integer> leftSubTree = lca(root.left, data1, data2, data3);
        BinaryTreeNode<Integer> rightSubTree = lca(root.right, data1, data2, data3);
        if (leftSubTree == null && rightSubTree == null)
            return null;
        if (leftSubTree == null)
            return rightSubTree;
        if (rightSubTree == null)
            return leftSubTree;
        return root;
    }
}
