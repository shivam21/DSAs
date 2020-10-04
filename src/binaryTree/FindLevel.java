package binaryTree;

public class FindLevel {
    public static int findLevel(BinaryTreeNode<Integer> root, int M) {
        return findLevelHelper(root, M, 1);

    }

    private static int findLevelHelper(BinaryTreeNode<Integer> root, int m, int level) {
        if (root == null)
            return 0;
        if (root.data == m)
            return level;
        int result = findLevelHelper(root.left, m, level + 1);
        if (result == 0)
            result = findLevelHelper(root.right, m, level + 1);
        return result;
    }
}
