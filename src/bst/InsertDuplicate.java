package bst;

import binaryTree.BinaryTreeNode;

public class InsertDuplicate {

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        newNode.left = root.left;
        root.left = newNode;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }
}
