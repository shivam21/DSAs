package binaryTree;

public class SumAtKLevel {

    public static long sumOfNodes(BinaryTreeNode<Integer> root, int k) {
        return sumOfNodesHelper(root, k, 0);
    }

    private static long sumOfNodesHelper(BinaryTreeNode<Integer> root, int k, int sum) {
        if (root == null)
            return 0;
        if (k == 0)
            return sum;
        long leftSum = sumOfNodesHelper(root.left, k, sum);
        long rightSum = sumOfNodesHelper(root.left, k, sum);
        return leftSum + rightSum;
    }
}
