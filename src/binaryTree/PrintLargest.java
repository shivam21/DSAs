package binaryTree;

import java.util.ArrayList;
import java.util.Comparator;

public class PrintLargest {
    public static void main(String[] args) {
        printlargest(BinaryTreeUse.takeInput());
    }

    static void printlargest(BinaryTreeNode<Integer> root) {
        ArrayList<String> list = new ArrayList<>();
        printLargestHelper(root, list);

        System.out.println(list);
    }

    private static ArrayList<String> printLargestHelper(BinaryTreeNode<Integer> root, ArrayList<String> list) {
        if (root == null)
            return list;
        list.add(String.valueOf(root.data));
        ArrayList<String> leftList = printLargestHelper(root.left, list);
        ArrayList<String> rightList = printLargestHelper(root.right, list);
        return leftList;
    }


}
