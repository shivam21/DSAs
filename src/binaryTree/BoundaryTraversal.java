package binaryTree;

import java.util.Stack;

public class BoundaryTraversal {

    public static void solve(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> top = root;
        if (root.right != null)
            stack.add(root.right);
        while (root != null) {
            if (root.left != null || root.right != null)
                System.out.println(root.data);
            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
        printLeaf(top);
        root = stack.pop();
        while (root != null) {
            stack.push(root);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root.left != null || root.right != null)
                System.out.println(root.data);
        }

    }

    private static void printLeaf(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        if (root.left != null && root.right != null)
            System.out.println(root);
        printLeaf(root.left);
        printLeaf(root.right);
    }
}
