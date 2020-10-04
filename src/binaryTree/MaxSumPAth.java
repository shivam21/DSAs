package binaryTree;

public class MaxSumPAth {

    public static void main(String[] args) {
        maximumSumPath(BinaryTreeUse.takeInput());

    }

    public static void maximumSumPath(BinaryTreeNode<Integer> root) {
        Pair<String, Integer> result = getMaxSumPath(root, "", 0);
        if (result.second > 0)
            System.out.println(result.first.trim());
        else
            System.out.println();
    }

    private static Pair<String, Integer> getMaxSumPath(BinaryTreeNode<Integer> root, String path, Integer sum) {
        if (root == null)
            return new Pair<>(path, sum);
        if (root.left != null && root.right != null) {
            Pair<String, Integer> leftSubTree = getMaxSumPath(root.left, path + " " + root.data, root.data + sum);
            Pair<String, Integer> rightSubTree = getMaxSumPath(root.right, path + " " + root.data, root.data + sum);
            if (leftSubTree.second > rightSubTree.second)
                return leftSubTree;
            return rightSubTree;
        } else if (root.left != null) {
            return getMaxSumPath(root.left, path + " " + root.data, root.data + sum);
        } else if (root.right != null) {
            return getMaxSumPath(root.right, path + " " + root.data, root.data + sum);
        } else {
            return new Pair<>(path + " " + root.data, root.data + sum);
        }
    }
}
