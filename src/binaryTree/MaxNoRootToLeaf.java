package binaryTree;

public class MaxNoRootToLeaf {

    static void maxNumber(BinaryTreeNode<Integer> root) {
        String number = getMaxNumber(root, "");
        System.out.println(number);
    }

    private static String getMaxNumber(BinaryTreeNode<Integer> root, String number) {
        if (root == null)
            return number;
        String left = getMaxNumber(root.left, number + root.data);
        String right = getMaxNumber(root.right, number + root.data);
        if (left.compareTo(right) > 0)
            return left;
        return right;
    }
}
