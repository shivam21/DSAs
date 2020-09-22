package bst;

import binaryTree.BinaryTreeNode;

public class IsBst {

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        //return getIsBstMaxMin(root).first;
        return findIsBstEfficiently(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean findIsBstEfficiently(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null)
            return true;
        boolean isBst = root.data > minValue && root.data < maxValue;
        return isBst && findIsBstEfficiently(root.left, minValue, root.data - 1) && findIsBstEfficiently(root.right, root.data, maxValue);
    }

    private static Triplet<Boolean, Integer, Integer> getIsBstMaxMin(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new Triplet<>(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Triplet<Boolean, Integer, Integer> leftSubTree = getIsBstMaxMin(root.left);
        Triplet<Boolean, Integer, Integer> rightSubTree = getIsBstMaxMin(root.right);
        boolean isBst = root.data > leftSubTree.second && root.data < rightSubTree.third;
        return new Triplet<>(leftSubTree.first && rightSubTree.first && isBst, Math.max(root.data, Math.max(leftSubTree.second, rightSubTree.second)), Math.min(root.data, Math.min(leftSubTree.third, rightSubTree.third)));
    }
}
