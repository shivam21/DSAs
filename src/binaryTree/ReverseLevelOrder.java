package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {

    public static void reverseLevelOrder(BinaryTreeNode node) {
        if (node == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<BinaryTreeNode> stack=new Stack<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode root = queue.poll();
            stack.push(root);
            if (root.left != null)
                queue.add(root.left);
            if (root.right != null)
                queue.add(root.right);
        }
        StringBuilder result=new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.pop().data).append(" ");
        System.out.println(result.toString().trim());
    }
}
