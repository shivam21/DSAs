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

    public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
        if ((a <= root.data && b >= root.data) || (a >= root.data && b <= root.data)) {
            return root.data;
        }
        if (a < root.data) {
            return lcaInBST(root.left, a, b);
        }
        return lcaInBST(root.right, a, b);

    }
}
