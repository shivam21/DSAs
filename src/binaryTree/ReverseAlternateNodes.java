package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAlternateNodes {

    public static void reverseAltLevels(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(root.left);
            }
            if (node.right != null) {
                queue.add(root.right);
            }
        }
    }

}
