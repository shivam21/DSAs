package binaryTree;


//For a given binary tree, convert it to its sum tree.
// That is, replace every node data with sum of its immediate children,
// keeping leaf nodes 0. Finally, return its preorder.

import java.util.ArrayList;

public class SumTree {

    public static ArrayList<Integer> sumTree(BinaryTreeNode<Integer> root) {
        getSumTree(root);
        ArrayList<Integer> result = new ArrayList<>();
        getPreOrder(root, result);
        return result;
    }

    private static void getPreOrder(BinaryTreeNode<Integer> root, ArrayList<Integer> result) {
        if (root == null)
            return;
        result.add(root.data);
        getPreOrder(root.left, result);
        getPreOrder(root.right, result);
    }

    private static void getSumTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        int sum = 0;
        if (root.left != null)
            sum += root.left.data;
        if (root.right != null)
            sum += root.right.data;
        root.data = sum;
        getSumTree(root.left);
        getSumTree(root.right);
    }

}
