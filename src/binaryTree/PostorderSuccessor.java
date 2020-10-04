package binaryTree;

import java.util.Stack;

public class PostorderSuccessor {

    public static int postOrderSuccessor(BinaryTreeNode<Integer> root, int M) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        boolean isPrintSuccessor = false;
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            BinaryTreeNode<Integer> node = stack.pop();
            if (!stack.isEmpty() && stack.peek() == node) {
                root = node.right;
            } else {
                if (isPrintSuccessor) {
                    return node.data;
                }
                if (node.data == M)
                    isPrintSuccessor = true;
            }
        }
        return -1;
    }

}
