package binaryTree;

public class IsOneLevelApart {

    static boolean isApart(BinaryTreeNode<Integer> node) {
        Pair<Integer, Integer> maxMinPair = height(node, 0);
        return (maxMinPair.first - maxMinPair.second) <= 1;
    }

    private static Pair<Integer, Integer> height(BinaryTreeNode<Integer> root, int height) {
        if (root == null)
            return new Pair<>(height, height);
        Pair<Integer, Integer> leftHeight = height(root.left, height + 1);
        Pair<Integer, Integer> rightHeight = height(root.right, height + 1);
        return new Pair<>(Math.max(leftHeight.first, rightHeight.first), Math.min(leftHeight.second, rightHeight.second));

    }
}
