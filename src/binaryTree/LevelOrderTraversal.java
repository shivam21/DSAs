package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<>(null);
        q.add(nullNode);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node == nullNode) {
                System.out.println("\n");
                if(!q.isEmpty())
                    q.add(nullNode);
            } else {
                System.out.print(node.data + " ");
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

    }
}
