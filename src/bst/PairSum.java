package bst;

import binaryTree.BinaryTreeNode;
import binaryTree.BinaryTreeUse;

import java.util.Stack;

public class PairSum {

    public static void main(String[] args) {
        printNodesSumToS(BinaryTreeUse.takeInput(), 1119);
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null)
            return;
        Stack<BinaryTreeNode<Integer>> inOrder = new Stack<>();
        Stack<BinaryTreeNode<Integer>> reverseInOrder = new Stack<>();
        BinaryTreeNode<Integer> left = root;
        BinaryTreeNode<Integer> right = root;
        boolean isLeftChanged = true;
        boolean isRightChanged = true;
        while (true) {
            BinaryTreeNode<Integer> current;
            if (isLeftChanged) {
                current = left;
                while (current != null) {
                    inOrder.add(current);
                    current = current.left;
                }
            }
            if (isRightChanged) {
                current = right;
                while (current != null) {
                    reverseInOrder.add(current);
                    current = current.right;
                }
            }
            if (inOrder.isEmpty() && reverseInOrder.isEmpty())
            break;
            if (isLeftChanged)
                left = inOrder.pop();
            if (isRightChanged)
                right = reverseInOrder.pop();
            if (left == null || right == null || left.data >= right.data)
                break;
            int sum = left.data + right.data;
            if (sum > s) {
                isRightChanged = true;
                isLeftChanged = false;
                right = right.left;
            } else if (sum < s) {
                isRightChanged = false;
                isLeftChanged = true;
                left = left.right;
            } else {
                isRightChanged = true;
                isLeftChanged = true;
                System.out.println(left.data + " " + right.data);
                right = right.left;
                left = left.right;
            }


        }

    }


}
