package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInput();
        printTree(root);
    }

    private static void printTreeRecursive(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        if (root.data == -1)
            return;
        int left = -1;
        if (root.left != null) {
            left = root.left.data;
        }
        int right = -1;
        if (root.right != null) {
            right = root.right.data;
        }
        System.out.println(root.data + ":" + "L" + left + "R" + right);
        printTreeRecursive(root.left);
        printTreeRecursive(root.right);
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            if (node == null)
                continue;
            String s = "" + node.data + ":";
            if (node.left != null) {
                s += "L" + node.left.data;
            }
            if (node.right != null) {
                s += "R" + node.right.data;
            }
            System.out.println(s);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static BinaryTreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        int rootData = s.nextInt();
        if (rootData == -1)
            return null;
        BinaryTreeNode<Integer> topRoot = new BinaryTreeNode<Integer>(rootData);
        queue.add(topRoot);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> root = queue.poll();
            int leftData = s.nextInt();
            if (leftData != -1) {
                root.left = new BinaryTreeNode<Integer>(leftData);
                queue.add(root.left);
            }
            int rightData = s.nextInt();
            if (rightData != -1) {
                root.right = new BinaryTreeNode<Integer>(rightData);
                queue.add(root.right);
            }
        }
        return topRoot;
    }

    private static BinaryTreeNode<Integer> takeInputRecursive(Scanner s) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(s.nextInt());
        if (root.data == -1)
            return null;
        BinaryTreeNode<Integer> left = takeInputRecursive(s);
        BinaryTreeNode<Integer> right = takeInputRecursive(s);
        root.left = left;
        root.right = right;
        return root;
    }
}
