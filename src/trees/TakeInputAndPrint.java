package trees;

import java.util.Scanner;

public class TakeInputAndPrint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(s);
        printTree(root);
    }

    private static void printTree(TreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + ":");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            printTree(root.children.get(i));
        }
    }

    private static TreeNode<Integer> takeInput(Scanner s) {
        System.out.println("enter node data");
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        System.out.println("Enter no of children");
        int childCount = s.nextInt();
        for (int i = 0; i < childCount; i++) {
            root.children.add(takeInput(s));
        }
        return root;
    }
}
