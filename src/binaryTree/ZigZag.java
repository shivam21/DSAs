package binaryTree;

import java.util.Stack;

import static binaryTree.BinaryTreeUse.takeInput;

public class ZigZag {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        printZigZag(root);
    }

    public static void printZigZag(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode<Integer>> q = new Stack<>();
        Stack<BinaryTreeNode<Integer>> s = new Stack<>();
        q.add(root);
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                BinaryTreeNode<Integer> node = q.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    s.add(node.right);
                }
                if (node.left != null) {
                    s.add(node.left);
                }

            }
            System.out.println();
            while (!s.isEmpty()) {
                BinaryTreeNode<Integer> node = s.pop();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
