package binaryTree;

import linkedlists.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelWiseLL {

    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Node<BinaryTreeNode<Integer>>> list = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        Node<BinaryTreeNode<Integer>> head = null;
        Node<BinaryTreeNode<Integer>> headTop=null;
        q.add(root);
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<>(null);
        q.add(nullNode);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node == nullNode) {
                list.add(headTop);
                head = null;
                if (!q.isEmpty())
                    q.add(nullNode);
            } else {
                if (head == null) {
                    head = new Node<>(node);
                    headTop=head;
                } else {
                    head.next = new Node<>(node);
                    head = head.next;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return list;
    }
}
