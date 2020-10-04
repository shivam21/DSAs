package bst;

import binaryTree.BinaryTreeNode;

class Data {
    int height;
    int max;
    int min;
    BinaryTreeNode<Integer> root;

    public Data(int height, int max, int min, BinaryTreeNode<Integer> root) {
        this.height = height;
        this.max = max;
        this.min = min;
        this.root = root;
    }
}

public class LargestBst {

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTSubtreeHelper(root).root.data;
    }

    private static Data largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new Data(0, Integer.MIN_VALUE, Integer.MAX_VALUE, new BinaryTreeNode<>(1));
        Data leftSubTree = largestBSTSubtreeHelper(root.left);
        Data rightSubTree = largestBSTSubtreeHelper(root.right);
        if (root.left == leftSubTree.root && root.right == rightSubTree.root && root.data > leftSubTree.max && root.data <= rightSubTree.min) {
            if (rightSubTree.height > leftSubTree.height) {
                return new Data(1 + rightSubTree.height, Math.max(root.data, Math.max(rightSubTree.max, leftSubTree.max)),Math.min(root.data, Math.min(rightSubTree.min, leftSubTree.min)), root);
            }
            return new Data(1 + leftSubTree.height, Math.max(root.data, Math.max(rightSubTree.max, leftSubTree.max)), Math.min(root.data, Math.min(rightSubTree.min, leftSubTree.min)), root);
        }
        if (rightSubTree.height > leftSubTree.height)
            return new Data(rightSubTree.height, Math.max(rightSubTree.max, leftSubTree.max), Math.min(rightSubTree.min, leftSubTree.min), rightSubTree.root);
        return new Data(leftSubTree.height, Math.max(rightSubTree.max, leftSubTree.max), Math.min(rightSubTree.min, leftSubTree.min), leftSubTree.root);
    }
}
