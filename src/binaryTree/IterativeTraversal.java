package binaryTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.TimeZone;

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

    public static long getFlashEndDate(String date) {


        TimeZone timeZone = TimeZone.getDefault();
        String timeZoneId = timeZone.getID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZZZZ");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        try {
            d = output.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = output.format(d);
        long endTime = d.getTime();

        return endTime;
    }

    public static Date getDate(String date) {
       

        TimeZone timeZone = TimeZone.getDefault();
        String timeZoneId = timeZone.getID();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZZZZ");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        try {
            d = output.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String formattedTime = output.format(d);
        long endTime = d.getTime();

        return d;
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
