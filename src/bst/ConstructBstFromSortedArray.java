package bst;

import binaryTree.BinaryTreeNode;

public class ConstructBstFromSortedArray {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {
        return createBst(arr, 0, arr.length - 1);

    }

    private static BinaryTreeNode<Integer> createBst(int[] arr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        int rootData = arr[mid];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = createBst(arr, start, mid - 1);
        root.right = createBst(arr, mid + 1, end);
        return root;
    }
}
