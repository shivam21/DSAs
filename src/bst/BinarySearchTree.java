package bst;

import binaryTree.BinaryTreeNode;

public class BinarySearchTree {

    private BinaryTreeNode<Integer> root;

    public void insertData(int input) {
        root = insertDataHelper(root, input);
    }

    private BinaryTreeNode<Integer> insertDataHelper(BinaryTreeNode<Integer> root, int input) {
        if (root == null) {
            return new BinaryTreeNode<>(input);
        }
        if (input < root.data)
            root.left = insertDataHelper(root.left, input);
        else
            root.right = insertDataHelper(root.right, input);
        return root;
    }

    public void deleteData(int input) {
        root = deleteDataHelper(root, input);
    }

    private BinaryTreeNode<Integer> deleteDataHelper(BinaryTreeNode<Integer> root, int input) {
        if (root.data == input) {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            BinaryTreeNode<Integer> node = findSmallest(root.right);
            node.left = root.left;
            node.right = root.right;
            return node;
        }
        if (input < root.data)
            root.left = deleteDataHelper(root.left, input);
        else
            root.right = deleteDataHelper(root.right, input);
        return root;
    }

    private BinaryTreeNode<Integer> findSmallest(BinaryTreeNode<Integer> root) {
        if (root == null)
            return null;
        while(root.left!=null&&root.left.left!=null){
            root=root.left;
        }
        BinaryTreeNode<Integer> smallest = root.left;
        root.left=null;
        return smallest;
    }

    public void printTree() {
        printTreeHelper(root);
    }

    private void printTreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        String s = "" + root.data + ":";
        if (root.left != null)
            s += "L:" + root.left.data;
        if (root.right != null)
            s += "R:" + root.right.data;
        System.out.println(s);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    public boolean search(int input) {
        return searchHelper(root, input);
    }

    private boolean searchHelper(BinaryTreeNode<Integer> root, int input) {
        if (root == null)
            return false;
        if (root.data == input)
            return true;
        if (input < root.data)
            return searchHelper(root.left, input);
        return searchHelper(root.right, input);
    }
}
