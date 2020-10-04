package binaryTree;

public class PathSumRootToLeaf {
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        printPaths(root, k, 0, "");

    }

    private static void printPaths(BinaryTreeNode<Integer> root, int k, int sum, String currentPath) {
        if (root == null)
            return;
        sum += root.data;
        currentPath += root.data;
        if (sum == k) {
            System.out.println(currentPath);
            return;
        }
        if (sum > k)
            return;
        printPaths(root.left, k, sum, currentPath);
        printPaths(root.right, k, sum, currentPath);
    }
}
