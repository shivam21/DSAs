package binaryTree;

import static binaryTree.BinaryTreeUse.takeInput;

class DiamHeight {
    int diam;
    int height;

    public DiamHeight(int diam, int height) {
        this.diam = diam;
        this.height = height;
    }
}

public class Diameter {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println(findDiameter(root));
    }

    private static int findDiameter(BinaryTreeNode<Integer> root) {
        return findDiamAndHeight(root).diam;
    }

    private static DiamHeight findDiamAndHeight(BinaryTreeNode<Integer> root) {
        if (root == null)
            return new DiamHeight(0, 0);
        DiamHeight leftDiameter = findDiamAndHeight(root.left);
        DiamHeight rightDiameter = findDiamAndHeight(root.right);
        int leftHeight = leftDiameter.height;
        int rightHeight = rightDiameter.height;
        int diameter = leftHeight + rightHeight;
        return new DiamHeight(Math.max(Math.max(leftDiameter.diam, rightDiameter.diam), diameter), 1 + Math.max(leftHeight, rightHeight));
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
