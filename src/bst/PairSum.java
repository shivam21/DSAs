package bst;

import binaryTree.BinaryTreeNode;
import binaryTree.BinaryTreeUse;

import java.util.Stack;

/*Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space only O(log n).
        Assume BST contains all unique elements.
        Note: In a pair, print the smaller element first.
        Input format:

        Line 1: Elements in the level order form (separated by space)

        (If any node does not have left or right child, take -1 in its place)

        Line 2: S

        Output format: Each pair in a different line (pair elements separated by space)*/

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
