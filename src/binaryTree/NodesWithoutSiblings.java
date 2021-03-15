package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*For a given Binary Tree of type integer, print all the nodes without any siblings.
        Input Format:
        The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
        Output Format:
        The only line of output prints the node data in a top to down fashion with reference to the root.
        Node data in the left subtree will be printed first and then the right subtree.
        A single space will separate them all.*/

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
