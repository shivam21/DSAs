package binaryTree;

public class DeepestLeft {

    public static int deepestLeft(BinaryTreeNode<Integer> root) {
        return findDeepestLeft(root, 0, new Pair<>(Integer.MIN_VALUE, 0), -1).first;

    }

    private static Pair<Integer, Integer> findDeepestLeft(BinaryTreeNode<Integer> root, int height, Pair<Integer, Integer> max, int direction) {
        if (root == null)
            return max;
        if (direction == 0 && root.left == null && root.right == null) {
            if (max.second < height) {
                max.first = root.data;
                max.second = height;
                return max;
            } else if (max.second == height) {
                if (max.first < root.data) {
                    max.first = root.data;
                }
                return max;
            }
        }
        Pair<Integer, Integer> leftTree = findDeepestLeft(root.left, height + 1, max, 0);
        Pair<Integer, Integer> rightTree = findDeepestLeft(root.right, height + 1, max, 1);
        if (leftTree.second.equals(rightTree.second)) {
            if (rightTree.first > leftTree.first)
                return rightTree;
            else
                return leftTree;
        } else if (rightTree.second > leftTree.second)
            return rightTree;
        return leftTree;
    }

}
