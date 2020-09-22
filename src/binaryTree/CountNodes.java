package binaryTree;

import static binaryTree.BinaryTreeUse.takeInput;

public class CountNodes {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println(countNodes(root));
    }

    private static int countNodes(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
