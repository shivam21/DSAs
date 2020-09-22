package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class NodesWithoutSiblings {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<>(null);
        q.add(nullNode);
        int count = 0;
        Integer data = null;
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node == nullNode) {
                if (count == 1 && data != null) {
                    System.out.print(data + " ");
                }
                if (!q.isEmpty())
                    q.add(nullNode);
            } else {
                data = node.data;
                count++;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
    }

}
