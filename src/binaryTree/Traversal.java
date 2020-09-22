package binaryTree;

import trees.TreeNode;

import static binaryTree.BinaryTreeUse.takeInput;

public class Traversal {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        postOrderTraversal(root);
    }

    private static void inOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,
                                                                        int[] in) {
        return getTreeFromPreorderAndInorder(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preEnd)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(pre[preStart]);
        int inOrderRootIndex = -1;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] == pre[preStart]) {
                inOrderRootIndex = i;
                break;
            }
        }
        if (inOrderRootIndex == -1) {
            return null;
        }
        int leftCount = (inOrderRootIndex - inStart);
        root.left = getTreeFromPreorderAndInorder(pre, in, preStart + 1, preStart + leftCount, inStart, inOrderRootIndex - 1);
        root.right = getTreeFromPreorderAndInorder(pre, in, preStart + leftCount + 1, preEnd, inOrderRootIndex + 1, inEnd);
        return root;
    }

}
