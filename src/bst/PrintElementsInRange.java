package bst;

import binaryTree.BinaryTreeNode;

public class PrintElementsInRange {

    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null)
            return;
        printNodeFromK1ToK2(root.left, k1, k2);
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
        printNodeFromK1ToK2(root.right, k1, k2);
    }

}
