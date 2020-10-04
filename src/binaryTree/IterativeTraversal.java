package binaryTree;

import java.util.Stack;

import static binaryTree.BinaryTreeUse.takeInput;


public class IterativeTraversal {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        printPostOrderBetter(root);
    }

    private static void printPreOrder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            BinaryTreeNode<Integer> node = stack.pop();
            root = node.right;
        }
    }

    private static void printInOrder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            BinaryTreeNode<Integer> node = stack.pop();
            System.out.println(node.data);
            root = node.right;
        }
    }

    private static void printPostOrder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        Stack<BinaryTreeNode<Integer>> printStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> node = stack.pop();
            printStack.add(node);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        while (!printStack.isEmpty())
            System.out.println(printStack.pop().data);
    }

    private static void printPostOrderBetter(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            BinaryTreeNode<Integer> node = stack.pop();
            if (!stack.isEmpty() && stack.peek() == node)
                root = node.right;
            else
                System.out.println(node.data);
        }
    }


}
